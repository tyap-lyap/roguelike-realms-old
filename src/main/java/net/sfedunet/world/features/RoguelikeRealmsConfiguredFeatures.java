package net.sfedunet.world.features;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.CountNoiseDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.sfedunet.RoguelikeRealmsMod;
import net.sfedunet.block.RoguelikeRealmsBlocks;
import net.sfedunet.world.features.trees.placers.DragonGrapeFoliagePlacer;
import net.sfedunet.world.features.trees.placers.DragonGrapeTrunkPlacer;
import net.sfedunet.world.features.trees.placers.DragonWillowFoliagePlacer;
import net.sfedunet.world.features.trees.placers.DragonWillowTrunkPlacer;

public class RoguelikeRealmsConfiguredFeatures {

    public static ConfiguredFeature<TreeFeatureConfig, ?> DRAGON_GRAPE, DRAGON_WILLOW;
    public static ConfiguredFeature<?,?> DRAGON_GRASS_PATCH, DRAGON_DAISY_PATCH;
    public static ConfiguredFeature<?, ?> DRACONIC_FOREST_TREES, DRACONIC_FIELDS_TREES;
    public static ConfiguredFeature<?, ?> CRYPTON_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, RoguelikeRealmsBlocks.CRYPTON_ORE.getDefaultState(), 5)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0,20,40))).spreadHorizontally().repeat(10);
    public static ConfiguredFeature<?, ?> ECHSEROCK_ORE_DRAGONIC = Feature.ORE.configure(new OreFeatureConfig(Rules.DRAGONSTONE, RoguelikeRealmsBlocks.ECHSEROCK.getDefaultState(),6)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(10, 20, 255))).spreadHorizontally().repeat(15);
    public static void register() {
        DRAGON_GRAPE = register("dragon_grape", Feature.TREE.configure(Configs.DRAGON_GRAPE_CONFIG));
        DRAGON_WILLOW = register("dragon_willow", Feature.TREE.configure(Configs.DRAGON_WILLOW_CONFIG));
        DRACONIC_FOREST_TREES = register("draconic_forest_trees", Feature.RANDOM_SELECTOR.configure(Configs.DRACONIC_TREES_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.15F, 1))));
        DRACONIC_FIELDS_TREES = register("draconic_fields_trees", Feature.RANDOM_SELECTOR.configure(Configs.DRACONIC_TREES_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.05F, 1))));
        DRAGON_GRASS_PATCH = register("dragon_grass_patch", Feature.RANDOM_PATCH.configure(RoguelikeRealmsConfiguredFeatures.Configs.DRAGON_GRASS_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).decorate(Decorator.COUNT_NOISE.configure(new CountNoiseDecoratorConfig(-0.8D, 5, 10))));
        DRAGON_DAISY_PATCH = register("dragon_daisy_patch", Feature.RANDOM_PATCH.configure((new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(RoguelikeRealmsBlocks.DRAGON_DAISY.getDefaultState()), new SimpleBlockPlacer())).tries(64).cannotProject().build()).decorate(ConfiguredFeatures.Decorators.SPREAD_32_ABOVE).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).repeat(10));

        RegistryKey<ConfiguredFeature<?, ?>> oreEchserockDragonic = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("anyitem:echserock"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreEchserockDragonic.getValue(), ECHSEROCK_ORE_DRAGONIC);

        RegistryKey<ConfiguredFeature<?, ?>> oreCryptonOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("anyitem:crypton_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreCryptonOverworld.getValue(), CRYPTON_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreCryptonOverworld);
    }
    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, RoguelikeRealmsMod.MODID + ":" + id, configuredFeature);
    }
    public static class Configs {
        public static final TreeFeatureConfig DRAGON_GRAPE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(RoguelikeRealmsBlocks.DRAGON_GRAPE_LOG.getDefaultState()), new SimpleBlockStateProvider(RoguelikeRealmsBlocks.DRAGON_GRAPE_LEAVES.getDefaultState()), new DragonGrapeFoliagePlacer(UniformIntDistribution.of(3, 1), UniformIntDistribution.of(0, 1)), new DragonGrapeTrunkPlacer(3, 2, 1), new TwoLayersFeatureSize(3, 0, 3))).ignoreVines().build();
        public static final TreeFeatureConfig DRAGON_WILLOW_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(RoguelikeRealmsBlocks.DRAGON_WILLOW_LOG.getDefaultState()), new SimpleBlockStateProvider(RoguelikeRealmsBlocks.DRAGON_WILLOW_LEAVES.getDefaultState()), new DragonWillowFoliagePlacer(UniformIntDistribution.of(3, 1), UniformIntDistribution.of(0, 1)), new DragonWillowTrunkPlacer(3, 2, 1), new TwoLayersFeatureSize(3, 0, 3))).ignoreVines().build();
        public static final RandomFeatureConfig DRACONIC_TREES_CONFIG = new RandomFeatureConfig(
                ImmutableList.of(Feature.TREE.configure(DRAGON_WILLOW_CONFIG).withChance(0.7F)),
                Feature.TREE.configure(Configs.DRAGON_GRAPE_CONFIG)
        );
        public static final RandomPatchFeatureConfig DRAGON_GRASS_CONFIG = (new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(RoguelikeRealmsBlocks.DRAGON_GRASS.getDefaultState()), SimpleBlockPlacer.INSTANCE)).tries(32).build();
    }
    public static final class Rules {
        public static final RuleTest DRAGONSTONE;

        static {
            DRAGONSTONE = new BlockMatchRuleTest(RoguelikeRealmsBlocks.DRAGON_STONE);
        }
    }
}