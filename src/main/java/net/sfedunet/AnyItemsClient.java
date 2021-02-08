package net.sfedunet;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.sfedunet.block.AnyItemsBlocks;
import net.sfedunet.entity.AnyItemsEntities;
import net.sfedunet.entity.renderer.ArmoredDragonEntityRenderer;
import net.sfedunet.entity.renderer.DragonBowmanEntityRenderer;
import net.sfedunet.entity.renderer.DragonCrossbowmanEntityRenderer;
import net.sfedunet.entity.renderer.DragonSwordmanEntityRenderer;
import net.sfedunet.entity.renderer.DragonWarlordEntityRenderer;
import net.sfedunet.entity.renderer.InferiorDragonEntityRenderer;
import net.sfedunet.entity.renderer.SpittingDragonEntityRenderer;
import net.sfedunet.entity.renderer.SupremeDragonEntityRenderer;

public class AnyItemsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(AnyItemsEntities.ARMORED_DRAGON, (dispatcher, context) -> new ArmoredDragonEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(AnyItemsEntities.DRAGON_BOWMAN, (dispatcher, context) -> new DragonBowmanEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(AnyItemsEntities.DRAGON_CROSSBOWMAN, (dispatcher, context) -> new DragonCrossbowmanEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(AnyItemsEntities.DRAGON_SWORDMAN, (dispatcher, context) -> new DragonSwordmanEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(AnyItemsEntities.DRAGON_WARLORD, (dispatcher, context) -> new DragonWarlordEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(AnyItemsEntities.INFERIOR_DRAGON, (dispatcher, context) -> new InferiorDragonEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(AnyItemsEntities.SPITTING_DRAGON, (dispatcher, context) -> new SpittingDragonEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(AnyItemsEntities.SUPREME_DRAGON, (dispatcher, context) -> new SupremeDragonEntityRenderer(dispatcher));

        BlockRenderLayerMap.INSTANCE.putBlock(AnyItemsBlocks.DRACONIC_SHADOW_PORTAL, RenderLayer.getTranslucent());
    }
}
