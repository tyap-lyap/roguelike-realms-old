package net.sfedunet.roguelikerealms.block.base;

import net.minecraft.block.LeavesBlock;
import net.sfedunet.roguelikerealms.interfaces.IBlockModel;

public class BaseLeaveBlock extends LeavesBlock implements IBlockModel {

    final private String parentModel;

    public BaseLeaveBlock(Settings settings, String parentModel) {
        super(settings);
        this.parentModel = parentModel;
    }

    @Override
    public String getParent() {
        return parentModel;
    }
}
