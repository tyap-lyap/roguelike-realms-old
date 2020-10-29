package net.sfedunet.instruments;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.sfedunet.AnyItemsMod;

public class ToolMaterialCrypton implements ToolMaterial {
    @Override
    public int getDurability() {
        return 3521;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.5f;
    }

    @Override
    public float getAttackDamage() {
        return 8.5f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 32;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AnyItemsMod.CRYPTON_DUST);
    }
}
