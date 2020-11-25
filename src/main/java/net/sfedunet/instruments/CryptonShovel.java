package net.sfedunet.instruments;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonShovel extends ShovelItem {
    public CryptonShovel(ToolMaterial toolmaterial) {
        super(toolmaterial, 0, 0, new Settings().group(AnyItemsMod.AI_GENERAL));
    }
}
