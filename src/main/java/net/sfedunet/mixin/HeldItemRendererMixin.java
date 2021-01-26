package net.sfedunet.mixin;

import com.google.common.base.MoreObjects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.map.MapState;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Matrix4f;
import net.sfedunet.item.tools.AnyItemsTools;
import net.sfedunet.item.tools.RulerWill;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(HeldItemRenderer.class)
public class HeldItemRendererMixin {

    private static final RenderLayer MAP_BACKGROUND = RenderLayer.getText(new Identifier("textures/map/map_background.png"));
    private static final RenderLayer MAP_BACKGROUND_CHECKERBOARD = RenderLayer.getText(new Identifier("textures/map/map_background_checkerboard.png"));
    public final MinecraftClient client;
    public ItemStack mainHand;
    public ItemStack offHand;
    public float equipProgressMainHand;
    public float prevEquipProgressMainHand;
    public float equipProgressOffHand;
    public float prevEquipProgressOffHand;
    private final EntityRenderDispatcher renderManager;
    private final ItemRenderer itemRenderer;

    public HeldItemRendererMixin(MinecraftClient client) {

        this.mainHand = ItemStack.EMPTY;
        this.offHand = ItemStack.EMPTY;
        this.client = client;
        this.renderManager = client.getEntityRenderDispatcher();
        this.itemRenderer = client.getItemRenderer();
    }

    public void applyEatOrDrinkTransformation(MatrixStack matrices, float tickDelta, Arm arm, ItemStack stack) {
        float f = (float) this.client.player.getItemUseTimeLeft() - tickDelta + 1.0F;
        float g = f / (float) stack.getMaxUseTime();
        float i;
        if (g < 0.8F) {
            i = MathHelper.abs(MathHelper.cos(f / 4.0F * 3.1415927F) * 0.1F);
            matrices.translate(0.0D, (double) i, 0.0D);
        }

        i = 1.0F - (float) Math.pow((double) g, 27.0D);
        int j = arm == Arm.RIGHT ? 1 : -1;
        matrices.translate((double) (i * 0.6F * (float) j), (double) (i * -0.5F), (double) (i * 0.0F));
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((float) j * i * 90.0F));
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(i * 10.0F));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion((float) j * i * 30.0F));
    }

    public void applyEquipOffset(MatrixStack matrices, Arm arm, float equipProgress) {
        int i = arm == Arm.RIGHT ? 1 : -1;
        matrices.translate((double) ((float) i * 0.56F), (double) (-0.52F + equipProgress * -0.6F), -0.7200000286102295D);
    }

    public void applySwingOffset(MatrixStack matrices, Arm arm, float swingProgress) {
        int i = arm == Arm.RIGHT ? 1 : -1;
        float f = MathHelper.sin(swingProgress * swingProgress * 3.1415927F);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((float) i * (45.0F + f * -20.0F)));
        float g = MathHelper.sin(MathHelper.sqrt(swingProgress) * 3.1415927F);
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion((float) i * g * -20.0F));
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(g * -80.0F));
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((float) i * -45.0F));
    }

    public void renderMapInOneHand(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, float equipProgress, Arm arm, float swingProgress, ItemStack stack) {
        float f = arm == Arm.RIGHT ? 1.0F : -1.0F;
        matrices.translate((double) (f * 0.125F), -0.125D, 0.0D);
        if (!this.client.player.isInvisible()) {
            matrices.push();
            matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(f * 10.0F));
            this.renderArmHoldingItem(matrices, vertexConsumers, light, equipProgress, swingProgress, arm);
            matrices.pop();
        }

        matrices.push();
        matrices.translate((double) (f * 0.51F), (double) (-0.08F + equipProgress * -1.2F), -0.75D);
        float g = MathHelper.sqrt(swingProgress);
        float h = MathHelper.sin(g * 3.1415927F);
        float i = -0.5F * h;
        float j = 0.4F * MathHelper.sin(g * 6.2831855F);
        float k = -0.3F * MathHelper.sin(swingProgress * 3.1415927F);
        matrices.translate((double) (f * i), (double) (j - 0.3F * h), (double) k);
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(h * -45.0F));
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(f * h * -30.0F));
        this.renderFirstPersonMap(matrices, vertexConsumers, light, stack);
        matrices.pop();
    }

    public float getMapAngle(float tickDelta) {
        float f = 1.0F - tickDelta / 45.0F + 0.1F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = -MathHelper.cos(f * 3.1415927F) * 0.5F + 0.5F;
        return f;
    }

    public void renderArm(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, Arm arm) {
        this.client.getTextureManager().bindTexture(this.client.player.getSkinTexture());
        PlayerEntityRenderer playerEntityRenderer = (PlayerEntityRenderer) this.renderManager.getRenderer(this.client.player);
        matrices.push();
        float f = arm == Arm.RIGHT ? 1.0F : -1.0F;
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(92.0F));
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(45.0F));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(f * -41.0F));
        matrices.translate((double) (f * 0.3F), -1.100000023841858D, 0.44999998807907104D);
        if (arm == Arm.RIGHT) {
            playerEntityRenderer.renderRightArm(matrices, vertexConsumers, light, this.client.player);
        } else {
            playerEntityRenderer.renderLeftArm(matrices, vertexConsumers, light, this.client.player);
        }

        matrices.pop();
    }

    public void renderMapInBothHands(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, float pitch, float equipProgress, float swingProgress) {
        float f = MathHelper.sqrt(swingProgress);
        float g = -0.2F * MathHelper.sin(swingProgress * 3.1415927F);
        float h = -0.4F * MathHelper.sin(f * 3.1415927F);
        matrices.translate(0.0D, (double) (-g / 2.0F), (double) h);
        float i = this.getMapAngle(pitch);
        matrices.translate(0.0D, (double) (0.04F + equipProgress * -1.2F + i * -0.5F), -0.7200000286102295D);
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(i * -85.0F));
        if (!this.client.player.isInvisible()) {
            matrices.push();
            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(90.0F));
            this.renderArm(matrices, vertexConsumers, light, Arm.RIGHT);
            this.renderArm(matrices, vertexConsumers, light, Arm.LEFT);
            matrices.pop();
        }

        float j = MathHelper.sin(f * 3.1415927F);
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(j * 20.0F));
        matrices.scale(2.0F, 2.0F, 2.0F);
        this.renderFirstPersonMap(matrices, vertexConsumers, light, this.mainHand);
    }

    public void renderFirstPersonMap(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int swingProgress, ItemStack stack) {
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(180.0F));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(180.0F));
        matrices.scale(0.38F, 0.38F, 0.38F);
        matrices.translate(-0.5D, -0.5D, 0.0D);
        matrices.scale(0.0078125F, 0.0078125F, 0.0078125F);
        MapState mapState = FilledMapItem.getOrCreateMapState(stack, this.client.world);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(mapState == null ? MAP_BACKGROUND : MAP_BACKGROUND_CHECKERBOARD);
        Matrix4f matrix4f = matrices.peek().getModel();
        vertexConsumer.vertex(matrix4f, -7.0F, 135.0F, 0.0F).color(255, 255, 255, 255).texture(0.0F, 1.0F).light(swingProgress).next();
        vertexConsumer.vertex(matrix4f, 135.0F, 135.0F, 0.0F).color(255, 255, 255, 255).texture(1.0F, 1.0F).light(swingProgress).next();
        vertexConsumer.vertex(matrix4f, 135.0F, -7.0F, 0.0F).color(255, 255, 255, 255).texture(1.0F, 0.0F).light(swingProgress).next();
        vertexConsumer.vertex(matrix4f, -7.0F, -7.0F, 0.0F).color(255, 255, 255, 255).texture(0.0F, 0.0F).light(swingProgress).next();
        if (mapState != null) {
            this.client.gameRenderer.getMapRenderer().draw(matrices, vertexConsumers, mapState, false, swingProgress);
        }

    }

    public void renderArmHoldingItem(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, float equipProgress, float swingProgress, Arm arm) {
        boolean bl = arm != Arm.LEFT;
        float f = bl ? 1.0F : -1.0F;
        float g = MathHelper.sqrt(swingProgress);
        float h = -0.3F * MathHelper.sin(g * 3.1415927F);
        float i = 0.4F * MathHelper.sin(g * 6.2831855F);
        float j = -0.4F * MathHelper.sin(swingProgress * 3.1415927F);
        matrices.translate((double) (f * (h + 0.64000005F)), (double) (i + -0.6F + equipProgress * -0.6F), (double) (j + -0.71999997F));
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(f * 45.0F));
        float k = MathHelper.sin(swingProgress * swingProgress * 3.1415927F);
        float l = MathHelper.sin(g * 3.1415927F);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(f * l * 70.0F));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(f * k * -20.0F));
        AbstractClientPlayerEntity abstractClientPlayerEntity = this.client.player;
        this.client.getTextureManager().bindTexture(abstractClientPlayerEntity.getSkinTexture());
        matrices.translate((double) (f * -1.0F), 3.5999999046325684D, 3.5D);
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(f * 120.0F));
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(200.0F));
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(f * -135.0F));
        matrices.translate((double) (f * 5.6F), 0.0D, 0.0D);
        PlayerEntityRenderer playerEntityRenderer = (PlayerEntityRenderer) this.renderManager.getRenderer(abstractClientPlayerEntity);
        if (bl) {
            playerEntityRenderer.renderRightArm(matrices, vertexConsumers, light, abstractClientPlayerEntity);
        } else {
            playerEntityRenderer.renderLeftArm(matrices, vertexConsumers, light, abstractClientPlayerEntity);
        }

    }

    public void renderItem(LivingEntity entity, ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        if (!stack.isEmpty()) {
            this.itemRenderer.renderItem(entity, stack, renderMode, leftHanded, matrices, vertexConsumers, entity.world, light, OverlayTexture.DEFAULT_UV);
        }
    }


    public void renderItem(float tickDelta, MatrixStack matrices, VertexConsumerProvider.Immediate vertexConsumers, ClientPlayerEntity player, int light) {
        float f = player.getHandSwingProgress(tickDelta);
        Hand hand = (Hand)MoreObjects.firstNonNull(player.preferredHand, Hand.MAIN_HAND);
        float g = MathHelper.lerp(tickDelta, player.prevPitch, player.pitch);
        boolean bl = true;
        boolean bl2 = true;
        ItemStack itemStack3;
        if (player.isUsingItem()) {
            itemStack3 = player.getActiveItem();
            if (itemStack3.getItem() == Items.BOW || itemStack3.getItem() == Items.CROSSBOW || itemStack3.getItem() == AnyItemsTools.RULER_WILL)  {
                bl = player.getActiveHand() == Hand.MAIN_HAND;
                bl2 = !bl;
            }

            Hand hand2 = player.getActiveHand();
            if (hand2 == Hand.MAIN_HAND) {
                ItemStack itemStack2 = player.getOffHandStack();
                if (itemStack2.getItem() == Items.CROSSBOW && CrossbowItem.isCharged(itemStack2) || itemStack2.getItem() == AnyItemsTools.RULER_WILL && RulerWill.isCharged(itemStack2)) {
                    bl2 = false;
                }
            }
        } else {
            itemStack3 = player.getMainHandStack();
            ItemStack itemStack4 = player.getOffHandStack();
            if (itemStack3.getItem() == Items.CROSSBOW && CrossbowItem.isCharged(itemStack3) || itemStack3.getItem() == AnyItemsTools.RULER_WILL && RulerWill.isCharged(itemStack3)) {
                bl2 = !bl;
            }

            if (itemStack4.getItem() == Items.CROSSBOW && CrossbowItem.isCharged(itemStack4) || itemStack4.getItem() == AnyItemsTools.RULER_WILL && RulerWill.isCharged(itemStack4)) {
                bl = !itemStack3.isEmpty();
                bl2 = !bl;
            }
        }

        float h = MathHelper.lerp(tickDelta, player.lastRenderPitch, player.renderPitch);
        float i = MathHelper.lerp(tickDelta, player.lastRenderYaw, player.renderYaw);
        matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion((player.getPitch(tickDelta) - h) * 0.1F));
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((player.getYaw(tickDelta) - i) * 0.1F));
        float m;
        float l;
        if (bl) {
            l = hand == Hand.MAIN_HAND ? f : 0.0F;
            m = 1.0F - MathHelper.lerp(tickDelta, this.prevEquipProgressMainHand, this.equipProgressMainHand);
            this.renderFirstPersonItem(player, tickDelta, g, Hand.MAIN_HAND, l, this.mainHand, m, matrices, vertexConsumers, light);
        }

        if (bl2) {
            l = hand == Hand.OFF_HAND ? f : 0.0F;
            m = 1.0F - MathHelper.lerp(tickDelta, this.prevEquipProgressOffHand, this.equipProgressOffHand);
            this.renderFirstPersonItem(player, tickDelta, g, Hand.OFF_HAND, l, this.offHand, m, matrices, vertexConsumers, light);
        }

        vertexConsumers.draw();
    }

    private void renderFirstPersonItem(AbstractClientPlayerEntity player, float tickDelta, float pitch, Hand hand, float swingProgress, ItemStack item, float equipProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        boolean bl = hand == Hand.MAIN_HAND;
        Arm arm = bl ? player.getMainArm() : player.getMainArm().getOpposite();
        matrices.push();
        if (item.isEmpty()) {
            if (bl && !player.isInvisible()) {
                this.renderArmHoldingItem(matrices, vertexConsumers, light, equipProgress, swingProgress, arm);
            }
        } else if (item.getItem() == Items.FILLED_MAP) {
            if (bl && this.offHand.isEmpty()) {
                this.renderMapInBothHands(matrices, vertexConsumers, light, pitch, equipProgress, swingProgress);
            } else {
                this.renderMapInOneHand(matrices, vertexConsumers, light, equipProgress, arm, swingProgress, item);
            }
        } else {
            boolean bl4;
            float v;
            float w;
            float x;
            float y;
            if (item.getItem() == Items.CROSSBOW || item.getItem() == AnyItemsTools.RULER_WILL) {
                bl4 = CrossbowItem.isCharged(item);
                bl4 = RulerWill.isCharged(item);
                boolean bl3 = arm == Arm.RIGHT;
                int i = bl3 ? 1 : -1;
                if (player.isUsingItem() && player.getItemUseTimeLeft() > 0 && player.getActiveHand() == hand) {
                    this.applyEquipOffset(matrices, arm, equipProgress);
                    matrices.translate((double)((float)i * -0.4785682F), -0.0943870022892952D, 0.05731530860066414D);
                    matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(-11.935F));
                    matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((float)i * 65.3F));
                    matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion((float)i * -9.785F));
                    v = (float)item.getMaxUseTime() - ((float)this.client.player.getItemUseTimeLeft() - tickDelta + 1.0F);
                    w = v / (float)CrossbowItem.getPullTime(item);
                    if (w > 1.0F) {
                        w = 1.0F;
                    }

                    if (w > 0.1F) {
                        x = MathHelper.sin((v - 0.1F) * 1.3F);
                        y = w - 0.1F;
                        float k = x * y;
                        matrices.translate((double)(k * 0.0F), (double)(k * 0.004F), (double)(k * 0.0F));
                    }

                    matrices.translate((double)(w * 0.0F), (double)(w * 0.0F), (double)(w * 0.04F));
                    matrices.scale(1.0F, 1.0F, 1.0F + w * 0.2F);
                    matrices.multiply(Vector3f.NEGATIVE_Y.getDegreesQuaternion((float)i * 45.0F));
                } else {
                    v = -0.4F * MathHelper.sin(MathHelper.sqrt(swingProgress) * 3.1415927F);
                    w = 0.2F * MathHelper.sin(MathHelper.sqrt(swingProgress) * 6.2831855F);
                    x = -0.2F * MathHelper.sin(swingProgress * 3.1415927F);
                    matrices.translate((double)((float)i * v), (double)w, (double)x);
                    this.applyEquipOffset(matrices, arm, equipProgress);
                    this.applySwingOffset(matrices, arm, swingProgress);
                    if (bl4 && swingProgress < 0.001F) {
                        matrices.translate((double)((float)i * -0.641864F), 0.0D, 0.0D);
                        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((float)i * 10.0F));
                    }
                }

                this.renderItem(player, item, bl3 ? ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND : ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND, !bl3, matrices, vertexConsumers, light);
            } else {
                bl4 = arm == Arm.RIGHT;
                int o;
                float u;
                if (player.isUsingItem() && player.getItemUseTimeLeft() > 0 && player.getActiveHand() == hand) {
                    o = bl4 ? 1 : -1;
                    switch(item.getUseAction()) {
                        case NONE:
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            break;
                        case EAT:
                        case DRINK:
                            this.applyEatOrDrinkTransformation(matrices, tickDelta, arm, item);
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            break;
                        case BLOCK:
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            break;
                        case BOW:
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            matrices.translate((double)((float)o * -0.2785682F), 0.18344387412071228D, 0.15731531381607056D);
                            matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(-13.935F));
                            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((float)o * 35.3F));
                            matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion((float)o * -9.785F));
                            u = (float)item.getMaxUseTime() - ((float)this.client.player.getItemUseTimeLeft() - tickDelta + 1.0F);
                            v = u / 20.0F;
                            v = (v * v + v * 2.0F) / 3.0F;
                            if (v > 1.0F) {
                                v = 1.0F;
                            }

                            if (v > 0.1F) {
                                w = MathHelper.sin((u - 0.1F) * 1.3F);
                                x = v - 0.1F;
                                y = w * x;
                                matrices.translate((double)(y * 0.0F), (double)(y * 0.004F), (double)(y * 0.0F));
                            }

                            matrices.translate((double)(v * 0.0F), (double)(v * 0.0F), (double)(v * 0.04F));
                            matrices.scale(1.0F, 1.0F, 1.0F + v * 0.2F);
                            matrices.multiply(Vector3f.NEGATIVE_Y.getDegreesQuaternion((float)o * 45.0F));
                            break;
                        case SPEAR:
                            this.applyEquipOffset(matrices, arm, equipProgress);
                            matrices.translate((double)((float)o * -0.5F), 0.699999988079071D, 0.10000000149011612D);
                            matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(-55.0F));
                            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((float)o * 35.3F));
                            matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion((float)o * -9.785F));
                            u = (float)item.getMaxUseTime() - ((float)this.client.player.getItemUseTimeLeft() - tickDelta + 1.0F);
                            v = u / 10.0F;
                            if (v > 1.0F) {
                                v = 1.0F;
                            }

                            if (v > 0.1F) {
                                w = MathHelper.sin((u - 0.1F) * 1.3F);
                                x = v - 0.1F;
                                y = w * x;
                                matrices.translate((double)(y * 0.0F), (double)(y * 0.004F), (double)(y * 0.0F));
                            }

                            matrices.translate(0.0D, 0.0D, (double)(v * 0.2F));
                            matrices.scale(1.0F, 1.0F, 1.0F + v * 0.2F);
                            matrices.multiply(Vector3f.NEGATIVE_Y.getDegreesQuaternion((float)o * 45.0F));
                    }
                } else if (player.isUsingRiptide()) {
                    this.applyEquipOffset(matrices, arm, equipProgress);
                    o = bl4 ? 1 : -1;
                    matrices.translate((double)((float)o * -0.4F), 0.800000011920929D, 0.30000001192092896D);
                    matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion((float)o * 65.0F));
                    matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion((float)o * -85.0F));
                } else {
                    float aa = -0.4F * MathHelper.sin(MathHelper.sqrt(swingProgress) * 3.1415927F);
                    u = 0.2F * MathHelper.sin(MathHelper.sqrt(swingProgress) * 6.2831855F);
                    v = -0.2F * MathHelper.sin(swingProgress * 3.1415927F);
                    int ad = bl4 ? 1 : -1;
                    matrices.translate((double)((float)ad * aa), (double)u, (double)v);
                    this.applyEquipOffset(matrices, arm, equipProgress);
                    this.applySwingOffset(matrices, arm, swingProgress);
                }

                this.renderItem(player, item, bl4 ? ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND : ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND, !bl4, matrices, vertexConsumers, light);
            }
        }

        matrices.pop();
    }

}
