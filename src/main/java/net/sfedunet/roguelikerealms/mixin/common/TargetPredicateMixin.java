package net.sfedunet.roguelikerealms.mixin.common;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.mob.MobEntity;
import net.sfedunet.roguelikerealms.entity.projectiles.ParalysisArrowEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import java.util.function.Predicate;

@Mixin(TargetPredicate.class)
public class TargetPredicateMixin {
    @Shadow
    private double baseMaxDistance = -1.0D;
    @Shadow
    private boolean includeInvulnerable;
    @Shadow
    private boolean includeTeammates;
    @Shadow
    private boolean includeHidden;
    @Shadow
    private boolean ignoreEntityTargetRules;
    @Shadow
    private boolean useDistanceScalingFactor = true;
    @Shadow
    private Predicate<LivingEntity> predicate;


    public boolean test(@Nullable LivingEntity baseEntity, LivingEntity targetEntity) {
        if (baseEntity == targetEntity) {
            return false;
        } else if (targetEntity.isSpectator()) {
            return false;
        } else if (!targetEntity.isAlive()) {
            return false;
        } else if (!this.includeInvulnerable && targetEntity.isInvulnerable()) {
            return false;
        } else if (this.predicate != null && !this.predicate.test(targetEntity)) {
            return false;
        } else {
            if (baseEntity != null) {
                if (!this.ignoreEntityTargetRules) {
                    if (!baseEntity.canTarget(targetEntity)) {
                        return false;
                    }

                    if (!baseEntity.canTarget(targetEntity.getType())) {
                        return false;
                    }
                }

                if (!this.includeTeammates && baseEntity.isTeammate(targetEntity)) {
                    return false;
                }

                if (baseEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1) {
                    return false;
                }

                if (this.baseMaxDistance > 0.0D) {
                    double d = this.useDistanceScalingFactor ? targetEntity.getAttackDistanceScalingFactor(baseEntity) : 1.0D;
                    double e = Math.max(this.baseMaxDistance * d, 2.0D);
                    double f = baseEntity.squaredDistanceTo(targetEntity.getX(), targetEntity.getY(), targetEntity.getZ());
                    if (f > e * e) {
                        return false;
                    }
                }

                if (!this.includeHidden && baseEntity instanceof MobEntity && !((MobEntity) baseEntity).getVisibilityCache().canSee(targetEntity)) {
                    return false;
                }
            }

            return true;
        }
    }
}
