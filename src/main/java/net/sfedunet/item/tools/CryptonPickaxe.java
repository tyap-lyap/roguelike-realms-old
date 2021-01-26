package net.sfedunet.item.tools;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonPickaxe extends PickaxeItem {
    public CryptonPickaxe(ToolMaterial toolmaterial) {
        super(toolmaterial, -3, -1, new Item.Settings().group(AnyItemsMod.GENERAL));
    }
}
