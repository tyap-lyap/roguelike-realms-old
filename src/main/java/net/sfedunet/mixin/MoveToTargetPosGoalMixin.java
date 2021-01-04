package net.sfedunet.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.MoveToTargetPosGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MoveToTargetPosGoal.class)
public class MoveToTargetPosGoalMixin {
    @Shadow
    @Final
    protected PathAwareEntity mob;

    @Inject(at = @At("HEAD"), method = "shouldContinue",cancellable = false)

    public void shouldContinue(CallbackInfoReturnable<Boolean> ret){

        if (mob.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >=1 && mob.getType() != EntityType.PLAYER) {

            ret.setReturnValue(Boolean.FALSE);
        }
    }
}