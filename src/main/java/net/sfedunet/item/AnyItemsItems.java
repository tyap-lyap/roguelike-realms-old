package net.sfedunet.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.item.armor.AnyItemsArmor;
import net.sfedunet.item.base.BaseItem;
import net.sfedunet.item.tools.AnyItemsTools;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnyItemsItems {

    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item CRYPTON_DUST = add("crypton_dust", new BaseItem());
    public static final Item CRYPTONEZERIT = add("cryptonezerit", new BaseItem());
    public static final Item SOUL_INGOT = add("soul_ingot", new BaseItem());
    public static final Item FRIEND_SOUL = add("friend_soul", new BaseItem());
    public static final Item HOSTILE_SOUL = add("hostile_soul", new BaseItem());
    public static final Item FRIEND_SOUL_SHARD = add("friend_soul_shard", new BaseItem());
    public static final Item HOSTILE_SOUL_SHARD = add("hostile_soul_shard", new BaseItem());
    public static final Item ECHSEROCK_PIECE = add("echserock_piece", new BaseItem());
    public static final Item ECHSEROCK_CHUNK = add("echserock_chunk", new BaseItem());
    public static final Item MILITANT_SOUL = add("militant_soul", new BaseItem());
    public static final Item MILITANT_SOUL_SHARD = add("militant_soul_shard", new BaseItem());
    public static final Item PACIFIED_SOUL = add("pacified_soul", new BaseItem());
    public static final Item PACIFIED_SOUL_SHARD = add("pacified_soul_shard", new BaseItem());
    public static final Item RULER_SOUL_INGOT = add("ruler_soul_ingot", new BaseItem());
    public static final Item DRAGON_INGOT = add("dragon_ingot", new BaseItem());
    public static final Item ASHES = add("ashes", new BaseItem());
    public static final Item DRAGON_SCALES = add("dragon_scales", new BaseItem());
    public static final Item DRAGON_FIRE = add("dragon_fire", new BaseItem());
    public static final Item SHAURMA = add("shaurma", new BaseItem(new FabricItemSettings().group(AnyItemsMod.GENERAL).food(new FoodComponent.Builder().saturationModifier(7.5f).hunger(9).statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*20),0.2f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10),0.21f).build())));
    public static final Item COOKED_SHAURMA = add("cooked_shaurma", new BaseItem(new FabricItemSettings().group(AnyItemsMod.GENERAL).food(new FoodComponent.Builder().saturationModifier(15f).hunger(18).statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*15),0.09f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*30),0.1f).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 20*30,5),0.05f).build())));
    public static final Item ECHPOCHMAK = add("echpochmak", new BaseItem(new FabricItemSettings().group(AnyItemsMod.GENERAL).food(new FoodComponent.Builder().saturationModifier(10f).hunger(14).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20*5),0.5f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5),0.5f).build())));
    public static final Item ONION = add("onion", new BaseItem(new FabricItemSettings().group(AnyItemsMod.GENERAL).food(new FoodComponent.Builder().saturationModifier(2f).hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*10),1f).build())));


    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(new Identifier(AnyItemsMod.MODID, name), item);
        return item;
    }

    public static void register(){

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }

        AnyItemsTools.register();
        AnyItemsArmor.register();
    }
}
