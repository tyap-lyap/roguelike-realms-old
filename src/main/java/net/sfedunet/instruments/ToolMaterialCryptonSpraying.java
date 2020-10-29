package net.sfedunet.instruments;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.sfedunet.AnyItemsMod;

public class ToolMaterialCryptonSpraying implements ToolMaterial {
    @Override
    public int getDurability() {
        return 1750;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4;
    }

    @Override
    public float getAttackDamage() {
        return 4.5f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AnyItemsMod.CRYPTON_DUST);
    }
}
