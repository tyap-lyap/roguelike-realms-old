package net.sfedunet.item.tools;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class DragonShovel extends ShovelItem {
    public DragonShovel(ToolMaterial material) {
        super(material, 0, 1, new Settings().group(AnyItemsMod.GENERAL));
    }
}
