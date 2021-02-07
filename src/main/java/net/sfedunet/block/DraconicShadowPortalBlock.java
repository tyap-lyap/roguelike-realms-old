package net.sfedunet.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.*;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.WorldProperties;
import net.minecraft.world.biome.source.BiomeAccess;
import net.sfedunet.world.dimension.DraconicShadow;

public class DraconicShadowPortalBlock extends Block {

    public DraconicShadowPortalBlock() {
        super(FabricBlockSettings.copyOf(Blocks.BEDROCK).noCollision());
    }


    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world instanceof ServerWorld && !entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals() && VoxelShapes.matchesAnywhere(VoxelShapes.cuboid(entity.getBoundingBox().offset((-pos.getX()), (-pos.getY()), (-pos.getZ()))), state.getOutlineShape(world, pos), BooleanBiFunction.AND)) {

            if(entity instanceof PlayerEntity){
                moveEntity(world, (ServerPlayerEntity) entity);

            }
        }
    }

    public void moveEntity(World world, ServerPlayerEntity serverPlayerEntity) {
        RegistryKey<World> registryKey = DraconicShadow.DRACONIC_SHADOW;
        ServerWorld destination = ((ServerWorld) world).getServer().getWorld(registryKey);
        ServerWorld currentWorld = (ServerWorld) serverPlayerEntity.world;

        assert destination != null;
        if (currentWorld.getRegistryKey() != destination.getRegistryKey()) {
            moveToDimension(destination, serverPlayerEntity);
        } else {
            serverPlayerEntity.sendMessage(new LiteralText("you can't go back b1tc4"), true);
        }

    }


    private void moveToDimension(ServerWorld destination, ServerPlayerEntity player) {
        ServerWorld origin = player.getServerWorld();
        WorldProperties worldProperties = destination.getLevelProperties();
        player.networkHandler.sendPacket(new PlayerRespawnS2CPacket(destination.getDimension(), destination.getRegistryKey(), BiomeAccess.hashSeed(destination.getSeed()), player.interactionManager.getGameMode(), player.interactionManager.getPreviousGameMode(), destination.isDebugWorld(), destination.isFlat(), true));
        player.networkHandler.sendPacket(new DifficultyS2CPacket(worldProperties.getDifficulty(), worldProperties.isDifficultyLocked()));
        PlayerManager playerManager = player.server.getPlayerManager();
        playerManager.sendCommandTree(player);
        origin.removePlayer(player);
        player.removed = false;

        origin.getProfiler().pop();
        origin.getProfiler().push("placing");
        player.setWorld(destination);
        destination.onPlayerChangeDimension(player);
        player.refreshPositionAfterTeleport(0.5f, 65, 0.5f);
        createPlatform(destination);
        origin.getProfiler().pop();
        worldChanged(origin, player);
        player.interactionManager.setWorld(destination);
        player.networkHandler.sendPacket(new PlayerAbilitiesS2CPacket(player.abilities));
        playerManager.sendWorldInfo(player, destination);
        playerManager.sendPlayerStatus(player);

        for (StatusEffectInstance statusEffectInstance : player.getStatusEffects()) {
            player.networkHandler.sendPacket(new EntityStatusEffectS2CPacket(player.getEntityId(), statusEffectInstance));
        }

        player.networkHandler.sendPacket(new WorldEventS2CPacket(1032, BlockPos.ORIGIN, 0, false));

    }

    private static void worldChanged(ServerWorld origin, ServerPlayerEntity player) {
        RegistryKey<World> registryKey = origin.getRegistryKey();
        RegistryKey<World> registryKey2 = player.world.getRegistryKey();
        Criteria.CHANGED_DIMENSION.trigger(player, registryKey, registryKey2);
    }

    void createPlatform(World world){
        BlockPos blockPos = new BlockPos(0, 63, 0);
        BlockState blockState = Blocks.BEDROCK.getDefaultState();
        world.setBlockState(blockPos, blockState);
        world.setBlockState(blockPos.add(1, 0, 0), blockState);
        world.setBlockState(blockPos.add(-1, 0, 0), blockState);
        world.setBlockState(blockPos.add(0, 0, 1), blockState);
        world.setBlockState(blockPos.add(0, 0, -1), blockState);
        world.setBlockState(blockPos.add(1, 0, 1), blockState);
        world.setBlockState(blockPos.add(1, 0, 1), blockState);
        world.setBlockState(blockPos.add(-1, 0, -1), blockState);
        world.setBlockState(blockPos.add(1, 0, -1), blockState);
        world.setBlockState(blockPos.add(-1, 0, 1), blockState);
    }


}
