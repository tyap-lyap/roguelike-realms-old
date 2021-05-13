package net.sfedunet.roguelikerealms.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.sfedunet.roguelikerealms.block.base.BaseBlock;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class EmeraldPedestal extends BaseBlock {

    private static final VoxelShape SHAPE;

    public EmeraldPedestal() {
        super(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).sounds(BlockSoundGroup.METAL), "custom_model");
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        world.getBlockTickScheduler().schedule(pos, this, 0);
        if (checkFrame(world, pos)){
            createPortal(world, pos);
            world.playSound(null, pos, SoundEvents.BLOCK_END_PORTAL_SPAWN, SoundCategory.BLOCKS, 1, 1);
        }
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        destroyPortal((World) world, pos);
    }
    

    private boolean checkFrame(World world, BlockPos pos) {
        Block dragonScales = RoguelikeRealmsBlocks.DRAGON_SCALES_BLOCK;
        Block glidedDragonScales = RoguelikeRealmsBlocks.GILDED_DRAGON_SCALES_BLOCK;
        Block goldBlock = Blocks.GOLD_BLOCK;

        return world.getBlockState(pos.add(0, -1, 0)).getBlock() == dragonScales && world.getBlockState(pos.add(0, -2, 0)).getBlock() == dragonScales && world.getBlockState(pos.add(0, -2, 1)).getBlock() == dragonScales && world.getBlockState(pos.add(0, -2, -1)).getBlock() == dragonScales && world.getBlockState(pos.add(1, -2, 0)).getBlock() == dragonScales && world.getBlockState(pos.add(-1, -2, 0)).getBlock() == dragonScales && world.getBlockState(pos.add(1, -2, 1)).getBlock() == dragonScales && world.getBlockState(pos.add(-1, -2, 1)).getBlock() == dragonScales && world.getBlockState(pos.add(1, -2, -1)).getBlock() == dragonScales && world.getBlockState(pos.add(-1, -2, -1)).getBlock() == dragonScales && /*Основание 0 уровень*/
                world.getBlockState(pos.add(2, -1, 0)).getBlock() == dragonScales && world.getBlockState(pos.add(2, -1, -1)).getBlock() == dragonScales && world.getBlockState(pos.add(2, -1, -2)).getBlock() == dragonScales && world.getBlockState(pos.add(1, -1, -2)).getBlock() == dragonScales && world.getBlockState(pos.add(0, -1, -2)).getBlock() == dragonScales && world.getBlockState(pos.add(-1, -1, -2)).getBlock() == dragonScales && world.getBlockState(pos.add(-2, -1, -2)).getBlock() == dragonScales && world.getBlockState(pos.add(-2, -1, -1)).getBlock() == dragonScales && world.getBlockState(pos.add(-2, -1, 0)).getBlock() == dragonScales && world.getBlockState(pos.add(-2, -1, 1)).getBlock() == dragonScales && world.getBlockState(pos.add(-2, -1, 2)).getBlock() == dragonScales && world.getBlockState(pos.add(-1, -1, 2)).getBlock() == dragonScales && world.getBlockState(pos.add(0, -1, 2)).getBlock() == dragonScales && world.getBlockState(pos.add(1, -1, 2)).getBlock() == dragonScales && world.getBlockState(pos.add(2, -1, 2)).getBlock() == dragonScales && world.getBlockState(pos.add(2, -1, 1)).getBlock() == dragonScales && /*Осноание уровень 1*/
                world.getBlockState(pos.add(-2, 0, -2)).getBlock() == glidedDragonScales && world.getBlockState(pos.add(-2, 0, -1)).getBlock() == dragonScales && world.getBlockState(pos.add(-2, 0, 1)).getBlock() == dragonScales && world.getBlockState(pos.add(-2, 0, 2)).getBlock() == glidedDragonScales && world.getBlockState(pos.add(-1, 0, 2)).getBlock() == dragonScales && world.getBlockState(pos.add(1, 0, 2)).getBlock() == dragonScales && world.getBlockState(pos.add(2, 0, 2)).getBlock() == glidedDragonScales && world.getBlockState(pos.add(2, 0, 1)).getBlock() == dragonScales && world.getBlockState(pos.add(2, 0, -1)).getBlock() == dragonScales && world.getBlockState(pos.add(2, 0, -2)).getBlock() == glidedDragonScales && world.getBlockState(pos.add(1, 0, -2)).getBlock() == dragonScales && world.getBlockState(pos.add(-1, 0, -2)).getBlock() == dragonScales && /* Основание 2 уровень*/
                world.getBlockState(pos.add(-2, 1, -2)).getBlock() == goldBlock && world.getBlockState(pos.add(-2, 1, 2)).getBlock() == goldBlock && world.getBlockState(pos.add(2, 1, 2)).getBlock() == goldBlock && world.getBlockState(pos.add(2, 1, -2)).getBlock() == goldBlock;
    }

    void createPortal(World world, BlockPos pos){
        BlockState portal = RoguelikeRealmsBlocks.DRACONIC_SHADOW_PORTAL.getDefaultState();
        for (int x = -1; x <= 1; x++)
            for (int z = -1; z <= 1; z++)
            if (!((z == 0) && (x == 0))) {
                world.setBlockState(pos.add(x, -1, z), portal);
            }
    }

    void destroyPortal(World world, BlockPos pos){
        BlockState air = Blocks.AIR.getDefaultState();
        BlockState portal = RoguelikeRealmsBlocks.DRACONIC_SHADOW_PORTAL.getDefaultState();
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
            if (!((j == 0) && (i == 0))) {
                if (world.getBlockState(pos.add(i, -1, j)) == portal)
                    world.setBlockState(pos.add(i, -1, j), air);
            }

    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!checkFrame(world, pos))destroyPortal(world, pos);

        world.getBlockTickScheduler().schedule(pos, this, 10);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }

    static {
        SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    }
}
