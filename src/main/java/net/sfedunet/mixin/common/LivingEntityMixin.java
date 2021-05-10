package net.sfedunet.mixin.common;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sfedunet.api.armor.ArmorEffectRegistry;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Mutable @Final @Shadow private static final EntityAttributeModifier SPRINTING_SPEED_BOOST;
    @Mutable @Final @Shadow protected static final TrackedData<Byte> LIVING_FLAGS;
    @Mutable @Final @Shadow private static final TrackedData<Float> HEALTH;
    @Mutable @Final @Shadow private static final TrackedData<Integer> POTION_SWIRLS_COLOR;
    @Mutable @Final @Shadow private static final TrackedData<Boolean> POTION_SWIRLS_AMBIENT;
    @Mutable @Final @Shadow private static final TrackedData<Integer> STUCK_ARROW_COUNT;
    @Mutable @Final @Shadow private static final TrackedData<Integer> STINGER_COUNT;
    @Mutable @Final @Shadow private static final TrackedData<Optional<BlockPos>> SLEEPING_POSITION;
    @Mutable @Final @Shadow protected static final EntityDimensions SLEEPING_DIMENSIONS;
    @Mutable @Final @Shadow private static final UUID SPRINTING_SPEED_BOOST_ID = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");

    LivingEntity self = ((LivingEntity) (Object) this);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "canTarget(Lnet/minecraft/entity/LivingEntity;)Z",cancellable = true)

    public void canTarget(CallbackInfoReturnable<Boolean> ret) {

        if (self.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1) {

            ret.setReturnValue(Boolean.FALSE);
        }
    }

        @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo ci) {

            if (self.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1) {
                self.getDataTracker().set(ParalysisArrowEntity.PARALYSIS, self.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) - 1);
            }
            if (self.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 2 && self.getType() == EntityType.PLAYER) {
                self.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, self.getDataTracker().get(ParalysisArrowEntity.PARALYSIS), 4));
                self.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, self.getDataTracker().get(ParalysisArrowEntity.PARALYSIS), 4));
                self.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, self.getDataTracker().get(ParalysisArrowEntity.PARALYSIS), 4));
            } else {
                if (self.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1 && self.getType() == EntityType.PLAYER) {
                    self.removeStatusEffect(StatusEffects.SLOWNESS);
                    self.removeStatusEffect(StatusEffects.WEAKNESS);
                    self.removeStatusEffect(StatusEffects.MINING_FATIGUE);
                }
            }

//            ArmorEffectRegistry.getArmorEffects().forEach(armorEffect -> {
//                if(Arrays.equals(this.getArmorAsList(), armorEffect.getArmorAsList())){
//                    if(armorEffect.getEffectInstance() != null){
//                        self.addStatusEffect(armorEffect.getEffectInstance());
//                    }
//                    armorEffect.tick(self, world);
//                }
//            });


        }

    public int getParalysis() {
        return this.dataTracker.get(ParalysisArrowEntity.PARALYSIS);
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

//    @Inject(at = @At("HEAD"), method = "tryUseTotem", cancellable = true)
//    private void tryUseTotem(DamageSource source, CallbackInfoReturnable<Boolean> cir){
//
//        if(ReincarnationStone.onDeath(livingEntity, world, source)){
//            cir.setReturnValue(true);
//        }
//
//    }

    static {
        SPRINTING_SPEED_BOOST = new EntityAttributeModifier(SPRINTING_SPEED_BOOST_ID, "Sprinting speed boost", 0.30000001192092896D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        LIVING_FLAGS = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.BYTE);
        HEALTH = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.FLOAT);
        POTION_SWIRLS_COLOR = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.INTEGER);
        POTION_SWIRLS_AMBIENT = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
        STUCK_ARROW_COUNT = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.INTEGER);
        STINGER_COUNT = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.INTEGER);
        SLEEPING_POSITION = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.OPTIONAL_BLOCK_POS);
        SLEEPING_DIMENSIONS = EntityDimensions.fixed(0.2F, 0.2F);
        ParalysisArrowEntity.PARALYSIS = DataTracker.registerData(LivingEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }
}