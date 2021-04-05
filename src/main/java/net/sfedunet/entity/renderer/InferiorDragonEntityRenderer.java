package net.sfedunet.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Identifier;
import net.sfedunet.entity.InferiorDragonEntity;
import net.sfedunet.entity.model.InferiorDragonEntityModel;

@Environment(EnvType.CLIENT)
public class InferiorDragonEntityRenderer extends BipedEntityRenderer<InferiorDragonEntity, InferiorDragonEntityModel<InferiorDragonEntity>> {
    public InferiorDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new InferiorDragonEntityModel<>(), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel<>(0.5f), new BipedEntityModel<>(1.0f)));
    }

    private static final Identifier TEXTURE = new Identifier("anyitem:textures/entity/inferior_dragon.png");

    @Override
    public Identifier getTexture(InferiorDragonEntity entity) {
        return TEXTURE;
    }
}