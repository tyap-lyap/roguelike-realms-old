package net.sfedunet.mixin.common;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {
  @Mutable @Final @Shadow private static final TrackedData<Byte> MOB_FLAGS;

    MobEntity mob = ((MobEntity) (Object) this);

    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "tryAttack",cancellable = true)

    public void tryAttack(Entity target,CallbackInfoReturnable<Boolean> ret){

        if (this.mob.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >=1) {

            ret.setReturnValue(Boolean.FALSE);
        }
    }

    public void setAttacking(boolean attacking) {
        byte b = (Byte)this.dataTracker.get(MOB_FLAGS);
        this.dataTracker.set(MOB_FLAGS, (byte)(b & -5));
    }

    @Inject(at = @At("HEAD"), method = "canTarget(Lnet/minecraft/entity/LivingEntity;)Z",cancellable = true)
    public void canTarget(CallbackInfoReturnable<Boolean> ret){

        if (this.mob.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >=1) {

            ret.setReturnValue(Boolean.FALSE);
        }
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo ci) {
        if (mob.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1) {
            mob.getNavigation().stop();
        }
    }
    static {
        MOB_FLAGS = DataTracker.registerData(MobEntity.class, TrackedDataHandlerRegistry.BYTE);
    }
}