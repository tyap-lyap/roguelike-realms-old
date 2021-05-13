package net.sfedunet.roguelikerealms.block.base;

import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.sfedunet.roguelikerealms.interfaces.IBlockModel;

public class BaseFlowerBlock extends FlowerBlock implements IBlockModel {

    private final String parentModel;

    public BaseFlowerBlock(StatusEffect suspiciousStewEffect, int effectDuration, Settings settings, String parentModel) {
        super(suspiciousStewEffect, effectDuration, settings);
        this.parentModel = parentModel;
    }

    @Override
    public String getParent() {
        return parentModel;
    }
}
