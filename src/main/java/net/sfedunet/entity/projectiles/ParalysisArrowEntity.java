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
   if(entityHitResult.getEntity().getType() != EntityType.ARMOR_STAND){

entityHitResult.getEntity().getDataTracker().set(PARALYSIS,10*20);
       world.playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.BLOCK_ANVIL_DESTROY, SoundCategory.HOSTILE, 1F,1F);




   }
    }



    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(Items.ARROW);
    }
}


