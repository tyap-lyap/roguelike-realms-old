package net.sfedunet.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TrackTargetGoal.class)
public abstract class TrackTargetGoalMixin{

    @Shadow @Final protected MobEntity mob;

    @Shadow @Inject(at = @At("HEAD"), method = "shouldContinue",cancellable = true)

    public void shouldContinue(CallbackInfoReturnable<Boolean> ret){

        if (mob.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >=1 && mob.getType() != EntityType.PLAYER) {

            ret.setReturnValue(Boolean.FALSE);
        }
    }
}