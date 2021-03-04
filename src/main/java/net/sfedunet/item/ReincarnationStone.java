package net.sfedunet.item;

import net.fabricmc.fabric.api.dimension.v1.FabricDimensions;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.sfedunet.mixin.LivingEntityInvoker;
import net.sfedunet.world.dimension.DraconicShadow;

import java.util.Objects;

public class ReincarnationStone extends Item {

    public ReincarnationStone() {
        super(new FabricItemSettings().group(AnyItemGroups.ITEMS).maxCount(1));
    }

    public static boolean onDeath(LivingEntity livingEntity, World world, DamageSource source){
        if(livingEntity instanceof PlayerEntity){

            PlayerEntity playerEntity = ((PlayerEntity) livingEntity);

            ItemStack mainHand = playerEntity.getStackInHand(Hand.MAIN_HAND);
            ItemStack offHand = playerEntity.getStackInHand(Hand.OFF_HAND);

            if(mainHand != Items.TOTEM_OF_UNDYING.getDefaultStack() && offHand != Items.TOTEM_OF_UNDYING.getDefaultStack()){

                if(playerEntity.inventory.contains(AnyItemsItems.REINCARNATION_STONE.getDefaultStack())){

                    if(world.getRegistryKey() == DraconicShadow.DRACONIC_SHADOW){

                        playerEntity.inventory.removeStack(playerEntity.inventory.getSlotWithStack(AnyItemsItems.REINCARNATION_STONE.getDefaultStack()),1);
                        ((LivingEntityInvoker) playerEntity).callDrop(source);
                        playerEntity.setHealth(20.0F);
                        playerEntity.clearStatusEffects();

                        ServerWorld nether = Objects.requireNonNull(world.getServer()).getWorld(World.NETHER);
                        FabricDimensions.teleport(playerEntity, nether, new TeleportTarget(new Vec3d(0.5f, 129, 0.5f), new Vec3d(0, 0, 0), playerEntity.yaw, playerEntity.pitch));

                        return true;

                    }


                }

            }

        }
        return false;
    }

}
