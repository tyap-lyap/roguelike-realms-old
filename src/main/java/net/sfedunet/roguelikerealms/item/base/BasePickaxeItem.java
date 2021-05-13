package net.sfedunet.roguelikerealms.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.roguelikerealms.item.RoguelikeRealmsItemGroups;

public class BasePickaxeItem extends PickaxeItem {

    public BasePickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new FabricItemSettings().group(RoguelikeRealmsItemGroups.TOOLS_AND_WEAPONS));
    }
}
