package net.sfedunet.entity.projectiles;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

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

    private static int Random(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

@Override
    public void onEntityHit(EntityHitResult entityHitResult) {
    super.onEntityHit(entityHitResult);

    //Humans and Simple Monsters
    //Undead
    if (entityHitResult.getEntity().getType() == EntityType.ZOMBIE || entityHitResult.getEntity().getType() == EntityType.SKELETON || entityHitResult.getEntity().getType() == EntityType.ZOMBIE_VILLAGER || entityHitResult.getEntity().getType() == EntityType.ZOMBIFIED_PIGLIN) {
        entityHitResult.getEntity().getDataTracker().set(PARALYSIS, Random(6*20, 8*20));
        System.out.println(entityHitResult.getEntity().getDataTracker().get(PARALYSIS) + " тиков - теста рандома(Для справки - от 120 до 160 тиков)");
    }
    //Humanoid
    if (entityHitResult.getEntity().getType() == EntityType.CREEPER || entityHitResult.getEntity().getType() == EntityType.PLAYER || entityHitResult.getEntity().getType() == EntityType.VILLAGER || entityHitResult.getEntity().getType() == EntityType.PIGLIN || entityHitResult.getEntity().getType() == EntityType.PIGLIN_BRUTE || entityHitResult.getEntity().getType() == EntityType.EVOKER || entityHitResult.getEntity().getType() == EntityType.VINDICATOR || entityHitResult.getEntity().getType() == EntityType.VEX || entityHitResult.getEntity().getType() == EntityType.WANDERING_TRADER || entityHitResult.getEntity().getType() == EntityType.WITCH) {
        entityHitResult.getEntity().getDataTracker().set(PARALYSIS, Random(8*20, 10*20));
        System.out.println(entityHitResult.getEntity().getDataTracker().get(PARALYSIS) + " тиков - теста рандома(Для справки - от 160 до 200 тиков)");
    }

    if (entityHitResult.getEntity().getType() == EntityType.WITHER_SKELETON || entityHitResult.getEntity().getType() == EntityType.PIGLIN) {
        entityHitResult.getEntity().getDataTracker().set(PARALYSIS, 8 * 20);
    }
}

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.ARROW);
    }
}