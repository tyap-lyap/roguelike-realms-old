package net.sfedunet.entity.projectiles;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;


public class ParalysisArrowEntity extends ArrowEntity{
    public static TrackedData<Integer> PARALYSIS;

    public ParalysisArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public ParalysisArrowEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public ParalysisArrowEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

@Override
    public void onEntityHit(EntityHitResult entityHitResult) {
    super.onEntityHit(entityHitResult);
    if  (entityHitResult.getEntity().getType() == EntityType.PLAYER || entityHitResult.getEntity().getType() == EntityType.ZOMBIE || entityHitResult.getEntity().getType() == EntityType.PIGLIN_BRUTE || entityHitResult.getEntity().getType() == EntityType.PIGLIN || entityHitResult.getEntity().getType() == EntityType.PIG || entityHitResult.getEntity().getType() == EntityType.WITCH || entityHitResult.getEntity().getType() == EntityType.WITCH || entityHitResult.getEntity().getType() == EntityType.DROWNED || entityHitResult.getEntity().getType() == EntityType.WANDERING_TRADER || entityHitResult.getEntity().getType() == EntityType.VINDICATOR || entityHitResult.getEntity().getType() == EntityType.EVOKER || entityHitResult.getEntity().getType() == EntityType.VILLAGER || entityHitResult.getEntity().getType() == EntityType.ZOMBIE_VILLAGER || entityHitResult.getEntity().getType() == EntityType.GHAST || entityHitResult.getEntity().getType() == EntityType.ZOMBIFIED_PIGLIN || entityHitResult.getEntity().getType() == EntityType.WITHER_SKELETON || entityHitResult.getEntity().getType() == EntityType.BLAZE || entityHitResult.getEntity().getType() == EntityType.CREEPER || entityHitResult.getEntity().getType() == EntityType.SKELETON || entityHitResult.getEntity().getType() == EntityType.ZOGLIN || entityHitResult.getEntity().getType() == EntityType.BAT || entityHitResult.getEntity().getType() == EntityType.BEE || entityHitResult.getEntity().getType() == EntityType.CAT || entityHitResult.getEntity().getType() == EntityType.CAVE_SPIDER || entityHitResult.getEntity().getType() == EntityType.CHICKEN || entityHitResult.getEntity().getType() == EntityType.COD || entityHitResult.getEntity().getType() == EntityType.COW || entityHitResult.getEntity().getType() == EntityType.DOLPHIN || entityHitResult.getEntity().getType() == EntityType.DONKEY || entityHitResult.getEntity().getType() == EntityType.FOX || entityHitResult.getEntity().getType() == EntityType.GUARDIAN || entityHitResult.getEntity().getType() == EntityType.GIANT || entityHitResult.getEntity().getType() == EntityType.HOGLIN || entityHitResult.getEntity().getType() == EntityType.HORSE || entityHitResult.getEntity().getType() == EntityType.HUSK || entityHitResult.getEntity().getType() == EntityType.ILLUSIONER || entityHitResult.getEntity().getType() == EntityType.IRON_GOLEM || entityHitResult.getEntity().getType() == EntityType.LLAMA || entityHitResult.getEntity().getType() == EntityType.MAGMA_CUBE || entityHitResult.getEntity().getType() == EntityType.MOOSHROOM || entityHitResult.getEntity().getType() == EntityType.MULE){
       entityHitResult.getEntity().getDataTracker().set(PARALYSIS, 1*20);
   }
    if (entityHitResult.getEntity().getType() == EntityType.ELDER_GUARDIAN || entityHitResult.getEntity().getType() == EntityType.WITHER || entityHitResult.getEntity().getType() == EntityType.ENDER_DRAGON){
        entityHitResult.getEntity().getDataTracker().set(PARALYSIS, 1*10);
    }
}
    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.ARROW);
    }
}