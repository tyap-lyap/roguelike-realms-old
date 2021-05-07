package net.sfedunet.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class ReincarnationStone extends Item {

    public ReincarnationStone() {
        super(new FabricItemSettings().group(AnyItemGroups.ITEMS).maxCount(1));
    }

//    public static boolean onDeath(LivingEntity livingEntity, World world, DamageSource source){
//        if(livingEntity instanceof PlayerEntity){
//
//            PlayerEntity playerEntity = ((PlayerEntity) livingEntity);
//
//            ItemStack mainHand = playerEntity.getStackInHand(Hand.MAIN_HAND);
//            ItemStack offHand = playerEntity.getStackInHand(Hand.OFF_HAND);
//
//            if(mainHand != Items.TOTEM_OF_UNDYING.getDefaultStack() && offHand != Items.TOTEM_OF_UNDYING.getDefaultStack()){
//
//                if(playerEntity.inventory.contains(AnyItemsItems.REINCARNATION_STONE.getDefaultStack())){
//
//                    if(world.getRegistryKey() == DraconicShadow.DRACONIC_SHADOW){
//
//                        playerEntity.inventory.removeStack(playerEntity.inventory.getSlotWithStack(AnyItemsItems.REINCARNATION_STONE.getDefaultStack()),1);
//                        ((LivingEntityInvoker) playerEntity).callDrop(source);
//                        playerEntity.setHealth(20.0F);
//                        playerEntity.clearStatusEffects();
//
//                        ServerWorld nether = Objects.requireNonNull(world.getServer()).getWorld(World.NETHER);
//                        FabricDimensions.teleport(playerEntity, nether, new TeleportTarget(new Vec3d(0.5f, 129, 0.5f), new Vec3d(0, 0, 0), playerEntity.yaw, playerEntity.pitch));
//
//                        return true;
//
//                    }
//
//
//                }
//
//            }
//
//        }
//        return false;
//    }

}
