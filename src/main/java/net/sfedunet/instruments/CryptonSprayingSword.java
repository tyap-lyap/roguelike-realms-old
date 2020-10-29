package net.sfedunet.instruments;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonSprayingSword extends SwordItem {
    public CryptonSprayingSword(ToolMaterial toolMaterial) {
        super(toolMaterial, 1, 0, new Settings().group(AnyItemsMod.AI_GENERAL));
    }
}
