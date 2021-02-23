package net.sfedunet.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.entity.AnyItemsEntities;
import net.sfedunet.item.armor.AnyItemsArmor;
import net.sfedunet.item.base.BaseItem;
import net.sfedunet.item.tools.AnyItemsTools;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnyItemsItems {

    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item CRYPTON_DUST = add("crypton_dust", new BaseItem());
    public static final Item CRYPTONEZERIT = add("cryptonezerit", new BaseItem());
    public static final Item DRAGON_INGOT = add("dragon_ingot", new BaseItem());
    public static final Item SOUL_INGOT = add("soul_ingot", new BaseItem());
    public static final Item FRIEND_SOUL = add("friend_soul", new BaseItem());
    public static final Item HOSTILE_SOUL = add("hostile_soul", new BaseItem());
    public static final Item MILITANT_SOUL = add("militant_soul", new BaseItem());
    public static final Item PACIFIED_SOUL = add("pacified_soul", new BaseItem());
    public static final Item MILITANT_SOUL_SHARD = add("militant_soul_shard", new BaseItem());
    public static final Item PACIFIED_SOUL_SHARD = add("pacified_soul_shard", new BaseItem());
    public static final Item FRIEND_SOUL_SHARD = add("friend_soul_shard", new BaseItem());
    public static final Item HOSTILE_SOUL_SHARD = add("hostile_soul_shard", new BaseItem());
    public static final Item ECHSEROCK_PIECE = add("echserock_piece", new BaseItem());
    public static final Item ECHSEROCK_CHUNK = add("echserock_chunk", new BaseItem());
    public static final Item RULER_SOUL_INGOT = add("ruler_soul_ingot", new BaseItem());
    public static final Item ASHES = add("ashes", new BaseItem());
    public static final Item DRAGON_SCALES = add("dragon_scales", new BaseItem());
    public static final Item DRAGON_FIRE = add("dragon_fire", new BaseItem());
    public static final Item SHAURMA = add("shaurma", new BaseItem(new FabricItemSettings().group(AnyItemGroups.ITEMS).food(new FoodComponent.Builder().saturationModifier(7.5f).hunger(9).statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*20),0.2f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10),0.21f).build())));
    public static final Item COOKED_SHAURMA = add("cooked_shaurma", new BaseItem(new FabricItemSettings().group(AnyItemGroups.ITEMS).food(new FoodComponent.Builder().saturationModifier(15f).hunger(18).statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*15),0.09f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*30),0.1f).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 20*30,5),0.05f).build())));
    public static final Item ECHPOCHMAK = add("echpochmak", new BaseItem(new FabricItemSettings().group(AnyItemGroups.ITEMS).food(new FoodComponent.Builder().saturationModifier(10f).hunger(14).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20*5),0.5f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5),0.5f).build())));
    public static final Item ONION = add("onion", new BaseItem(new FabricItemSettings().group(AnyItemGroups.ITEMS).food(new FoodComponent.Builder().saturationModifier(2f).hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*10),1f).build())));
    public static final Item DRAGON_GRAPES = add("dragon_grapes", new BaseItem(new FabricItemSettings().group(AnyItemGroups.ITEMS).food(new FoodComponent.Builder().saturationModifier(1f).hunger(1).snack().build())));
    public static final Item INFERIOR_DRAGON_EGG = add((String)"inferior_dragon_spawn_egg", (Item)(new SpawnEggItem(AnyItemsEntities.INFERIOR_DRAGON, 14252800, 8283392, (new Item.Settings()).group(AnyItemGroups.ITEMS))));
    public static final Item BOW_DRAGON_EGG = add((String)"bow_dragon_spawn_egg", (Item)(new SpawnEggItem(AnyItemsEntities.DRAGON_BOWMAN, 14252800, 8283392, (new Item.Settings()).group(AnyItemGroups.ITEMS))));
    public static final Item CROSSBOW_DRAGON_EGG = add((String)"crossbow_dragon_spawn_egg", (Item)(new SpawnEggItem(AnyItemsEntities.DRAGON_CROSSBOWMAN, 14252800, 8283495, (new Item.Settings()).group(AnyItemGroups.ITEMS))));
    public static final Item SWORDMAN_DRAGON_EGG = add((String)"swordman_dragon_spawn_egg", (Item)(new SpawnEggItem(AnyItemsEntities.DRAGON_SWORDMAN, 14252800, 12616295, (new Item.Settings()).group(AnyItemGroups.ITEMS))));
    public static final Item WARLORD_DRAGON_EGG = add((String)"warlord_dragon_spawn_egg", (Item)(new SpawnEggItem(AnyItemsEntities.DRAGON_WARLORD, 14252800, 16741417, (new Item.Settings()).group(AnyItemGroups.ITEMS))));
    public static final Item ARMORED_DRAGON_EGG = add((String)"armored_dragon_spawn_egg", (Item)(new SpawnEggItem(AnyItemsEntities.ARMORED_DRAGON, 14252800, 10176297, (new Item.Settings()).group(AnyItemGroups.ITEMS))));
    public static final Item SPLITTING_DRAGON_EGG = add((String)"splitting_dragon_spawn_egg", (Item)(new SpawnEggItem(AnyItemsEntities.SPITTING_DRAGON, 14252800, 12810315, (new Item.Settings()).group(AnyItemGroups.ITEMS))));
    public static final Item SUPREME_DRAGON_EGG = add((String)"supreme_dragon_spawn_egg", (Item)(new SpawnEggItem(AnyItemsEntities.SUPREME_DRAGON, 14252800, 16748875, (new Item.Settings()).group(AnyItemGroups.ITEMS))));


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
