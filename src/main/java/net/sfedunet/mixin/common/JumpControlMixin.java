package net.sfedunet.mixin.common;

import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.mob.MobEntity;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(JumpControl.class)
public class JumpControlMixin {
    @Mutable @Final @Shadow private final MobEntity entity;
    @Shadow protected boolean active;

    public JumpControlMixin(MobEntity entity) {
        this.entity = entity;
    }

    public void tick() {
        if (this.entity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) == 0) {
            this.entity.setJumping(this.active);
            this.active = false;
        }
    }
}