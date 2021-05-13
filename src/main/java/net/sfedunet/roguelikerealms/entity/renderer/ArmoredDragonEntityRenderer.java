package net.sfedunet.roguelikerealms.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Identifier;
import net.sfedunet.roguelikerealms.entity.ArmoredDragonEntity;
import net.sfedunet.roguelikerealms.entity.model.ArmoredDragonEntityModel;

@Environment(EnvType.CLIENT)
public class ArmoredDragonEntityRenderer extends BipedEntityRenderer<ArmoredDragonEntity, ArmoredDragonEntityModel<ArmoredDragonEntity>> {
    public ArmoredDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new ArmoredDragonEntityModel<>(), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel<>(0.5f), new BipedEntityModel<>(1.0f)));
    }

    private static final Identifier TEXTURE = new Identifier("anyitem:textures/entity/armored_dragon.png");

    @Override
    public Identifier getTexture(ArmoredDragonEntity entity) {
        return TEXTURE;
    }
}