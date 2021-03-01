package net.sfedunet;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
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
import net.sfedunet.item.tools.AnyItemsTools;

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

        BlockRenderLayerMap.INSTANCE.putBlock(AnyItemsBlocks.DRAGON_GRAPE_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AnyItemsBlocks.DRAGON_GRAPE_VINES_TIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AnyItemsBlocks.GRAPED_DRAGON_GRAPE_VINES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(AnyItemsBlocks.DRAGON_WILLOW_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AnyItemsBlocks.DRAGON_WILLOW_VINES_TIP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(AnyItemsBlocks.EMERALD_PEDESTAL, RenderLayer.getCutout());


        FabricModelPredicateProviderRegistry.register(AnyItemsTools.RULER_WILL, new Identifier("pull"), ModelPredicateProviderRegistry.get(Items.CROSSBOW, new Identifier("pull")));
        FabricModelPredicateProviderRegistry.register(AnyItemsTools.RULER_WILL, new Identifier("pulling"), ModelPredicateProviderRegistry.get(Items.CROSSBOW, new Identifier("pulling")));
        FabricModelPredicateProviderRegistry.register(AnyItemsTools.RULER_WILL, new Identifier("charged"), ModelPredicateProviderRegistry.get(Items.CROSSBOW, new Identifier("charged")));
    }
}
