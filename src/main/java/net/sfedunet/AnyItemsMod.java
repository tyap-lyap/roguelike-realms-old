package net.sfedunet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.sound.SoundEvent;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.sfedunet.block.AnyItemsBlocks;
import net.sfedunet.entity.AnyItemsEntities;
import net.sfedunet.item.AnyItemsItems;
import net.sfedunet.world.features.AnyItemsConfiguredFeatures;
import net.sfedunet.world.features.trees.AnyTrees;
import net.sfedunet.world.structure.AnyItemsStructures;
import net.sfedunet.world.structure.DraconicBoneGenerator;
import net.sfedunet.world.features.DraconicBoneFeature;
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
		AnyItemsStructures.registerStructures();

	}
}
