package net.sfedunet.instruments;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class Scythe extends SwordItem {
    public Scythe(ToolMaterial toolMaterial) {
        super(toolMaterial, 10, 5, new Settings().group(AnyItemsMod.AI_GENERAL));
    }
}
