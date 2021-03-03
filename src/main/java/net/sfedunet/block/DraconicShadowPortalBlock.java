package net.sfedunet.block;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.sfedunet.world.dimension.DraconicShadow;

import java.util.Objects;

public class DraconicShadowPortalBlock extends Block {

    public DraconicShadowPortalBlock() {
        super(FabricBlockSettings.copyOf(Blocks.BEDROCK).sounds(BlockSoundGroup.GLASS).luminance(14).noCollision());
    }


    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world instanceof ServerWorld && !entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals() && VoxelShapes.matchesAnywhere(VoxelShapes.cuboid(entity.getBoundingBox().offset((-pos.getX()), (-pos.getY()), (-pos.getZ()))), state.getOutlineShape(world, pos), BooleanBiFunction.AND)) {

            ServerWorld draconicShadow = Objects.requireNonNull(world.getServer()).getWorld(DraconicShadow.DRACONIC_SHADOW);
            if(entity instanceof PlayerEntity){
                FabricDimensions.teleport(entity, draconicShadow, new TeleportTarget(new Vec3d(0.5f, 65, 0.5f), new Vec3d(0, 0, 0), entity.yaw, entity.pitch));
                assert draconicShadow != null;
                createPlatform(draconicShadow);

            }
        }
    }

    void createPlatform(World world){
        BlockPos blockPos = new BlockPos(0, 63, 0);
        BlockState blockState = Blocks.BEDROCK.getDefaultState();

        for (int x = -1; x <= 1; x++)
            for (int z = -1; z <= 1; z++)
                world.setBlockState(blockPos.add(x, -1, z), blockState);

    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }


}
