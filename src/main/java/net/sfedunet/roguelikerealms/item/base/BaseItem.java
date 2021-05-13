package net.sfedunet.roguelikerealms.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.sfedunet.roguelikerealms.item.RoguelikeRealmsItemGroups;

public class BaseItem extends Item {

    public BaseItem() {
        super(new FabricItemSettings().group(RoguelikeRealmsItemGroups.ITEMS));
    }
    public BaseItem(Settings settings) {
        super(settings);
    }
}
