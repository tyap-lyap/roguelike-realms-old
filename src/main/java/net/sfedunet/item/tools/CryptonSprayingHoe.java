package net.sfedunet.item.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonSprayingHoe extends HoeItem {
    public CryptonSprayingHoe(ToolMaterial toolmaterial) {
        super(toolmaterial, -3, -3, new Settings().group(AnyItemsMod.GENERAL));
    }
}
