package net.sfedunet.api.armor;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ArmorEffect {

    private final Item helmet;
    private final Item chestplate;
    private final Item leggings;
    private final Item boots;

    private final StatusEffectInstance effectInstance;

    public ArmorEffect(Item helmet, Item chestplate, Item leggings, Item boots, @Nullable StatusEffectInstance effectInstance){
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
        this.effectInstance = effectInstance;

    }

    public Item[] getArmorAsList(){
        return new Item[]{this.boots, this.leggings, this.chestplate, this.helmet};
    }

    public StatusEffectInstance getEffectInstance(){
        return this.effectInstance;
    }

    public void tick(LivingEntity entity, World world){

    }

}