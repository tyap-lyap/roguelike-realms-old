package net.sfedunet.roguelikerealms.block.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;
import net.sfedunet.roguelikerealms.interfaces.IBlockModel;

public class BaseBlock extends Block implements IBlockModel {

    private final String parentModel;

    public BaseBlock(String parentModel) {
        super(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE));
        this.parentModel = parentModel;
    }

    public BaseBlock(Block copyOf, BlockSoundGroup blockSoundGroup, String parentModel) {
        super(FabricBlockSettings.copy(copyOf).sounds(blockSoundGroup));
        this.parentModel = parentModel;
    }

    public BaseBlock(Block copyOf, String parentModel) {
        super(FabricBlockSettings.copy(copyOf));
        this.parentModel = parentModel;
    }

    public BaseBlock(FabricBlockSettings settings, String parentModel) {
        super(settings);
        this.parentModel = parentModel;
    }

    @Override
    public String getParent() {
        return parentModel;
    }
}
