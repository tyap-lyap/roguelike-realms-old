package net.sfedunet.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AnyItemsArmor {
    public static final ArmorMaterial CRYPTON_ARMOR = new CryptonArmorMaterial();

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_helmet"), new BaseArmor(CRYPTON_ARMOR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_chestplate"), new BaseArmor(CRYPTON_ARMOR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_leggings"), new BaseArmor(CRYPTON_ARMOR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_boots"), new BaseArmor(CRYPTON_ARMOR, EquipmentSlot.FEET));
    }
}
