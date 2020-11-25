package net.sfedunet.instruments;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonSprayingAxe extends AxeItem {
    public CryptonSprayingAxe(ToolMaterial toolmaterial) {
        super(toolmaterial, 0, 0, new Settings().group(AnyItemsMod.AI_GENERAL));
    }
}
