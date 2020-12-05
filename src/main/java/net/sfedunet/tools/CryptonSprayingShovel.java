package net.sfedunet.tools;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonSprayingShovel extends ShovelItem {
    public CryptonSprayingShovel(ToolMaterial toolmaterial) {
        super(toolmaterial, -2, -2, new Settings().group(AnyItemsMod.GENERAL));
    }
}
