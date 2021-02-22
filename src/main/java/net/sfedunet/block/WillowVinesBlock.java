package net.sfedunet.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class WillowVinesBlock extends Block {
    private final String type;

    public WillowVinesBlock(String type) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).noCollision());
        this.type = type;
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        ItemStack itemStack = player.getStackInHand(hand);

        if (type.equals("tip") && itemStack.getItem().equals(Items.BONE_MEAL) && world.isAir(pos.down(1))) {
            world.setBlockState(pos, AnyItemsBlocks.DRAGON_WILLOW_VINES.getDefaultState());
            world.setBlockState(pos.down(1), AnyItemsBlocks.DRAGON_WILLOW_VINES_TIP.getDefaultState());
            if(!player.abilities.creativeMode){
                itemStack.decrement(1);
            }
            return ActionResult.success(world.isClient);
        }

        return ActionResult.PASS;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(type.equals("tip")){
            if (random.nextInt(8) == 0) {
                if(world.getBlockState(pos.down(1)).getBlock().equals(Blocks.AIR)){
                    world.setBlockState(pos, AnyItemsBlocks.DRAGON_WILLOW_VINES.getDefaultState(), 2);
                    world.setBlockState(pos.down(1), AnyItemsBlocks.DRAGON_WILLOW_VINES_TIP.getDefaultState(), 2);
                }

            }
        }
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if(!type.equals("tip")){
            if(world.getBlockState(pos.up(1)).getBlock().equals(Blocks.AIR) || world.getBlockState(pos.down(1)).getBlock().equals(Blocks.AIR)){
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }else{
            if(world.getBlockState(pos.up(1)).getBlock().equals(Blocks.AIR)){
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if(type.equals("tip")){
            return Block.createCuboidShape(2.0D, 8.0D, 2.0D, 14.0D, 16.0D, 14.0D);
        }else return Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState) {
        return BlockRenderType.MODEL;
    }


}
