package net.sfedunet.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HoglinEntity.class)
public class HoglinEntityMixin extends AnimalEntity implements Monster{

    protected HoglinEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "tryAttack", cancellable = true)
    public void tryAttack(CallbackInfoReturnable<Boolean> ret) {
        if (this.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) > 0) {
            ret.setReturnValue(Boolean.FALSE);
        }
    }

    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        HoglinEntity hoglinEntity = (HoglinEntity)EntityType.HOGLIN.create(world);
        if (hoglinEntity != null) {
            hoglinEntity.setPersistent();
        }
        return hoglinEntity;
    }
}