package net.sfedunet.roguelikerealms.item.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.roguelikerealms.item.RoguelikeRealmsItemGroups;

public class Scythe extends SwordItem {
    public Scythe(ToolMaterial toolMaterial) {
        super(toolMaterial, 0, -3.0f, new Settings().group(RoguelikeRealmsItemGroups.TOOLS_AND_WEAPONS));
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return false;
    }
}
