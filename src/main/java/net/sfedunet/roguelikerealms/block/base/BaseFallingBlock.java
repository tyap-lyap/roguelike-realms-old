package net.sfedunet.roguelikerealms.block.base;

import net.minecraft.block.FallingBlock;
import net.sfedunet.roguelikerealms.interfaces.IBlockModel;

public class BaseFallingBlock extends FallingBlock implements IBlockModel {

    private final String parentModel;

    public BaseFallingBlock(Settings settings, String parentModel) {
        super(settings);
        this.parentModel = parentModel;
    }

    @Override
    public String getParent() {
        return this.parentModel;
    }
}
