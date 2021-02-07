package net.sfedunet.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class EmeraldPedestal extends Block {

    public EmeraldPedestal(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.getBlockState(pos.add(0, -1, 0)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK &
                world.getBlockState(pos.add(0, -2, 1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(0, -2, -1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(1, -2, 1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-1, -2, 1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(1, -2, -1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-1, -2, -1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & /*Основание*/
                world.getBlockState(pos.add(2, -1, 0)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, -1, -1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, -1, -2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, -1, 1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, -1, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & /*Вправо 2 блока*/
                world.getBlockState(pos.add(1, -1, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(1, -1, -2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & /*Вправо 1 блока*/
                world.getBlockState(pos.add(0, -1, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(0, -1, -2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & /*верхний и нижний блок*/
                world.getBlockState(pos.add(-1, -1, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-1, -1, -2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & /*Влево 1 блока*/
                world.getBlockState(pos.add(-2, -1, 0)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, -1, -1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, -1, -2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, -1, 1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, -1, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & /*Влево 2 блока*/
                world.getBlockState(pos.add(-2, 0, 0)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, 0, -1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, 0, -2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, 0, 1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, 0, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & /*Левая стенка 0 уровень*/
                world.getBlockState(pos.add(2, 0, 0)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, 0, -1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, 0, -2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, 0, 1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, 0, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & /*Правая стенка 0 уровень*/
                world.getBlockState(pos.add(-1, 0, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(0, 0, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(1, 0, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & /*Задняя стенка, 0 уровень*/
                world.getBlockState(pos.add(-1, 1, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(0, 1, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(1, 1, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & /*Задняя стенка, 1 уровень*/
                world.getBlockState(pos.add(0, 2, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(0, 3, 2)).getBlock() == Blocks.GOLD_BLOCK & /*Два блока вверх по середине задней стенке*/
                world.getBlockState(pos.add(-2, 1, -2)).getBlock() == Blocks.GOLD_BLOCK & world.getBlockState(pos.add(-2, 1, 0)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, 1, 1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, 1, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, 2, 0)).getBlock() == Blocks.GOLD_BLOCK & world.getBlockState(pos.add(-2, 2, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(-2, 3, 2)).getBlock() == Blocks.GOLD_BLOCK & /*Левая стенка*/
                world.getBlockState(pos.add(2, 1, -2)).getBlock() == Blocks.GOLD_BLOCK & world.getBlockState(pos.add(2, 1, 0)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, 1, 1)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, 1, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, 2, 0)).getBlock() == Blocks.GOLD_BLOCK & world.getBlockState(pos.add(2, 2, 2)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK & world.getBlockState(pos.add(2, 3, 2)).getBlock() == Blocks.GOLD_BLOCK == true/*Правая стенка*/) { createPortal(world, pos); }
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        destroyPortal((World) world, pos);
    }

    void createPortal(World world, BlockPos pos){
        //test
        BlockState blockState = AnyItemsBlocks.DRACONIC_SHADOW_PORTAL.getDefaultState();
        world.setBlockState(pos.add(1, -1, 0), blockState);
        world.setBlockState(pos.add(1, -1, 1), blockState);
        world.setBlockState(pos.add(1, -1, -1), blockState);
        world.setBlockState(pos.add(0, -1, -1), blockState);
        world.setBlockState(pos.add(0, -1, 1), blockState);
        world.setBlockState(pos.add(-1, -1, 0), blockState);
        world.setBlockState(pos.add(-1, -1, 1), blockState);
        world.setBlockState(pos.add(-1, -1, -1), blockState);
    }

    void destroyPortal(World world, BlockPos pos){
        BlockState blockState = Blocks.AIR.getDefaultState();
        world.setBlockState(pos.add(1, -1, 0), blockState);
        world.setBlockState(pos.add(1, -1, 1), blockState);
        world.setBlockState(pos.add(1, -1, -1), blockState);
        world.setBlockState(pos.add(0, -1, -1), blockState);
        world.setBlockState(pos.add(0, -1, 1), blockState);
        world.setBlockState(pos.add(-1, -1, 0), blockState);
        world.setBlockState(pos.add(-1, -1, 1), blockState);
        world.setBlockState(pos.add(-1, -1, -1), blockState);
    }

    //мне некуда девать свой интеллект
    void cumShot(World world, BlockPos pos, LivingEntity entity){
        SnowballEntity snowballEntity = new SnowballEntity(world, pos.getX(), pos.getY() + 5, pos.getZ());
        snowballEntity.setItem(Items.SNOWBALL.getDefaultStack());
        snowballEntity.setProperties(entity, -70, 90, 0.0F, 0.5F, 1.0F);
        world.spawnEntity(snowballEntity);

    }
}
