package net.sfedunet.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.item.AnyItemGroups;

public class BaseAxeItem extends AxeItem {

    public BaseAxeItem(ToolMaterial material, float attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new FabricItemSettings().group(AnyItemGroups.TOOLS_AND_WEAPONS));
    }
}
