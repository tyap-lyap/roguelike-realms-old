package net.sfedunet.item.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class DragonHoe extends HoeItem {
    public DragonHoe(ToolMaterial material) {
        super(material, -5, -3, new Settings().group(AnyItemsMod.GENERAL));
    }
}
