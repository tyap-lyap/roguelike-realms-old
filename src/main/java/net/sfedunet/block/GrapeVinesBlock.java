package net.sfedunet.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.sfedunet.item.AnyItemsItems;

public class GrapeVinesBlock extends Block {
    private final String type;

    public GrapeVinesBlock(String type) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).noCollision());
        this.type = type;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        ItemStack itemStack = player.getStackInHand(hand);

        if(type.equals("graped")){
            player.giveItemStack(AnyItemsItems.DRAGON_GRAPES.getDefaultStack());
            world.setBlockState(pos, AnyItemsBlocks.GRAPE_VINES.getDefaultState());
            world.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            return ActionResult.success(world.isClient);
        }
        else if (type.equals("tip") && itemStack.getItem().equals(Items.BONE_MEAL) && world.getBlockState(pos.down(1)).getBlock().equals(Blocks.AIR)) {
            world.setBlockState(pos, AnyItemsBlocks.GRAPE_VINES.getDefaultState());
            world.setBlockState(pos.down(1), AnyItemsBlocks.GRAPE_VINES_TIP.getDefaultState());
            if(!player.abilities.creativeMode){
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }
        else if (type.equals("normal") && itemStack.getItem().equals(Items.BONE_MEAL)){
            world.setBlockState(pos, AnyItemsBlocks.GRAPED_GRAPE_VINES.getDefaultState());
            if(!player.abilities.creativeMode){
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }

        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if(type.equals("tip")){
            return Block.createCuboidShape(0.0D, 8.0D, 0.0D, 12.0D, 16.0D, 12.0D);
        }else return Block.createCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D);
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }


}
