package net.sfedunet.tools;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.*;

public class CryptonSprayingPickaxe extends PickaxeItem {
    public CryptonSprayingPickaxe(ToolMaterial toolmaterial) {
        super(toolmaterial, 0, 0, new Settings().group(AnyItemsMod.GENERAL));
    }
}
