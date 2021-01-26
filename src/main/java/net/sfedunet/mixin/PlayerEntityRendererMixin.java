package net.sfedunet.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.UseAction;
import net.sfedunet.item.tools.AnyItemsTools;
import net.sfedunet.item.tools.RulerWill;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {

    private static BipedEntityModel.ArmPose getArmPose(final AbstractClientPlayerEntity abstractClientPlayerEntity, final Hand hand) {
        final ItemStack itemStack = abstractClientPlayerEntity.getStackInHand(hand);

        if (itemStack.isEmpty()) {
            return BipedEntityModel.ArmPose.EMPTY;
        }
        if (abstractClientPlayerEntity.getActiveHand() == hand && abstractClientPlayerEntity.getItemUseTimeLeft() > 0) {
            final UseAction useAction = itemStack.getUseAction();
            if (useAction == UseAction.BLOCK) {
                return BipedEntityModel.ArmPose.BLOCK;
            }
            if (useAction == UseAction.BOW) {
                return BipedEntityModel.ArmPose.BOW_AND_ARROW;
            }
            if (useAction == UseAction.SPEAR) {
                return BipedEntityModel.ArmPose.THROW_SPEAR;
            }
            if (useAction == UseAction.CROSSBOW && hand == abstractClientPlayerEntity.getActiveHand()) {
                return BipedEntityModel.ArmPose.CROSSBOW_CHARGE;
            }
        } else if (!abstractClientPlayerEntity.handSwinging && itemStack.getItem() == AnyItemsTools.RULER_WILL && RulerWill.isCharged(itemStack) || !abstractClientPlayerEntity.handSwinging && itemStack.getItem() == Items.CROSSBOW && CrossbowItem.isCharged(itemStack)) {
            return BipedEntityModel.ArmPose.CROSSBOW_HOLD;
        }
        return BipedEntityModel.ArmPose.ITEM;
    }
}