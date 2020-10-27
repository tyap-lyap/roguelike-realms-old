package net.sfedunet.instruments;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonHoe extends HoeItem {
    public CryptonHoe(ToolMaterial toolmaterial) {
        super(toolmaterial, 0, 0, new Settings().group(AnyItemsMod.AI_GENERAL));
    }
}
