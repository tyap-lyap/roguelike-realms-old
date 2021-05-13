package net.sfedunet.roguelikerealms.mixin.common;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.ZoglinEntity;
import net.minecraft.world.World;
import net.sfedunet.roguelikerealms.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ZoglinEntity.class)
public class ZoglinEntityMixin extends HostileEntity implements Monster{

    protected ZoglinEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "tryAttack", cancellable = true)
    public void tryAttack(CallbackInfoReturnable<Boolean> ret) {
        if (this.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) > 0) {
            ret.setReturnValue(Boolean.FALSE);
        }
    }
}