package net.sfedunet.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonAxe extends AxeItem {
    public CryptonAxe(ToolMaterial toolmaterial) {
        super(toolmaterial, 3, -1, new Settings().group(AnyItemsMod.GENERAL));
    }
}
