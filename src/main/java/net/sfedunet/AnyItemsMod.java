package net.sfedunet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.FabricLoader;
import net.sfedunet.block.AnyItemsBlocks;
import net.sfedunet.entity.AnyItemsEntities;
import net.sfedunet.integration.botania.BotaniaIntegration;
import net.sfedunet.item.AnyItemsItems;
import net.sfedunet.world.features.AnyItemsConfiguredFeatures;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnyItemsMod implements ModInitializer {

	public static final String MODID = "anyitem";

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void onInitialize()
	{
		AnyItemsConfiguredFeatures.register();
		AnyItemsBlocks.register();
		AnyItemsItems.register();
		AnyItemsEntities.register();

		if(FabricLoader.INSTANCE.isModLoaded("botania")){
			BotaniaIntegration.register();
			LOGGER.info("[Any Items Mod] Botania integration is enabled");
		}else {
			LOGGER.info("[Any Items Mod] Botania integration is disabled");
		}
	}
}
