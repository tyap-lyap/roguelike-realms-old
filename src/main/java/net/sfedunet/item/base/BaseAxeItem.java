package net.sfedunet.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class BaseAxeItem extends AxeItem {

    public BaseAxeItem(ToolMaterial material, float attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new FabricItemSettings().group(AnyItemsMod.GENERAL));
    }
}
