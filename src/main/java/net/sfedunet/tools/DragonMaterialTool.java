package net.sfedunet.tools;


import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.sfedunet.items.AnyItemsItems;

public class DragonMaterialTool implements ToolMaterial {
    @Override
    public int getDurability() {
        return 5509;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.5f;
    }

    @Override
    public float getAttackDamage() {
        return 6.5f;
    }

    @Override
    public int getMiningLevel() {
        return 6;
    }

    @Override
    public int getEnchantability() {
        return 27;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AnyItemsItems.DRAGON_INGOT);
    }
}

