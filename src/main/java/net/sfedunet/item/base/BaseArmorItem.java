package net.sfedunet.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.sfedunet.AnyItemsMod;

public class BaseArmorItem extends ArmorItem {

    public BaseArmorItem(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, new FabricItemSettings().group(AnyItemsMod.GENERAL));
    }
}
