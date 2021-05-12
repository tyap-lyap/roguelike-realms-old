package net.sfedunet.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.sfedunet.api.armor.ArmorEffectRegistry;
import net.sfedunet.interfaces.Reincarnation;
import net.sfedunet.item.ReincarnationStone;
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

        ServerPlayerEvents.ALLOW_DEATH.register((player, damageSource, damageAmount) -> {

            if(ReincarnationStone.canBeReincarnated(player)){

                //забрать камень
                ReincarnationStone.decrementReincarnationStone(player);

                //"if(player instanceof Reincarnation)" нужно обязательно чтобы можно было использовать методы интерфейса Reincarnation
                if(player instanceof Reincarnation){
                    ((Reincarnation) player).setCanReincarnate(true);
                }
            }
            return true;
        });

        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {

            if(oldPlayer instanceof Reincarnation && newPlayer instanceof Reincarnation){

                if(((Reincarnation) oldPlayer).canReincarnate()){

                    //отправить в жопу мира(пока незер)
                    ReincarnationStone.reincarnate(newPlayer);
                    ((Reincarnation) newPlayer).setCanReincarnate(false);

                }

            }

        });

    }
}
