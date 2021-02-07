package net.sfedunet.item.base;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class BaseArmorMaterial implements ArmorMaterial {

    private final String name;
    private final int[] durability;
    private final float toughness;
    private final int[] damageReduction;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final Ingredient repairMaterial;

    public BaseArmorMaterial(String name, int[] durability, int[] damageReduction, int enchantability, SoundEvent soundEvent, float toughness, Ingredient repairMaterial){
        this.name = name;
        this.durability = durability;
        this.toughness = toughness;
        this.damageReduction = damageReduction;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurability(EquipmentSlot entityEquipmentSlot){
        return durability[entityEquipmentSlot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot entityEquipmentSlot){
        return damageReduction[entityEquipmentSlot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability(){
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound(){
        return soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient(){
        return repairMaterial;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public float getToughness(){
        return toughness;
    }

    @Override
    public float getKnockbackResistance(){
        return 0;
    }

}
