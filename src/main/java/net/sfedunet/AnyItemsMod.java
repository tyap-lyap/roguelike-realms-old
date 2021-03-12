package net.sfedunet;

import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.block.AnyItemsBlocks;
import net.sfedunet.entity.AnyItemsEntities;
import net.sfedunet.item.AnyItemsItems;
import net.sfedunet.world.features.AnyItemsConfiguredFeatures;
import net.sfedunet.world.features.trees.AnyTrees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnyItemsMod implements ModInitializer {

	public static final Identifier ID_SPITTING = new Identifier("anyitem:spitting_pew");
	public static SoundEvent SPITTING_PEW = new SoundEvent(ID_SPITTING);

	public static final String MODID = "anyitem";

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void onInitialize()
	{
		Registry.register(Registry.SOUND_EVENT, AnyItemsMod.ID_SPITTING, SPITTING_PEW);

		AnyItemsConfiguredFeatures.register();
		AnyItemsBlocks.register();
		AnyItemsItems.register();
		AnyItemsEntities.register();
		AnyTrees.registerTrees();

	}
}
