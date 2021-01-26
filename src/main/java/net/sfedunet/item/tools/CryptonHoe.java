package net.sfedunet.item.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonHoe extends HoeItem {
    public CryptonHoe(ToolMaterial toolmaterial) {
        super(toolmaterial, -5, -3, new Settings().group(AnyItemsMod.GENERAL));
    }
}
