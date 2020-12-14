package net.sfedunet.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.World;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {

    private static final TrackedData<Byte> MOB_FLAGS;

    MobEntity mob = ((MobEntity) (Object) this);

    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    public int getParalysis() {
        return (Integer) this.dataTracker.get(ParalysisArrowEntity.PARALYSIS);
    }

    public void setParalysis(int paralysis) {
        this.dataTracker.set(ParalysisArrowEntity.PARALYSIS, paralysis);
    }

    @Inject(at = @At("HEAD"), method = "initDataTracker")
    protected void initDataTracker(CallbackInfo info) {
        this.dataTracker.startTracking(ParalysisArrowEntity.PARALYSIS, 0);
    }

    @Inject(at = @At("HEAD"), method = "writeCustomDataToTag")

    public void writeCustomDataToTag(CompoundTag tag, CallbackInfo ci) {
        tag.putInt("Paralysis", this.getParalysis());

    }

    @Inject(at = @At("HEAD"), method = "readCustomDataFromTag")
    public void readCustomDataFromTag(CompoundTag tag, CallbackInfo ci) {
        if (tag.contains("Paralysis", 99)) {
            this.setParalysis(tag.getInt("Paralysis"));
        }
    }

    @Inject(at = @At("HEAD"), method = "canTarget", cancellable = true)
    public void canTarget(CallbackInfoReturnable<Boolean> ret) {
        if (mob.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1 && mob.getType() != EntityType.PLAYER && mob.getType() != EntityType.ZOGLIN && mob.getType() != EntityType.PIGLIN && mob.getType() != EntityType.PIGLIN_BRUTE) {

            ret.setReturnValue(Boolean.FALSE);
        }
    }

    static {
        ParalysisArrowEntity.PARALYSIS = DataTracker.registerData(MobEntity.class, TrackedDataHandlerRegistry.INTEGER);
        MOB_FLAGS = DataTracker.registerData(MobEntity.class, TrackedDataHandlerRegistry.BYTE);
    }
}