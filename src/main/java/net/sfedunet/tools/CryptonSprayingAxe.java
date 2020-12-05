package net.sfedunet.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonSprayingAxe extends AxeItem {
    public CryptonSprayingAxe(ToolMaterial toolmaterial) {
        super(toolmaterial, 2, -2, new Settings().group(AnyItemsMod.GENERAL));
    }
}
