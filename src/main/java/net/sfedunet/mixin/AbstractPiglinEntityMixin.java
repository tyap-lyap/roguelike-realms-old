package net.sfedunet.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PiglinActivity;
import net.minecraft.entity.mob.PiglinBruteEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractPiglinEntity.class)
public abstract class AbstractPiglinEntityMixin extends HostileEntity {

    protected AbstractPiglinEntityMixin(EntityType<? extends AbstractPiglinEntity> entityType, World world) {
        super(entityType, world);
    }
    @Nullable
    public LivingEntity getTarget() {
        if (this.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) != 0) {
            return null;

        } else {
           //
            //return (LivingEntity) this.brain.getOptionalMemory(MemoryModuleType.ATTACK_TARGET).orElse((LivingEntity) null);
        return  null;
        }

    }
}
