package net.sfedunet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.sfedunet.armor.*;
import net.sfedunet.instruments.*;

public class AnyItemsMod implements ModInitializer {
	public static final ItemGroup AI_GENERAL = FabricItemGroupBuilder.build(new Identifier("anyitem:general"), ()->new ItemStack(AnyItemsMod.CRYPTON_BLOCK));
	public static final Item CRYPTON_DUST = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item CRYPTONEZERIT = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item SOUL_INGOT = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item FRIEND_SOUL = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item HOSTILE_SOUL = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item FRIEND_SOUL_SHARD = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item HOSTILE_SOUL_SHARD = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item ECHSEROCK_PIECE = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item ECHSEROCK_CHUNK = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item MILITANT_SOUL = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item MILITANT_SOUL_SHARD = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item PACIFIED_SOUL = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item PACIFIED_SOUL_SHARD = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item RULER_SOUL_INGOT = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item DRAGON_INGOT = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));;
	public static final Item ASHES = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item DRAGON_SCALES = new Item (new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item DRAGON_FIRE = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL));
	public static final Item SHAURMA = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL).food(new FoodComponent.Builder().saturationModifier(7.5f).hunger(9).statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*20),0.2f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*10),0.21f).build()));
    public static final Item COOKED_SHAURMA = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL).food(new FoodComponent.Builder().saturationModifier(15f).hunger(18).statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*15),0.09f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*30),0.1f).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 20*30,5),0.05f).build()));
	public static final Item ECHPOCHMAK = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL).food(new FoodComponent.Builder().saturationModifier(10f).hunger(14).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20*5),0.5f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5),0.5f).build()));
	public static final Item ONION = new Item(new FabricItemSettings().group(AnyItemsMod.AI_GENERAL).food(new FoodComponent.Builder().saturationModifier(2f).hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*10),1f).build()));
	public static final Block CRYPTON_BLOCK = new Block(FabricBlockSettings.copy(Blocks.OBSIDIAN).sounds(BlockSoundGroup.BONE));
	public static final Block CRYPTON_ORE = new Block(FabricBlockSettings.copy(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.STONE));
	public static final Block ECHSEROCK = new Block(FabricBlockSettings.copy(AnyItemsMod.CRYPTON_ORE).strength(10f));
	public static final Block DRAGON_INGOT_BLOCK = new Block(FabricBlockSettings.copy(Blocks.DIAMOND_BLOCK));
	public static final Block ASHES_BLOCK = new Block(FabricBlockSettings.copy(Blocks.CLAY));
	public static final ArmorMaterial CRYPTON_ARMOR = new CryptonArmorMaterial();

	public static final ToolMaterialCrypton CRYPTON_TOOLS = new ToolMaterialCrypton();
	public static final ToolMaterialCryptonSpraying CRYPTON_TOOLS_SPRAYING = new ToolMaterialCryptonSpraying();
	public static final ConfiguredFeature<?, ?> CRYPTON_ORE_OTHERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, AnyItemsMod.CRYPTON_ORE.getDefaultState(), 5)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0,20,40))).spreadHorizontally().repeat(10);

	@Override
	public void onInitialize()
	{
		Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_dust"), CRYPTON_DUST);
		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonezerit"), CRYPTONEZERIT);

		Registry.register(Registry.ITEM, new Identifier("anyitem:hostile_soul_shard"), HOSTILE_SOUL_SHARD);
		Registry.register(Registry.ITEM, new Identifier("anyitem:hostile_soul"), HOSTILE_SOUL);

		Registry.register(Registry.ITEM, new Identifier("anyitem:friend_soul_shard"), FRIEND_SOUL_SHARD);
		Registry.register(Registry.ITEM, new Identifier("anyitem:friend_soul"), FRIEND_SOUL);

		Registry.register(Registry.ITEM, new Identifier("anyitem:soul_ingot"), SOUL_INGOT);

		Registry.register(Registry.ITEM, new Identifier("anyitem:echserock_piece"), ECHSEROCK_PIECE);
		Registry.register(Registry.ITEM, new Identifier("anyitem:echserock_chunk"), ECHSEROCK_CHUNK);
		Registry.register(Registry.ITEM, new Identifier("anyitem:militant_soul"), MILITANT_SOUL);
		Registry.register(Registry.ITEM, new Identifier("anyitem:militant_soul_shard"), MILITANT_SOUL_SHARD);
		Registry.register(Registry.ITEM, new Identifier("anyitem:pacified_soul"), PACIFIED_SOUL);
		Registry.register(Registry.ITEM, new Identifier("anyitem:pacified_soul_shard"), PACIFIED_SOUL_SHARD);
		Registry.register(Registry.ITEM, new Identifier("anyitem:ruler_soul_ingot"), RULER_SOUL_INGOT);
		Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_ingot"), DRAGON_INGOT);
		Registry.register(Registry.ITEM, new Identifier("anyitem:ashes"), ASHES);
		Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_scales"),DRAGON_SCALES);
		Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_fire"), DRAGON_FIRE);

		Registry.register(Registry.BLOCK, new Identifier("anyitem:echserock"), ECHSEROCK);
		Registry.register(Registry.ITEM, new Identifier("anyitem:echserock"), new BlockItem(ECHSEROCK, new FabricItemSettings().group(AnyItemsMod.AI_GENERAL)));
		Registry.register(Registry.BLOCK, new Identifier("anyitem:dragon_ingot_block"), DRAGON_INGOT_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_ingot_block"), new BlockItem(DRAGON_INGOT_BLOCK, new FabricItemSettings().group(AnyItemsMod.AI_GENERAL)));
		Registry.register(Registry.BLOCK, new Identifier("anyitem:ashes_block"), ASHES_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("anyitem:ashes_block"), new BlockItem(ASHES_BLOCK, new FabricItemSettings().group(AnyItemsMod.AI_GENERAL)));

		Registry.register(Registry.ITEM, new Identifier("anyitem:onion"), ONION);
		Registry.register(Registry.ITEM, new Identifier("anyitem:shaurma"), SHAURMA);
		Registry.register(Registry.ITEM, new Identifier("anyitem:cooked_shaurma"), COOKED_SHAURMA);
		Registry.register(Registry.ITEM, new Identifier("anyitem:echpochmak"), ECHPOCHMAK);

		Registry.register(Registry.BLOCK, new Identifier("anyitem:crypton_block"), CRYPTON_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_block"), new BlockItem(CRYPTON_BLOCK, new FabricItemSettings().group(AnyItemsMod.AI_GENERAL)));

		Registry.register(Registry.BLOCK, new Identifier("anyitem:crypton_ore"), CRYPTON_ORE);
		Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_ore"), new BlockItem(CRYPTON_ORE, new FabricItemSettings().group(AnyItemsMod.AI_GENERAL)));

		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsprayingsword"), new CryptonSprayingSword(CRYPTON_TOOLS_SPRAYING));
		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsword"), new CryptonSword(CRYPTON_TOOLS));

        Registry.register(Registry.ITEM, new Identifier("anyitem:scythe"), new Scythe(new ScytheMaterial()));

		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsprayingpickaxe"), new CryptonSprayingPickaxe(CRYPTON_TOOLS_SPRAYING));
		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonpickaxe"), new CryptonPickaxe(CRYPTON_TOOLS));

		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsprayingaxe"), new CryptonSprayingAxe(CRYPTON_TOOLS_SPRAYING));
		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonaxe"), new CryptonAxe(CRYPTON_TOOLS));

		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsprayingshovel"), new CryptonSprayingShovel(CRYPTON_TOOLS_SPRAYING));
		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonshovel"), new CryptonShovel(CRYPTON_TOOLS));

		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsprayinghoe"), new CryptonSprayingHoe(CRYPTON_TOOLS_SPRAYING));
		Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonhoe"), new CryptonHoe(CRYPTON_TOOLS));

		Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_helmet"), new BaseArmor(CRYPTON_ARMOR, EquipmentSlot.HEAD));
		Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_chestplate"), new BaseArmor(CRYPTON_ARMOR, EquipmentSlot.CHEST));
		Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_leggings"), new BaseArmor(CRYPTON_ARMOR, EquipmentSlot.LEGS));
		Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_boots"), new BaseArmor(CRYPTON_ARMOR, EquipmentSlot.FEET));


		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("anyitem:crypton_ore_otherworld"), CRYPTON_ORE_OTHERWORLD);

	}
}
