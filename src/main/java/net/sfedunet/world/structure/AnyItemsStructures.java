package net.sfedunet.world.structure;

import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.world.features.DraconicBoneFeature;
import net.sfedunet.world.features.DraconicWellFeature;

public class AnyItemsStructures {
    public static final StructurePieceType BONE_PIECE = DraconicBoneGenerator.Piece::new;
    private static final StructureFeature<DefaultFeatureConfig> BONE = new DraconicBoneFeature(DefaultFeatureConfig.CODEC);
    private static final ConfiguredStructureFeature<?, ?> CONFIGURED_BONE = BONE.configure(DefaultFeatureConfig.DEFAULT);
    public static final StructurePieceType WELL_PIECE = DraconicBoneGenerator.Piece::new;
    private static final StructureFeature<DefaultFeatureConfig> WELL = new DraconicWellFeature(DefaultFeatureConfig.CODEC);
    private static final ConfiguredStructureFeature<?, ?> CONFIGURED_WELL = WELL.configure(DefaultFeatureConfig.DEFAULT);


    public static void registerStructures() {
        Registry.register(Registry.STRUCTURE_PIECE, new Identifier(AnyItemsMod.MODID, "bone_piece"), BONE_PIECE);
        FabricStructureBuilder.create(new Identifier(AnyItemsMod.MODID, "bone"), BONE).step(GenerationStep.Feature.SURFACE_STRUCTURES).defaultConfig(32, 8, 12345).adjustsSurface().register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> ConfiguredBone = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                new Identifier(AnyItemsMod.MODID, "bone"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ConfiguredBone.getValue(), CONFIGURED_BONE);

        Registry.register(Registry.STRUCTURE_PIECE, new Identifier(AnyItemsMod.MODID, "well_piece"), WELL_PIECE);
        FabricStructureBuilder.create(new Identifier(AnyItemsMod.MODID, "well"), WELL).step(GenerationStep.Feature.SURFACE_STRUCTURES).defaultConfig(32, 8, 12345).adjustsSurface().register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> ConfiguredWell = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                new Identifier(AnyItemsMod.MODID, "well"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ConfiguredWell.getValue(), CONFIGURED_WELL);
    }
}
