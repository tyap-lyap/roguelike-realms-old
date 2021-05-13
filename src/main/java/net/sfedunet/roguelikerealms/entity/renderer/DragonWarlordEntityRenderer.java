package net.sfedunet.roguelikerealms.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Identifier;
import net.sfedunet.roguelikerealms.entity.DragonWarlordEntity;
import net.sfedunet.roguelikerealms.entity.model.DragonWarlordEntityModel;

@Environment(EnvType.CLIENT)
public class DragonWarlordEntityRenderer extends BipedEntityRenderer<DragonWarlordEntity, DragonWarlordEntityModel<DragonWarlordEntity>> {
    public DragonWarlordEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonWarlordEntityModel<>(), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel<>(0.5f), new BipedEntityModel<>(1.0f)));
    }

    private static final Identifier TEXTURE = new Identifier("anyitem:textures/entity/dragon_warlord.png");

    @Override
    public Identifier getTexture(DragonWarlordEntity entity) {
        return TEXTURE;
    }
}