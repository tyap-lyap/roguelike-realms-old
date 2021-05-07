package net.sfedunet.mixin.common;

import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LookControl.class)
public class LookControlMixin {

    protected final MobEntity entity;
    protected float yawSpeed;
    protected float pitchSpeed;
    protected boolean active;
    protected double lookX;
    protected double lookY;
    protected double lookZ;

    public LookControlMixin(MobEntity entity) {
        this.entity = entity;
    }

    @Shadow protected float getTargetPitch() {
        double d = this.lookX - this.entity.getX();
        double e = this.lookY - this.entity.getEyeY();
        double f = this.lookZ - this.entity.getZ();
        double g = (double) MathHelper.sqrt(d * d + f * f);
        return (float) (-(MathHelper.atan2(e, g) * 57.2957763671875D));
    }

    @Shadow protected float getTargetYaw() {
        double d = this.lookX - this.entity.getX();
        double e = this.lookZ - this.entity.getZ();
        return (float) (MathHelper.atan2(e, d) * 57.2957763671875D) - 90.0F;
    }

    @Shadow protected float changeAngle(float from, float to, float max) {
        float f = MathHelper.subtractAngles(from, to);
        float g = MathHelper.clamp(f, -max, max);
        return from + g;
    }

    @Shadow protected boolean shouldStayHorizontal() {
        return true;
    }

    public void tick() {
        if (this.entity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) == 0) {
            if (this.shouldStayHorizontal()) {
                this.entity.pitch = 0.0F;
            }

            if (this.active) {
                this.active = false;
                this.entity.headYaw = this.changeAngle(this.entity.headYaw, this.getTargetYaw(), this.yawSpeed);
                this.entity.pitch = this.changeAngle(this.entity.pitch, this.getTargetPitch(), this.pitchSpeed);
            } else {
                this.entity.headYaw = this.changeAngle(this.entity.headYaw, this.entity.bodyYaw, 10.0F);
            }

            if (!this.entity.getNavigation().isIdle()) {
                this.entity.headYaw = MathHelper.stepAngleTowards(this.entity.headYaw, this.entity.bodyYaw, (float) this.entity.getBodyYawSpeed());
            }
        }
    }
}