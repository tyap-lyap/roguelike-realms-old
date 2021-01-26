package net.sfedunet.render.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.util.Identifier;
import net.sfedunet.entity.mob.InferiorDragonEntity;
import net.sfedunet.render.entity.model.InferiorDragonEntityModel;

@Environment(EnvType.CLIENT)
public class InferiorDragonEntityRenderer extends BipedEntityRenderer<InferiorDragonEntity, InferiorDragonEntityModel> {
    public InferiorDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new InferiorDragonEntityModel(0.0F, false), 0.5f);
    }

    private static final Identifier TEXTURE = new Identifier("textures/entity/zombie.png");
    
    @Override
   public Identifier getTexture(InferiorDragonEntity entity) {
      return TEXTURE;
   }
}