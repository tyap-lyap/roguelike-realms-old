package net.sfedunet.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class EchserockSword extends SwordItem {
    public EchserockSword(ToolMaterial toolMaterial) {
        super(toolMaterial, 0, 0, new Settings().group(AnyItemsMod.GENERAL));
    }
}
