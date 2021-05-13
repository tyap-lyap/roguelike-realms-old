package net.sfedunet.roguelikerealms.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.roguelikerealms.item.RoguelikeRealmsItemGroups;

public class BaseAxeItem extends AxeItem {

    public BaseAxeItem(ToolMaterial material, float attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new FabricItemSettings().group(RoguelikeRealmsItemGroups.TOOLS_AND_WEAPONS));
    }
}
