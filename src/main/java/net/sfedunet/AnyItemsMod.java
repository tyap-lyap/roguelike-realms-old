package net.sfedunet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.sfedunet.instruments.*;

public class AnyItemsMod implements ModInitializer {
	public static final ItemGroup AI_GENERAL = FabricItemGroupBuilder.build(
			new Identifier("anyitem","general"),
			()->new ItemStack(AnyItemsMod.CRYPTONBLOCK));
	public static final Item CRYPTON_DUST = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item SHAURMA = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL).food(new FoodComponent.Builder().saturationModifier(7.5f).hunger(9).statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*20),0.2f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10),0.21f).build()));
    public static final Item COOKED_SHAURMA = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL).food(new FoodComponent.Builder().saturationModifier(15f).hunger(18).statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*15),0.09f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*30),0.1f).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 20*30,5),0.05f).build()));
	public static final Item ECHPOCHMAK = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL).food(new FoodComponent.Builder().saturationModifier(10f).hunger(14).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20*5),0.5f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5),0.5f).build()));
	public static final Item ONION = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL).food(new FoodComponent.Builder().saturationModifier(2f).hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*10),1f).build()));
	public static final Block CRYPTONBLOCK = new Block(FabricBlockSettings.copy(Blocks.OBSIDIAN).sounds(BlockSoundGroup.BONE));
	public static final Block CRYPTON_ORE = new Block(FabricBlockSettings.copy(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.STONE));


		public static ConfiguredFeature<?, ?> CRYPTON_ORE_OTHERWORLD = Feature.ORE.configure(new OreFeatureConfig(
				OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, AnyItemsMod.CRYPTON_ORE.getDefaultState(), 5)) // vein size
				.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0, // bottom offset
						20, // min y level
						40))) // max y level
				.spreadHorizontally()
				.repeat(10); // number of veins per chunk

	@Override
	public void onInitialize()
	{
		Registry.register(Registry.ITEM, new Identifier("anyitem", "crypton_dust"), CRYPTON_DUST);

		Registry.register(Registry.ITEM, new Identifier("anyitem", "shaurma"), SHAURMA);
        Registry.register(Registry.ITEM, new Identifier("anyitem", "cooked_shaurma"), COOKED_SHAURMA);
		Registry.register(Registry.ITEM, new Identifier("anyitem", "echpochmak"), ECHPOCHMAK);
		Registry.register(Registry.ITEM, new Identifier("anyitem", "onion"), ONION);

		Registry.register(Registry.BLOCK, new Identifier("anyitem", "cryptonblock"), CRYPTONBLOCK);
		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonblock"), new BlockItem(CRYPTONBLOCK, new Item.Settings().group(AnyItemsMod.AI_GENERAL).group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.BLOCK, new Identifier("anyitem", "crypton_ore"), CRYPTON_ORE);
		Registry.register(Registry.ITEM, new Identifier("anyitem", "crypton_ore"), new BlockItem(CRYPTON_ORE, new Item.Settings().group(AnyItemsMod.AI_GENERAL).group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonsprayingsword"), new CryptonSprayingSword(new ToolMaterialCryptonSpraying()));
		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonsword"), new CryptonSword(new ToolMaterialCrypton()));

		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonsprayingpickaxe"), new CryptonSprayingPickaxe(new ToolMaterialCryptonSpraying()));
		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonpickaxe"), new CryptonPickaxe(new ToolMaterialCrypton()));

		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonsprayingaxe"), new CryptonSprayingAxe(new ToolMaterialCryptonSpraying()));
		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonaxe"), new CryptonAxe(new ToolMaterialCrypton()));

		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonsprayingshovel"), new CryptonSprayingShovel(new ToolMaterialCryptonSpraying()));
		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonshovel"), new CryptonShovel(new ToolMaterialCrypton()));

		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonsprayinghoe"), new CryptonSprayingHoe(new ToolMaterialCryptonSpraying()));
		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonhoe"), new CryptonHoe(new ToolMaterialCrypton()));

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("anyitem", "crypton_ore_otherworld"), CRYPTON_ORE_OTHERWORLD);
	}
}
