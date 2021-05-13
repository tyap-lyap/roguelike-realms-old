package net.sfedunet.roguelikerealms.world.structure;

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
import net.sfedunet.roguelikerealms.RoguelikeRealmsMod;
import net.sfedunet.roguelikerealms.world.features.DraconicBoneFeature;
import net.sfedunet.roguelikerealms.world.features.DraconicWellFeature;

public class RoguelikeRealmsStructures {
    public static final StructurePieceType BONE_PIECE = DraconicBoneGenerator.Piece::new;
    private static final StructureFeature<DefaultFeatureConfig> BONE = new DraconicBoneFeature(DefaultFeatureConfig.CODEC);
    private static final ConfiguredStructureFeature<?, ?> CONFIGURED_BONE = BONE.configure(DefaultFeatureConfig.DEFAULT);
    public static final StructurePieceType WELL_PIECE = DraconicBoneGenerator.Piece::new;
    private static final StructureFeature<DefaultFeatureConfig> WELL = new DraconicWellFeature(DefaultFeatureConfig.CODEC);
    private static final ConfiguredStructureFeature<?, ?> CONFIGURED_WELL = WELL.configure(DefaultFeatureConfig.DEFAULT);


    public static void registerStructures() {
        Registry.register(Registry.STRUCTURE_PIECE, new Identifier(RoguelikeRealmsMod.MODID, "bone_piece"), BONE_PIECE);
        FabricStructureBuilder.create(new Identifier(RoguelikeRealmsMod.MODID, "bone"), BONE).step(GenerationStep.Feature.SURFACE_STRUCTURES).defaultConfig(32, 8, 12345).adjustsSurface().register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> ConfiguredBone = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                new Identifier(RoguelikeRealmsMod.MODID, "bone"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ConfiguredBone.getValue(), CONFIGURED_BONE);

        Registry.register(Registry.STRUCTURE_PIECE, new Identifier(RoguelikeRealmsMod.MODID, "well_piece"), WELL_PIECE);
        FabricStructureBuilder.create(new Identifier(RoguelikeRealmsMod.MODID, "well"), WELL).step(GenerationStep.Feature.SURFACE_STRUCTURES).defaultConfig(32, 8, 12345).adjustsSurface().register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> ConfiguredWell = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                new Identifier(RoguelikeRealmsMod.MODID, "well"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, ConfiguredWell.getValue(), CONFIGURED_WELL);
    }
}
