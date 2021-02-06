package net.sfedunet.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AnyItemsArmor {
    public static final ArmorMaterial CRYPTON_ARMOR = new CryptonArmorMaterial();
    public static final ArmorMaterial DRAGON_ARMOR = new DragonArmorMaterial();
    public static final ArmorMaterial ECHSEROCK_ARMOR = new EchserockArmorMaterial();

    public static final Item CRYPTON_HELMET = new CryptonArmor(CRYPTON_ARMOR, EquipmentSlot.HEAD);
    public static final Item CRYPTON_CHESTPLATE = new CryptonArmor(CRYPTON_ARMOR, EquipmentSlot.CHEST);
    public static final Item CRYPTON_LEGGINGS = new CryptonArmor(CRYPTON_ARMOR, EquipmentSlot.LEGS);
    public static final Item CRYPTON_BOOTS = new CryptonArmor(CRYPTON_ARMOR, EquipmentSlot.FEET);

    public static final Item DRAGON_HELMET = new DragonArmor(DRAGON_ARMOR, EquipmentSlot.HEAD);
    public static final Item DRAGON_CHESTPLATE = new DragonArmor(DRAGON_ARMOR, EquipmentSlot.CHEST);
    public static final Item DRAGON_LEGGINGS = new DragonArmor(DRAGON_ARMOR, EquipmentSlot.LEGS);
    public static final Item DRAGON_BOOTS = new DragonArmor(DRAGON_ARMOR, EquipmentSlot.FEET);

    public static final Item ECHSEROCK_HELMET = new EchserockArmor(ECHSEROCK_ARMOR, EquipmentSlot.HEAD);
    public static final Item ECHSEROCK_CHESTPLATE = new EchserockArmor(ECHSEROCK_ARMOR, EquipmentSlot.CHEST);
    public static final Item ECHSEROCK_LEGGINGS = new EchserockArmor(ECHSEROCK_ARMOR, EquipmentSlot.LEGS);
    public static final Item ECHSEROCK_BOOTS = new EchserockArmor(ECHSEROCK_ARMOR, EquipmentSlot.FEET);

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_helmet"), CRYPTON_HELMET);
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_chestplate"), CRYPTON_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_leggings"), CRYPTON_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_boots"), CRYPTON_BOOTS);

        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_helmet"), DRAGON_HELMET);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_chestplate"), DRAGON_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_leggings"), DRAGON_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_boots"), DRAGON_BOOTS);

        Registry.register(Registry.ITEM, new Identifier("anyitem:echserock_helmet"), ECHSEROCK_HELMET);
        Registry.register(Registry.ITEM, new Identifier("anyitem:echserock_chestplate"), ECHSEROCK_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("anyitem:echserock_leggings"), ECHSEROCK_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("anyitem:echserock_boots"), ECHSEROCK_BOOTS);
    }
}
