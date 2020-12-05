package net.sfedunet.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AnyItemsArmor {
    public static final ArmorMaterial CRYPTON_ARMOR = new CryptonArmorMaterial();
    public static final ArmorMaterial DRAGON_ARMOR = new DragonArmorMaterial();

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_helmet"), new CryptonArmor(CRYPTON_ARMOR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_chestplate"), new CryptonArmor(CRYPTON_ARMOR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_leggings"), new CryptonArmor(CRYPTON_ARMOR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_boots"), new CryptonArmor(CRYPTON_ARMOR, EquipmentSlot.FEET));

        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_helmet"), new DragonArmor(DRAGON_ARMOR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_chestplate"), new DragonArmor(DRAGON_ARMOR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_leggings"), new DragonArmor(DRAGON_ARMOR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_boots"), new DragonArmor(DRAGON_ARMOR, EquipmentSlot.FEET));
    }
}
