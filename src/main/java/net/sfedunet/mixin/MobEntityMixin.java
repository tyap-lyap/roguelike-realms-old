package net.sfedunet.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {

    MobEntity mob = ((MobEntity) (Object) this);

    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "canTarget",cancellable = true)
    public void canTarget(CallbackInfoReturnable<Boolean> ret) {
        if (mob.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >=1 && mob.getType() != EntityType.PLAYER && mob.getType() != EntityType.ZOGLIN && mob.getType() != EntityType.PIGLIN && mob.getType() != EntityType.PIGLIN_BRUTE) {

            ret.setReturnValue(Boolean.FALSE);
        }
    }
}