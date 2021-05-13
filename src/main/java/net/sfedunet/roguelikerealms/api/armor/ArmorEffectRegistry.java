package net.sfedunet.roguelikerealms.api.armor;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class ArmorEffectRegistry {

    private static final ArrayList<ArmorEffect> armorEffects = new ArrayList<>();

    public static void register(String name, Item helmet, Item chestplate, Item leggings, Item boots, StatusEffect statusEffect){

        ArmorEffect armorEffect = new ArmorEffect(name, helmet, chestplate, leggings, boots, statusEffect);
        armorEffects.add(armorEffect);

    }

    public static void register(Item helmet, Item chestplate, Item leggings, Item boots, StatusEffect statusEffect){

        ArmorEffect armorEffect = new ArmorEffect(helmet, chestplate, leggings, boots, statusEffect);
        armorEffects.add(armorEffect);

    }

    public static void register(ArmorEffect customArmorEffect){

        armorEffects.add(customArmorEffect);

    }

    public static ArrayList<ArmorEffect> getArmorEffects(){

        return armorEffects;

    }
}
