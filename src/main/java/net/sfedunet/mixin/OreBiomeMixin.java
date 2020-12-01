package net.sfedunet.mixin;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.sfedunet.world.features.AnyItemsConfiguredFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class OreBiomeMixin {
    @Mixin(DefaultBiomeFeatures.class)
    public static class DefaultBiomeFeaturesMixin {
        @Inject(method = "addDefaultOres(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V", at = @At("TAIL"))
        private static void addDefaultOres(GenerationSettings.Builder builder, CallbackInfo ci) {
            builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, AnyItemsConfiguredFeatures.CRYPTON_ORE_OVERWORLD);
        }
    }
}
