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
import net.sfedunet.AnyItemsMod;
import org.jetbrains.annotations.Nullable;

public class EmeraldPedestal extends Block {

    public EmeraldPedestal(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        //if (world.getBlockState(pos.add(0, -1, 0)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK || )
        createPortal(world, pos);
        cumShot(world, pos, placer);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        destroyPortal((World) world, pos);
    }

    void createPortal(World world, BlockPos pos){
        //test
        BlockState blockState = Blocks.BEDROCK.getDefaultState();
        world.setBlockState(pos.add(0, 1, 0), blockState);
        world.setBlockState(pos.add(1, 1, 0), blockState);
        world.setBlockState(pos.add(-1, 1, 0), blockState);
        world.setBlockState(pos.add(0, 2, 0), blockState);
        world.setBlockState(pos.add(0, 3, 0), blockState);
        world.setBlockState(pos.add(0, 4, 0), blockState);
    }

    void destroyPortal(World world, BlockPos pos){
        BlockState blockState = Blocks.AIR.getDefaultState();
        world.setBlockState(pos.add(0, 1, 0), blockState);
        world.setBlockState(pos.add(1, 1, 0), blockState);
        world.setBlockState(pos.add(-1, 1, 0), blockState);
        world.setBlockState(pos.add(0, 2, 0), blockState);
        world.setBlockState(pos.add(0, 3, 0), blockState);
        world.setBlockState(pos.add(0, 4, 0), blockState);
    }

    //мне некуда девать свой интеллект
    void cumShot(World world, BlockPos pos, LivingEntity entity){

        SnowballEntity snowballEntity = new SnowballEntity(world, pos.getX(), pos.getY() + 5, pos.getZ());
        snowballEntity.setItem(Items.SNOWBALL.getDefaultStack());
        snowballEntity.setProperties(entity, -70, 90, 0.0F, 0.5F, 1.0F);
        world.spawnEntity(snowballEntity);

    }
}
