package net.sfedunet.item.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.item.base.BaseArmorItem;

public class AnyItemsArmor {

    public static final Item CRYPTON_HELMET = new BaseArmorItem(AnyArmorMaterials.CRYPTON_ARMOR_MATERIAL, EquipmentSlot.HEAD);
    public static final Item CRYPTON_CHESTPLATE = new BaseArmorItem(AnyArmorMaterials.CRYPTON_ARMOR_MATERIAL, EquipmentSlot.CHEST);
    public static final Item CRYPTON_LEGGINGS = new BaseArmorItem(AnyArmorMaterials.CRYPTON_ARMOR_MATERIAL, EquipmentSlot.LEGS);
    public static final Item CRYPTON_BOOTS = new BaseArmorItem(AnyArmorMaterials.CRYPTON_ARMOR_MATERIAL, EquipmentSlot.FEET);

    public static final Item DRAGON_HELMET = new BaseArmorItem(AnyArmorMaterials.DRAGON_ARMOR_MATERIAL, EquipmentSlot.HEAD);
    public static final Item DRAGON_CHESTPLATE = new BaseArmorItem(AnyArmorMaterials.DRAGON_ARMOR_MATERIAL, EquipmentSlot.CHEST);
    public static final Item DRAGON_LEGGINGS = new BaseArmorItem(AnyArmorMaterials.DRAGON_ARMOR_MATERIAL, EquipmentSlot.LEGS);
    public static final Item DRAGON_BOOTS = new BaseArmorItem(AnyArmorMaterials.DRAGON_ARMOR_MATERIAL, EquipmentSlot.FEET);

    public static final Item ECHSEROCK_HELMET = new BaseArmorItem(AnyArmorMaterials.ECHSEROCK_ARMOR_MATERIAL, EquipmentSlot.HEAD);
    public static final Item ECHSEROCK_CHESTPLATE = new BaseArmorItem(AnyArmorMaterials.ECHSEROCK_ARMOR_MATERIAL, EquipmentSlot.CHEST);
    public static final Item ECHSEROCK_LEGGINGS = new BaseArmorItem(AnyArmorMaterials.ECHSEROCK_ARMOR_MATERIAL, EquipmentSlot.LEGS);
    public static final Item ECHSEROCK_BOOTS = new BaseArmorItem(AnyArmorMaterials.ECHSEROCK_ARMOR_MATERIAL, EquipmentSlot.FEET);

    public static void register(){
        registerArmorSet("crypton", CRYPTON_HELMET, CRYPTON_CHESTPLATE, CRYPTON_LEGGINGS, CRYPTON_BOOTS);
        registerArmorSet("dragon", DRAGON_HELMET, DRAGON_CHESTPLATE, DRAGON_LEGGINGS, DRAGON_BOOTS);
        registerArmorSet("echserock", ECHSEROCK_HELMET, ECHSEROCK_CHESTPLATE, ECHSEROCK_LEGGINGS, ECHSEROCK_BOOTS);
    }

    public static void registerArmorSet(String prefix, Item entryHelmet, Item entryChestplate, Item entryLeggings, Item entryBoots){
        Registry.register(Registry.ITEM, new Identifier(AnyItemsMod.MODID, prefix + "_helmet"), entryHelmet);
        Registry.register(Registry.ITEM, new Identifier(AnyItemsMod.MODID, prefix + "_chestplate"), entryChestplate);
        Registry.register(Registry.ITEM, new Identifier(AnyItemsMod.MODID, prefix + "_leggings"), entryLeggings);
        Registry.register(Registry.ITEM, new Identifier(AnyItemsMod.MODID, prefix + "_boots"), entryBoots);
    }
}
