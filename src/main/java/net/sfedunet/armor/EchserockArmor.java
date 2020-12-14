package net.sfedunet.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.sfedunet.AnyItemsMod;

public class EchserockArmor extends ArmorItem {
    public EchserockArmor(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new Settings().group(AnyItemsMod.GENERAL));
    }
}
