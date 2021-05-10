package net.sfedunet.item.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.api.armor.ArmorEffectRegistry;
import net.sfedunet.item.armor.effects.TickingArmorEffectTest;
import net.sfedunet.item.base.BaseArmorItem;

public class AnyItemsArmor {

    public static final Item CRYPTON_HELMET = new BaseArmorItem(AnyArmorMaterials.CRYPTON_ARMOR_MATERIAL, EquipmentSlot.HEAD, "none");
    public static final Item CRYPTON_CHESTPLATE = new BaseArmorItem(AnyArmorMaterials.CRYPTON_ARMOR_MATERIAL, EquipmentSlot.CHEST, "none");
    public static final Item CRYPTON_LEGGINGS = new BaseArmorItem(AnyArmorMaterials.CRYPTON_ARMOR_MATERIAL, EquipmentSlot.LEGS, "none");
    public static final Item CRYPTON_BOOTS = new BaseArmorItem(AnyArmorMaterials.CRYPTON_ARMOR_MATERIAL, EquipmentSlot.FEET, "none");

    public static final Item DRAGON_HELMET = new BaseArmorItem(AnyArmorMaterials.DRAGON_ARMOR_MATERIAL, EquipmentSlot.HEAD, "fire_resistance");
    public static final Item DRAGON_CHESTPLATE = new BaseArmorItem(AnyArmorMaterials.DRAGON_ARMOR_MATERIAL, EquipmentSlot.CHEST, "fire_resistance");
    public static final Item DRAGON_LEGGINGS = new BaseArmorItem(AnyArmorMaterials.DRAGON_ARMOR_MATERIAL, EquipmentSlot.LEGS, "fire_resistance");
    public static final Item DRAGON_BOOTS = new BaseArmorItem(AnyArmorMaterials.DRAGON_ARMOR_MATERIAL, EquipmentSlot.FEET, "fire_resistance");

    public static final Item ECHSEROCK_HELMET = new BaseArmorItem(AnyArmorMaterials.ECHSEROCK_ARMOR_MATERIAL, EquipmentSlot.HEAD, "none");
    public static final Item ECHSEROCK_CHESTPLATE = new BaseArmorItem(AnyArmorMaterials.ECHSEROCK_ARMOR_MATERIAL, EquipmentSlot.CHEST, "none");
    public static final Item ECHSEROCK_LEGGINGS = new BaseArmorItem(AnyArmorMaterials.ECHSEROCK_ARMOR_MATERIAL, EquipmentSlot.LEGS, "none");
    public static final Item ECHSEROCK_BOOTS = new BaseArmorItem(AnyArmorMaterials.ECHSEROCK_ARMOR_MATERIAL, EquipmentSlot.FEET, "none");

    public static void register(){
        registerArmorSet("crypton", CRYPTON_HELMET, CRYPTON_CHESTPLATE, CRYPTON_LEGGINGS, CRYPTON_BOOTS);
        registerArmorSet("dragon", DRAGON_HELMET, DRAGON_CHESTPLATE, DRAGON_LEGGINGS, DRAGON_BOOTS);
        registerArmorSet("echserock", ECHSEROCK_HELMET, ECHSEROCK_CHESTPLATE, ECHSEROCK_LEGGINGS, ECHSEROCK_BOOTS);

        registerArmorEffects();


    }

    static void registerArmorSet(String prefix, Item entryHelmet, Item entryChestplate, Item entryLeggings, Item entryBoots){
        Registry.register(Registry.ITEM, new Identifier(AnyItemsMod.MODID, prefix + "_helmet"), entryHelmet);
        Registry.register(Registry.ITEM, new Identifier(AnyItemsMod.MODID, prefix + "_chestplate"), entryChestplate);
        Registry.register(Registry.ITEM, new Identifier(AnyItemsMod.MODID, prefix + "_leggings"), entryLeggings);
        Registry.register(Registry.ITEM, new Identifier(AnyItemsMod.MODID, prefix + "_boots"), entryBoots);
    }

    static void registerArmorEffects(){
        ArmorEffectRegistry.register("Dragon Armor", DRAGON_HELMET, DRAGON_CHESTPLATE, DRAGON_LEGGINGS, DRAGON_BOOTS, StatusEffects.FIRE_RESISTANCE);

        //test
        ArmorEffectRegistry.register(new TickingArmorEffectTest(Items.NETHERITE_HELMET, DRAGON_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS, null));
    }
}
