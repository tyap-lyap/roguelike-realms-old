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
import net.minecraft.util.registry.Registry;
import net.sfedunet.instruments.*;

public class AnyItemsMod implements ModInitializer {
	public static final ItemGroup AI_GENERAL = FabricItemGroupBuilder.build(
			new Identifier("anyitem","general"),
			()->new ItemStack(Items.BEDROCK));
	public static final Item ECHPOCHMAK = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().saturationModifier(10f).hunger(14).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20*5),0.5f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5),0.5f).build()));
	public static final Item ONION = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().saturationModifier(2f).hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*10),1f).build()));
	public static final Block CRYPTONBLOCK = new Block(FabricBlockSettings.copy(Blocks.OBSIDIAN).sounds(BlockSoundGroup.BONE));
	@Override
	public void onInitialize()
	{
		Registry.register(Registry.ITEM, new Identifier("anyitem", "echpochmak"), ECHPOCHMAK);
		Registry.register(Registry.ITEM, new Identifier("anyitem", "onion"), ONION);

		Registry.register(Registry.BLOCK, new Identifier("anyitem", "cryptonblock"), CRYPTONBLOCK);
		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonblock"), new BlockItem(CRYPTONBLOCK, new Item.Settings().group(AnyItemsMod.AI_GENERAL)));

		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonsprayingpickaxe"), new CryptonSprayingPickaxe(new ToolMaterialCryptonSpraying()));
		Registry.register(Registry.ITEM, new Identifier("anyitem", "cryptonpickaxe"), new CryptonPickaxe(new ToolMaterialCrypton()));
	}
}
