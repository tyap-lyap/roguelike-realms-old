package net.sfedunet.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class BaseHoeItem extends HoeItem {

    public BaseHoeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new FabricItemSettings().group(AnyItemsMod.GENERAL));
    }
}
