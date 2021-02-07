package net.sfedunet.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Identifier;
import net.sfedunet.entity.DragonCrossbowmanEntity;
import net.sfedunet.entity.model.DragonCrossbowmanEntityModel;

@Environment(EnvType.CLIENT)
public class DragonCrossbowmanEntityRenderer extends BipedEntityRenderer<DragonCrossbowmanEntity, DragonCrossbowmanEntityModel> {
    public DragonCrossbowmanEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonCrossbowmanEntityModel(0.0F, false), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel<>(0.5f), new BipedEntityModel<>(1.0f)));
    }

    private static final Identifier TEXTURE = new Identifier("anyitem:textures/entity/dragon_crossbowman.png");
    
    @Override
   public Identifier getTexture(DragonCrossbowmanEntity entity) {
      return TEXTURE;
   }
}