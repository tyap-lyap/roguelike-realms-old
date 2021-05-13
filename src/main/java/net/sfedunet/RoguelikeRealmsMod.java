package net.sfedunet;

import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.block.RoguelikeRealmsBlocks;
import net.sfedunet.entity.RoguelikeRealmsEntities;
import net.sfedunet.event.RoguelikeRealmsEvents;
import net.sfedunet.item.RoguelikeRealmsItems;
import net.sfedunet.world.features.RoguelikeRealmsConfiguredFeatures;
import net.sfedunet.world.features.trees.RoguelikeRealmsTrees;
import net.sfedunet.world.structure.RoguelikeRealmsStructures;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoguelikeRealmsMod implements ModInitializer {

	public static final Identifier ID_SPITTING = new Identifier("roguelikerealms:spitting_pew");
	public static SoundEvent SPITTING_PEW = new SoundEvent(ID_SPITTING);

	public static final String MODID = "roguelikerealms";

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void onInitialize()
	{
		Registry.register(Registry.SOUND_EVENT, RoguelikeRealmsMod.ID_SPITTING, SPITTING_PEW);

		RoguelikeRealmsConfiguredFeatures.register();
		RoguelikeRealmsBlocks.register();
		RoguelikeRealmsItems.register();
		RoguelikeRealmsEntities.register();
		RoguelikeRealmsEvents.register();
		RoguelikeRealmsTrees.registerTrees();
		RoguelikeRealmsStructures.registerStructures();

	}
}
