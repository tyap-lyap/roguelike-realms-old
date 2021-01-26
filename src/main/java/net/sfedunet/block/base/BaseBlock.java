package net.sfedunet.block.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;

public class BaseBlock extends Block {

    public BaseBlock() {
        super(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE));
    }

    public BaseBlock(Block copyOf, BlockSoundGroup blockSoundGroup) {
        super(FabricBlockSettings.copy(copyOf).sounds(blockSoundGroup));
    }

    public BaseBlock(FabricBlockSettings settings) {
        super(settings);
    }
}
