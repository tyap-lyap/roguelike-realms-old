package net.sfedunet.tools;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class EchserockPickaxe extends PickaxeItem {
    public EchserockPickaxe(ToolMaterial material) {
        super(material, 0, 0, new Settings().group(AnyItemsMod.GENERAL));
    }
}
