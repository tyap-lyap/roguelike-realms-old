package net.sfedunet.item.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class DragonAxe extends AxeItem {
    public DragonAxe(ToolMaterial material) {
        super(material, 2, 1, new Settings().group(AnyItemsMod.GENERAL));
    }
}
