package net.sfedunet.integration.botania.item;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.item.base.BaseItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class BIItems {

    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item CRYPTON_MANA_LENS = add("crypton_mana_lens", new BaseItem());


    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(new Identifier(AnyItemsMod.MODID, name), item);
        return item;
    }

    public static void register(){

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }

    }
}
