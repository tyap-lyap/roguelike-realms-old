package net.sfedunet.mixin;

import net.minecraft.entity.ai.goal.GoToWalkTargetGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GoToWalkTargetGoal.class)
public class GoToWalkTargetGoalMixin {


    private final PathAwareEntity mob;

    public GoToWalkTargetGoalMixin(PathAwareEntity mob) {
        this.mob = mob;
    }

    @Inject(at = @At("HEAD"), method = "shouldContinue", cancellable = true)
    public void shouldContinue(CallbackInfoReturnable<Boolean> ret) {

        if (this.mob.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1) {

            ret.setReturnValue(Boolean.FALSE);
        }
    }
}