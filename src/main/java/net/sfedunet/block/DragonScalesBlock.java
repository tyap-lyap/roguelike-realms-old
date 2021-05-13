package net.sfedunet.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DragonScalesBlock extends Block {

    private final String type;

    public DragonScalesBlock(String type) {
        super(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).sounds(BlockSoundGroup.NETHER_BRICKS));
        this.type = type;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {

        if(type.equals("normal") && world.getBlockState(pos.up(1)).isOf(Blocks.GOLD_BLOCK)){

            world.setBlockState(pos, RoguelikeRealmsBlocks.GILDED_DRAGON_SCALES_BLOCK.getDefaultState());

        }else if(type.equals("gilded") && !world.getBlockState(pos.up(1)).isOf(Blocks.GOLD_BLOCK)){
            world.setBlockState(pos, RoguelikeRealmsBlocks.DRAGON_SCALES_BLOCK.getDefaultState());
        }
    }
}
