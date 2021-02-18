package net.sfedunet.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.item.AnyItemGroups;

public class BasePickaxeItem extends PickaxeItem {

    public BasePickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new FabricItemSettings().group(AnyItemGroups.TOOLS_AND_WEAPONS));
    }
}
