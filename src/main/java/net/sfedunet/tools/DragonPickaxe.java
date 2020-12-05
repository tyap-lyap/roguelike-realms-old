package net.sfedunet.tools;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class DragonPickaxe extends PickaxeItem {
    public DragonPickaxe(ToolMaterial material) {
        super(material, 0, 1, new Settings().group(AnyItemsMod.GENERAL));
    }
}
