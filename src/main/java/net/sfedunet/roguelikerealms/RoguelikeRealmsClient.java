package net.sfedunet.roguelikerealms;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.sfedunet.roguelikerealms.block.RoguelikeRealmsBlocks;
import net.sfedunet.roguelikerealms.entity.RoguelikeRealmsEntities;
import net.sfedunet.roguelikerealms.entity.renderer.ArmoredDragonEntityRenderer;
import net.sfedunet.roguelikerealms.entity.renderer.DragonBowmanEntityRenderer;
import net.sfedunet.roguelikerealms.entity.renderer.DragonCrossbowmanEntityRenderer;
import net.sfedunet.roguelikerealms.entity.renderer.DragonSwordmanEntityRenderer;
import net.sfedunet.roguelikerealms.entity.renderer.DragonWarlordEntityRenderer;
import net.sfedunet.roguelikerealms.entity.renderer.InferiorDragonEntityRenderer;
import net.sfedunet.roguelikerealms.entity.renderer.CasterDragonEntityRenderer;
import net.sfedunet.roguelikerealms.entity.renderer.SupremeDragonEntityRenderer;
import net.sfedunet.roguelikerealms.item.tools.RoguelikeRealmsTools;

public class RoguelikeRealmsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(RoguelikeRealmsEntities.ARMORED_DRAGON, (dispatcher, context) -> new ArmoredDragonEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(RoguelikeRealmsEntities.DRAGON_BOWMAN, (dispatcher, context) -> new DragonBowmanEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(RoguelikeRealmsEntities.DRAGON_CROSSBOWMAN, (dispatcher, context) -> new DragonCrossbowmanEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(RoguelikeRealmsEntities.DRAGON_SWORDMAN, (dispatcher, context) -> new DragonSwordmanEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(RoguelikeRealmsEntities.DRAGON_WARLORD, (dispatcher, context) -> new DragonWarlordEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(RoguelikeRealmsEntities.INFERIOR_DRAGON, (dispatcher, context) -> new InferiorDragonEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(RoguelikeRealmsEntities.CASTER_DRAGON, (dispatcher, context) -> new CasterDragonEntityRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(RoguelikeRealmsEntities.SUPREME_DRAGON, (dispatcher, context) -> new SupremeDragonEntityRenderer(dispatcher));

        BlockRenderLayerMap.INSTANCE.putBlock(RoguelikeRealmsBlocks.DRACONIC_SHADOW_PORTAL, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(RoguelikeRealmsBlocks.DRAGON_GRAPE_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RoguelikeRealmsBlocks.DRAGON_GRAPE_VINES_TIP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RoguelikeRealmsBlocks.GRAPED_DRAGON_GRAPE_VINES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RoguelikeRealmsBlocks.DRAGON_WILLOW_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RoguelikeRealmsBlocks.DRAGON_WILLOW_VINES_TIP, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RoguelikeRealmsBlocks.EMERALD_PEDESTAL, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(RoguelikeRealmsBlocks.DRAGON_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RoguelikeRealmsBlocks.DRAGON_DAISY, RenderLayer.getCutout());


        FabricModelPredicateProviderRegistry.register(RoguelikeRealmsTools.RULER_WILL, new Identifier("pull"), ModelPredicateProviderRegistry.get(Items.CROSSBOW, new Identifier("pull")));
        FabricModelPredicateProviderRegistry.register(RoguelikeRealmsTools.RULER_WILL, new Identifier("pulling"), ModelPredicateProviderRegistry.get(Items.CROSSBOW, new Identifier("pulling")));
        FabricModelPredicateProviderRegistry.register(RoguelikeRealmsTools.RULER_WILL, new Identifier("charged"), ModelPredicateProviderRegistry.get(Items.CROSSBOW, new Identifier("charged")));
    }
}
