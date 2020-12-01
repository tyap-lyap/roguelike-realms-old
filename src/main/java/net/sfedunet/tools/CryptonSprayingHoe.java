package net.sfedunet.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonSprayingHoe extends HoeItem {
    public CryptonSprayingHoe(ToolMaterial toolmaterial) {
        super(toolmaterial, 0, 0, new Settings().group(AnyItemsMod.GENERAL));
    }
}
