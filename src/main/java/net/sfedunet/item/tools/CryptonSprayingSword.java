package net.sfedunet.item.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonSprayingSword extends SwordItem {
    public CryptonSprayingSword(ToolMaterial toolMaterial) {
        super(toolMaterial, 1, -2, new Settings().group(AnyItemsMod.GENERAL));
    }
}
