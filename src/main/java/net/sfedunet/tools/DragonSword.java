package net.sfedunet.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class DragonSword extends SwordItem {
    public DragonSword(ToolMaterial toolMaterial1) {
        super(toolMaterial1, 0, 1, new Settings().group(AnyItemsMod.GENERAL));
    }
}
