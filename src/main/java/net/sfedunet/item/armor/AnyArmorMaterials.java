package net.sfedunet.item.armor;

import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.sfedunet.item.AnyItemsItems;
import net.sfedunet.item.base.BaseArmorMaterial;

public class AnyArmorMaterials {
    public static final BaseArmorMaterial CRYPTON_ARMOR_MATERIAL = new BaseArmorMaterial("crypton",
            new int[] {190, 225, 205, 180},
            new int[] {4, 6, 6, 4}, 32, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2,
            Ingredient.ofItems(AnyItemsItems.CRYPTON_DUST));

    public static final BaseArmorMaterial DRAGON_ARMOR_MATERIAL = new BaseArmorMaterial("dragon",
            new int[] {385, 450, 415, 370},
            new int[] {8, 12, 12, 8}, 50, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6,
            Ingredient.ofItems(AnyItemsItems.DRAGON_INGOT));

    public static final BaseArmorMaterial ECHSEROCK_ARMOR_MATERIAL = new BaseArmorMaterial("echserock",
            new int[] {385, 450, 415, 370},
            new int[] {8, 12, 12, 8}, 0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0,
            Ingredient.ofItems(AnyItemsItems.ECHSEROCK_CHUNK));

}
