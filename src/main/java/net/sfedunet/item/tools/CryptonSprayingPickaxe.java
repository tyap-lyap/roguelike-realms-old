package net.sfedunet.item.tools;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.*;

public class CryptonSprayingPickaxe extends PickaxeItem {
    public CryptonSprayingPickaxe(ToolMaterial toolmaterial) {
        super(toolmaterial, -2, -2, new Settings().group(AnyItemsMod.GENERAL));
    }
}
