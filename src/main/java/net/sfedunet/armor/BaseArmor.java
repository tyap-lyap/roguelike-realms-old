package net.sfedunet.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.sfedunet.AnyItemsMod;

public class BaseArmor extends ArmorItem {
    public BaseArmor(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new Settings().group(AnyItemsMod.AI_GENERAL));
    }
}
