package net.sfedunet.mixin;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.mob.MobEntity;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.EnumSet;

@Mixin(LookAroundGoal.class)
public class LookAroundGoalMixin extends Goal {
    private final MobEntity mob;
    private double deltaX;
    private double deltaZ;
    private int lookTime;

    public LookAroundGoalMixin(MobEntity mob) {
        this.mob = mob;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Inject(at = @At("HEAD"), method = "shouldContinue", cancellable = true)
    public void shouldContinue(CallbackInfoReturnable<Boolean> ret) {

        if (this.mob.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1) {

            ret.setReturnValue(Boolean.FALSE);
        }
    }

    public boolean canStart() {
        return this.mob.getRandom().nextFloat() < 0.02F;
    }
}