package net.sfedunet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
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
		AnyItemsConfiguredFeatures.register();
		AnyItemsBlocks.register();
		AnyItemsItems.register();
		AnyItemsTools.register();
		AnyItemsArmor.register();
	}
}
