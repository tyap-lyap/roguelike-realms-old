package net.sfedunet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.sfedunet.armor.*;
import net.sfedunet.blocks.AnyItemsBlocks;
import net.sfedunet.items.AnyItemsItems;
import net.sfedunet.tools.*;
import net.sfedunet.world.features.AnyItemsConfiguredFeatures;

public class AnyItemsMod implements ModInitializer {
	public static final ItemGroup GENERAL = FabricItemGroupBuilder.build(new Identifier("anyitem:general"), ()->new ItemStack(AnyItemsBlocks.CRYPTON_BLOCK));


	@Override
	public void onInitialize()
	{
		CustomPortalApiRegistry.addPortal(Blocks.EMERALD_BLOCK, Blocks.FIRE, new Identifier("anyitem:draconic_shadow"), DyeColor.ORANGE.getMaterialColor().color);
		AnyItemsConfiguredFeatures.register();
		AnyItemsBlocks.register();
		AnyItemsItems.register();
		AnyItemsTools.register();
		AnyItemsArmor.register();
	}
}
