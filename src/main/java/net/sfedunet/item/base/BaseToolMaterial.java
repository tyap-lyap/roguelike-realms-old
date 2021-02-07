package net.sfedunet.item.base;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BaseToolMaterial implements ToolMaterial {

    private final int durability;
    private final float miningSpeedMultiplier;
    private final float attackDamage;
    private final int miningLevel;
    private final int enchantability;
    private final Ingredient repairMaterial;

    public BaseToolMaterial(int durability, float miningSpeedMultiplier, float attackDamage, int miningLevel, int enchantability, Ingredient repairMaterial){
        this.durability = durability;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamage = attackDamage;
        this.miningLevel = miningLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    public BaseToolMaterial(int durability, float miningSpeedMultiplier, float attackDamage, int miningLevel, int enchantability){
        this.durability = durability;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamage = attackDamage;
        this.miningLevel = miningLevel;
        this.enchantability = enchantability;
        this.repairMaterial = null;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return miningLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial;
    }
}
