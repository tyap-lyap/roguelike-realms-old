package net.sfedunet.world.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.sfedunet.blocks.AnyItemsBlocks;

public class AnyItemsConfiguredFeatures {
    public static ConfiguredFeature<TreeFeatureConfig, ?> DRAGONWOOD;
    public static ConfiguredFeature<TreeFeatureConfig, ?> DRAGONWOODTWO;
    public static ConfiguredFeature<?, ?> DRACONIC_TREES;
    public static final ConfiguredFeature<?, ?> CRYPTON_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, AnyItemsBlocks.CRYPTON_ORE.getDefaultState(), 5)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0,20,40))).spreadHorizontally().repeat(10);

    public static void register() {

        DRAGONWOOD = register("anyitem:dragonwood", Feature.TREE.configure(Configs.DRAGONWOOD_CONFIG));
        DRAGONWOODTWO = register("anyitem:dragonwoodtwo", Feature.TREE.configure(Configs.DRAGONWOODTWO_CONFIG));
        DRACONIC_TREES = register("anyitem:draconic_trees", Feature.RANDOM_SELECTOR.configure(Configs.DRACONIC_TREES_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(5, 0.3F, 1))));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("anyitem:crypton_ore_otherworld"), CRYPTON_ORE_OVERWORLD);
    }
    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id, configuredFeature);
    }
    public static class Configs {
        public static final TreeFeatureConfig DRAGONWOOD_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.BLACK_WOOL.getDefaultState()), new SimpleBlockStateProvider(Blocks.YELLOW_WOOL.getDefaultState()), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
        public static final TreeFeatureConfig DRAGONWOODTWO_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.GRAY_WOOL.getDefaultState()), new SimpleBlockStateProvider(Blocks.RED_WOOL.getDefaultState()), new BlobFoliagePlacer(UniformIntDistribution.of(2), UniformIntDistribution.of(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
        public static final RandomFeatureConfig DRACONIC_TREES_CONFIG = new RandomFeatureConfig(
                ImmutableList.of(Feature.TREE.configure(DRAGONWOODTWO_CONFIG).withChance(0.7F)),
                Feature.TREE.configure(Configs.DRAGONWOOD_CONFIG)
        );
    }

}
