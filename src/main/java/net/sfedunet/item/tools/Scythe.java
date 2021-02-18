package net.sfedunet.item.tools;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.item.AnyItemGroups;

public class Scythe extends SwordItem {
    public Scythe(ToolMaterial toolMaterial) {
        super(toolMaterial, 10, 5, new Settings().group(AnyItemGroups.TOOLS_AND_WEAPONS));
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return false;
    }
}
