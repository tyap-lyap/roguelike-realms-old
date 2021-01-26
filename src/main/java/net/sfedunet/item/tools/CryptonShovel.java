package net.sfedunet.item.tools;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonShovel extends ShovelItem {
    public CryptonShovel(ToolMaterial toolmaterial) {
        super(toolmaterial, -1, -1, new Settings().group(AnyItemsMod.GENERAL));
    }
}
