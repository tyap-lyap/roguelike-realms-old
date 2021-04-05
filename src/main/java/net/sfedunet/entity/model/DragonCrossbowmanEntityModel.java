package net.sfedunet.entity.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.MobEntity;


public class DragonCrossbowmanEntityModel<T extends MobEntity> extends PlayerEntityModel<T> {

    public DragonCrossbowmanEntityModel() {
        super(0, false);
        textureWidth = 128;
        textureHeight = 128;

        head = new ModelPart(this);
        head.setPivot(0.0F, 0.0F, 0.0F);
        head.setTextureOffset(32, 0).addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);
        head.setTextureOffset(0, 0).addCuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(0, 64).addCuboid(-2.0F, -3.0F, -7.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        ModelPart leftThing_r1 = new ModelPart(this);
        leftThing_r1.setPivot(0.0F, 0.0F, 0.0F);
        head.addChild(leftThing_r1);
        setRotationAngle(leftThing_r1, 0.0F, 0.3491F, 0.0F);
        leftThing_r1.setTextureOffset(26, 64).addCuboid(3.0F, -8.0F, 2.0F, 1.0F, 5.0F, 5.0F, 0.0F, false);

        ModelPart rightThing_r1 = new ModelPart(this);
        rightThing_r1.setPivot(0.0F, 0.0F, 0.0F);
        head.addChild(rightThing_r1);
        setRotationAngle(rightThing_r1, 0.0F, -0.3491F, 0.0F);
        rightThing_r1.setTextureOffset(14, 64).addCuboid(-4.0F, -8.0F, 2.0F, 1.0F, 5.0F, 5.0F, 0.0F, false);

        torso = new ModelPart(this);
        torso.setPivot(0.0F, 0.0F, 0.0F);
        torso.setTextureOffset(16, 16).addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
        torso.setTextureOffset(16, 32).addCuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);

        rightArm = new ModelPart(this);
        rightArm.setPivot(-5.0F, 2.0F, 0.0F);
        rightArm.setTextureOffset(40, 16).addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        rightArm.setTextureOffset(40, 32).addCuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        leftArm = new ModelPart(this);
        leftArm.setPivot(5.0F, 2.0F, 0.0F);
        leftArm.setTextureOffset(32, 48).addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        leftArm.setTextureOffset(48, 48).addCuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        rightLeg = new ModelPart(this);
        rightLeg.setPivot(-1.9F, 12.0F, 0.0F);
        rightLeg.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        rightLeg.setTextureOffset(0, 32).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        leftLeg = new ModelPart(this);
        leftLeg.setPivot(1.9F, 12.0F, 0.0F);
        leftLeg.setTextureOffset(16, 48).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        leftLeg.setTextureOffset(0, 48).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
    }

    public void setRotationAngle(ModelPart modelPart, float x, float y, float z) {
        modelPart.pitch = x;
        modelPart.yaw = y;
        modelPart.roll = z;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, vertices, light, overlay);
        this.torso.render(matrices, vertices, light, overlay);
        this.leftArm.render(matrices, vertices, light, overlay);
        this.rightArm.render(matrices, vertices, light, overlay);
        this.leftLeg.render(matrices, vertices, light, overlay);
        this.rightLeg.render(matrices, vertices, light, overlay);

    }
}
