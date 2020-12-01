package net.sfedunet.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;

public class AnyItemsItems {
    public static final Item CRYPTON_DUST = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item CRYPTONEZERIT = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item SOUL_INGOT = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item FRIEND_SOUL = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item HOSTILE_SOUL = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item FRIEND_SOUL_SHARD = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item HOSTILE_SOUL_SHARD = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item ECHSEROCK_PIECE = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item ECHSEROCK_CHUNK = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item MILITANT_SOUL = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item MILITANT_SOUL_SHARD = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item PACIFIED_SOUL = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item PACIFIED_SOUL_SHARD = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item RULER_SOUL_INGOT = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item DRAGON_INGOT = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item ASHES = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item DRAGON_SCALES = new Item (new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item DRAGON_FIRE = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    public static final Item SHAURMA = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL).food(new FoodComponent.Builder().saturationModifier(7.5f).hunger(9).statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*20),0.2f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10),0.21f).build()));
    public static final Item COOKED_SHAURMA = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL).food(new FoodComponent.Builder().saturationModifier(15f).hunger(18).statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*15),0.09f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*30),0.1f).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 20*30,5),0.05f).build()));
    public static final Item ECHPOCHMAK = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL).food(new FoodComponent.Builder().saturationModifier(10f).hunger(14).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20*5),0.5f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5),0.5f).build()));
    public static final Item ONION = new Item(new FabricItemSettings().group(AnyItemsMod.GENERAL).food(new FoodComponent.Builder().saturationModifier(2f).hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*10),1f).build()));

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_dust"), CRYPTON_DUST);
        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonezerit"), CRYPTONEZERIT);

        Registry.register(Registry.ITEM, new Identifier("anyitem:hostile_soul_shard"), HOSTILE_SOUL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("anyitem:hostile_soul"), HOSTILE_SOUL);

        Registry.register(Registry.ITEM, new Identifier("anyitem:friend_soul_shard"), FRIEND_SOUL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("anyitem:friend_soul"), FRIEND_SOUL);

        Registry.register(Registry.ITEM, new Identifier("anyitem:soul_ingot"), SOUL_INGOT);

        Registry.register(Registry.ITEM, new Identifier("anyitem:echserock_piece"), ECHSEROCK_PIECE);
        Registry.register(Registry.ITEM, new Identifier("anyitem:echserock_chunk"), ECHSEROCK_CHUNK);
        Registry.register(Registry.ITEM, new Identifier("anyitem:militant_soul"), MILITANT_SOUL);
        Registry.register(Registry.ITEM, new Identifier("anyitem:militant_soul_shard"), MILITANT_SOUL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("anyitem:pacified_soul"), PACIFIED_SOUL);
        Registry.register(Registry.ITEM, new Identifier("anyitem:pacified_soul_shard"), PACIFIED_SOUL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("anyitem:ruler_soul_ingot"), RULER_SOUL_INGOT);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_ingot"), DRAGON_INGOT);
        Registry.register(Registry.ITEM, new Identifier("anyitem:ashes"), ASHES);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_scales"),DRAGON_SCALES);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_fire"), DRAGON_FIRE);

        Registry.register(Registry.ITEM, new Identifier("anyitem:onion"), ONION);
        Registry.register(Registry.ITEM, new Identifier("anyitem:shaurma"), SHAURMA);
        Registry.register(Registry.ITEM, new Identifier("anyitem:cooked_shaurma"), COOKED_SHAURMA);
        Registry.register(Registry.ITEM, new Identifier("anyitem:echpochmak"), ECHPOCHMAK);
    }
}
