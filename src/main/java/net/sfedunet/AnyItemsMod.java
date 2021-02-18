package net.sfedunet;

import net.fabricmc.api.ModInitializer;
import net.sfedunet.block.AnyItemsBlocks;
import net.sfedunet.entity.AnyItemsEntities;
import net.sfedunet.item.AnyItemsItems;
import net.sfedunet.world.features.AnyItemsConfiguredFeatures;

public class AnyItemsMod implements ModInitializer {
	public static final String MODID = "anyitem";

	@Override
	public void onInitialize()
	{
		AnyItemsConfiguredFeatures.register();
		AnyItemsBlocks.register();
		AnyItemsItems.register();
		AnyItemsEntities.register();
	}
}
