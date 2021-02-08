package net.sfedunet.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class EmeraldPedestal extends Block {

    public EmeraldPedestal(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        Block Dragon_Scales = AnyItemsBlocks.DRAGON_SCALES_BLOCK;
        Block Gold_Block = Blocks.GOLD_BLOCK;
        if (world.getBlockState(pos.add(0, -1, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -2, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -2, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -2, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -2, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -2, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -2, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -2, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -2, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -2, -1)).getBlock() == Dragon_Scales & /*Основание 0 уровень*/
                world.getBlockState(pos.add(2, -1, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, 1)).getBlock() == Dragon_Scales & /*Осноание уровень 1*/
                world.getBlockState(pos.add(-2, 0, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, 0, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, 0, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, 0, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, 0, -2)).getBlock() == Dragon_Scales & /* Основание 2 уровень*/
                world.getBlockState(pos.add(-2, 1, -2)).getBlock() == Gold_Block & world.getBlockState(pos.add(-2, 1, 2)).getBlock() == Gold_Block & world.getBlockState(pos.add(2, 1, 2)).getBlock() == Gold_Block & world.getBlockState(pos.add(2, 1, -2)).getBlock() == Gold_Block == true /*Основание 3 уровень*/) { createPortal(world, pos); }
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
        Block Dragon_Scales = AnyItemsBlocks.DRAGON_SCALES_BLOCK;
        Block Gold_Block = Blocks.GOLD_BLOCK;
        if (world.getBlockState(pos.add(0, -1, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -2, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -2, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -2, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -2, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -2, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -2, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -2, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -2, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -2, -1)).getBlock() == Dragon_Scales & /*Основание 0 уровень*/
                world.getBlockState(pos.add(2, -1, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, 1)).getBlock() == Dragon_Scales & /*Осноание уровень 1*/
                world.getBlockState(pos.add(-2, 0, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, 0, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, 0, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, 0, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, 0, -2)).getBlock() == Dragon_Scales & /* Основание 2 уровень*/
                world.getBlockState(pos.add(-2, 1, -2)).getBlock() == Gold_Block & world.getBlockState(pos.add(-2, 1, 2)).getBlock() == Gold_Block & world.getBlockState(pos.add(2, 1, 2)).getBlock() == Gold_Block & world.getBlockState(pos.add(2, 1, -2)).getBlock() == Gold_Block == true /*Основание 3 уровень*/) {
            world.setBlockState(pos.add(1, -1, 0), blockState);
            world.setBlockState(pos.add(1, -1, 1), blockState);
            world.setBlockState(pos.add(1, -1, -1), blockState);
            world.setBlockState(pos.add(0, -1, -1), blockState);
            world.setBlockState(pos.add(0, -1, 1), blockState);
            world.setBlockState(pos.add(-1, -1, 0), blockState);
            world.setBlockState(pos.add(-1, -1, 1), blockState);
            world.setBlockState(pos.add(-1, -1, -1), blockState); }
    }

    //мне некуда девать свой интеллект
    void cumShot(World world, BlockPos pos, LivingEntity entity){
        SnowballEntity snowballEntity = new SnowballEntity(world, pos.getX(), pos.getY() + 5, pos.getZ());
        snowballEntity.setItem(Items.SNOWBALL.getDefaultStack());
        snowballEntity.setProperties(entity, -70, 90, 0.0F, 0.5F, 1.0F);
        world.spawnEntity(snowballEntity);

    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random){
        Block Dragon_Scales = AnyItemsBlocks.DRAGON_SCALES_BLOCK;
        Block Gold_Block = Blocks.GOLD_BLOCK;
        if (world.getBlockState(pos.add(0, -1, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -2, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -2, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -2, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -2, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -2, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -2, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -2, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -2, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -2, -1)).getBlock() == Dragon_Scales & /*Основание 0 уровень*/
                world.getBlockState(pos.add(2, -1, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, 0)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(0, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, -1, 1)).getBlock() == Dragon_Scales & /*Осноание уровень 1*/
                world.getBlockState(pos.add(-2, 0, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, 0, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, 0, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-2, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, 2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, 1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, -1)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(2, 0, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(1, 0, -2)).getBlock() == Dragon_Scales & world.getBlockState(pos.add(-1, 0, -2)).getBlock() == Dragon_Scales & /* Основание 2 уровень*/
                world.getBlockState(pos.add(-2, 1, -2)).getBlock() == Gold_Block & world.getBlockState(pos.add(-2, 1, 2)).getBlock() == Gold_Block & world.getBlockState(pos.add(2, 1, 2)).getBlock() == Gold_Block & world.getBlockState(pos.add(2, 1, -2)).getBlock() == Gold_Block == false /*Основание 3 уровень*/) { destroyPortal((World) world, pos); }
    }
}
