package net.sfedunet.api.armor;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class ArmorEffectRegistry {

    private static final ArrayList<ArmorEffect> armorEffects = new ArrayList<>();

    public static void register(Item helmet, Item chestplate, Item leggings, Item boots, StatusEffectInstance effectInstance){

        ArmorEffect armorEffect = new ArmorEffect(helmet, chestplate, leggings, boots, effectInstance);
        armorEffects.add(armorEffect);

    }

    public static void register(ArmorEffect customArmorEffect){

        armorEffects.add(customArmorEffect);

    }

    public static ArrayList<ArmorEffect> getArmorEffects(){

        return armorEffects;

    }
}
