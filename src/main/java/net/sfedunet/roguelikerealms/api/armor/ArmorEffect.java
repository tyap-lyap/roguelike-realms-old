package net.sfedunet.roguelikerealms.api.armor;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ArmorEffect {

    private final String name;

    private final Item helmet;
    private final Item chestplate;
    private final Item leggings;
    private final Item boots;

    private final StatusEffect statusEffect;

    public ArmorEffect(String name, Item helmet, Item chestplate, Item leggings, Item boots, @Nullable StatusEffect statusEffect){
        this.name = name;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
        this.statusEffect = statusEffect;

    }
    public ArmorEffect(Item helmet, Item chestplate, Item leggings, Item boots, @Nullable StatusEffect statusEffect){
        this.name = null;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
        this.statusEffect = statusEffect;

    }

    public Item[] getArmorAsList(){
        return new Item[]{this.boots, this.leggings, this.chestplate, this.helmet};
    }

    public StatusEffect getStatusEffect(){
        return this.statusEffect;
    }

    public String getName(){
        return this.name;
    }

    public void tick(LivingEntity entity, World world){

    }

}
