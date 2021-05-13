package net.sfedunet.mixin.client;

import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.sfedunet.item.base.BaseArmorItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(ArmorFeatureRenderer.class)
public class ArmorFeatureRendererMixin {


    @Shadow @Final private static Map<String, Identifier> ARMOR_TEXTURE_CACHE;

    //штобы брал текстуру из папки roguelikerealms, а не minecraft
    @Inject(method = "getArmorTexture", at = @At("HEAD"), cancellable = true)
    void getArmorTexture(ArmorItem armorItem, boolean bl, String string, CallbackInfoReturnable<Identifier> cir){

        if(armorItem instanceof BaseArmorItem){
            String texturePath = "roguelikerealms:textures/models/armor/" + armorItem.getMaterial().getName() + "_layer_" + (bl ? 2 : 1) + (string == null ? "" : "_" + string) + ".png";
            cir.setReturnValue(ARMOR_TEXTURE_CACHE.computeIfAbsent(texturePath, Identifier::new));
        }
    }


}
