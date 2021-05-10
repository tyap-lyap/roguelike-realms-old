package net.sfedunet.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.sfedunet.api.armor.ArmorEffectRegistry;
import net.sfedunet.util.AnyUtils;

import java.util.Arrays;

public class AnyItemsEvents {

    public static void register(){

        ServerTickEvents.START_WORLD_TICK.register((world) -> world.getPlayers().forEach((player) -> ArmorEffectRegistry.getArmorEffects().forEach(armorEffect -> {
            if(Arrays.equals(AnyUtils.getArmorAsList(player), armorEffect.getArmorAsList())){
                if(armorEffect.getStatusEffect() != null){
                    player.addStatusEffect(new StatusEffectInstance(armorEffect.getStatusEffect(), 60, 0, false, false));
                }
                armorEffect.tick(player, world);
            }
        })));

    }
}
