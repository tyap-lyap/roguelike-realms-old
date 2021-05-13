package net.sfedunet.roguelikerealms.block.base;

import net.minecraft.block.PlantBlock;
import net.sfedunet.roguelikerealms.interfaces.IBlockModel;

public class BasePlantBlock extends PlantBlock implements IBlockModel {

    private final String parentModel;

    public BasePlantBlock(Settings settings, String parentModel) {
        super(settings);
        this.parentModel = parentModel;
    }

    @Override
    public String getParent() {
        return parentModel;
    }
}
