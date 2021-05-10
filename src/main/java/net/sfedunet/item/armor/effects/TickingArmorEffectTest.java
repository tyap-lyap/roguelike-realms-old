package net.sfedunet.item.armor.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sfedunet.api.armor.ArmorEffect;

public class TickingArmorEffectTest extends ArmorEffect {

    public TickingArmorEffectTest(Item helmet, Item chestplate, Item leggings, Item boots, StatusEffect statusEffect) {
        super(helmet, chestplate, leggings, boots, statusEffect);
    }

    @Override
    public void tick(LivingEntity entity, World world){
        BlockPos blockPos = entity.getBlockPos();

        world.playSound(null, blockPos, SoundEvents.ENTITY_CAT_PURREOW, SoundCategory.PLAYERS, 1, 1);
    }
}
