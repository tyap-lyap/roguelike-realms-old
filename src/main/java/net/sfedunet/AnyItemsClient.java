package net.sfedunet;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.sfedunet.entity.AnyItemsEntities;
import net.sfedunet.entity.renderer.InferiorDragonEntityRenderer;

public class AnyItemsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(AnyItemsEntities.INFERIOR_DRAGON, (dispatcher, context) -> new InferiorDragonEntityRenderer(dispatcher));
    }
}
