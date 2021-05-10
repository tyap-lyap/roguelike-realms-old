package net.sfedunet.util;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;

public class AnyUtils {

    public static Item[] getArmorAsList(LivingEntity livingEntity){
        return new Item[]{livingEntity.getEquippedStack(EquipmentSlot.FEET).getItem(), livingEntity.getEquippedStack(EquipmentSlot.LEGS).getItem(), livingEntity.getEquippedStack(EquipmentSlot.CHEST).getItem(), livingEntity.getEquippedStack(EquipmentSlot.HEAD).getItem()};
    }
}
