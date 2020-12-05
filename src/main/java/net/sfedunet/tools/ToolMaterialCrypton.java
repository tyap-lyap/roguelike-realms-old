package net.sfedunet.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.sfedunet.items.AnyItemsItems;

public class ToolMaterialCrypton implements ToolMaterial {
    @Override
    public int getDurability() {
        return 3521;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2.6f;
    }

    @Override
    public float getAttackDamage() {
        return 5.5f;
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
        return Ingredient.ofItems(AnyItemsItems.CRYPTONEZERIT);
    }
}
