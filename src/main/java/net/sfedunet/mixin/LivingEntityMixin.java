package net.sfedunet.mixin;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.UUID;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    private static final UUID PARALYSIS = UUID.fromString("CB3F15D5-645C-4F38-A897-8C13A33DB1CF");

    LivingEntity livingEntity = ((LivingEntity) (Object) this);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo ci) {

        if (livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1 && livingEntity.getType() != EntityType.PLAYER) {
            livingEntity.getDataTracker().set(ParalysisArrowEntity.PARALYSIS, livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) - 1);

            if (!livingEntity.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_MOVEMENT_SPEED, PARALYSIS)) {
                livingEntity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).addTemporaryModifier(new EntityAttributeModifier(PARALYSIS, "Paralysis", -1111, EntityAttributeModifier.Operation.ADDITION));
            }
        } else {
            if (livingEntity.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_MOVEMENT_SPEED, PARALYSIS)) {
                livingEntity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).removeModifier(PARALYSIS);
            }
        }
        if (livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 2 && livingEntity.getType() == EntityType.PLAYER) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS), 4));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS), 4));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS), 4));
            livingEntity.getDataTracker().set(ParalysisArrowEntity.PARALYSIS, livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) - 1);
        } else {
            if (livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1 && livingEntity.getType() == EntityType.PLAYER) {
                livingEntity.removeStatusEffect(StatusEffects.SLOWNESS);
                livingEntity.removeStatusEffect(StatusEffects.WEAKNESS);
                livingEntity.removeStatusEffect(StatusEffects.MINING_FATIGUE);
            }
        }
        if (livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 2 && livingEntity.getType() != EntityType.PLAYER) {
            livingEntity.setCustomNameVisible(true);
            livingEntity.setCustomName(Text.of("§cParalysis:§b " + livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) + " §ctick(s)!"));
        } else {
            if (livingEntity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1 && livingEntity.getType() != EntityType.PLAYER) {
                livingEntity.setCustomNameVisible(false);
                livingEntity.setCustomName(Text.of(""));
            }
        }
    }
}