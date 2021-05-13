package net.sfedunet.roguelikerealms.block.base;

import net.minecraft.block.PillarBlock;
import net.sfedunet.roguelikerealms.interfaces.IBlockModel;

public class BasePillarBlock extends PillarBlock implements IBlockModel {

    final private String parentModel;


    public BasePillarBlock(Settings settings, String parentModel) {
        super(settings);
        this.parentModel = parentModel;
    }

    @Override
    public String getParent() {
        return parentModel;
    }
}
