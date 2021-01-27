package net.sfedunet.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sfedunet.AnyItemsMod;
import org.jetbrains.annotations.Nullable;

public class EmeraldPedestal extends Block {

    public EmeraldPedestal(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        //if (world.getBlockState(pos.add(0, -1, 0)).getBlock() == AnyItemsBlocks.DRAGON_SCALES_BLOCK || )
    }
}
