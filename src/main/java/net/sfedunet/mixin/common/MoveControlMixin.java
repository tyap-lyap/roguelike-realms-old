package net.sfedunet.mixin.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeMaker;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.sfedunet.entity.projectiles.ParalysisArrowEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MoveControl.class)
public class MoveControlMixin {
    @Shadow protected final MobEntity entity;
    @Shadow protected double targetX;
    @Shadow protected double targetY;
    @Shadow protected double targetZ;
    @Shadow protected double speed;
    @Shadow protected float forwardMovement;
    @Shadow protected float sidewaysMovement;
    @Shadow protected net.minecraft.entity.ai.control.MoveControl.State state;

        public MoveControlMixin(MobEntity entity) {
            this.state = net.minecraft.entity.ai.control.MoveControl.State.WAIT;
            this.entity = entity;
        }

    @Shadow protected float changeAngle(float from, float to, float max) {
        float f = MathHelper.wrapDegrees(to - from);
        if (f > max) {
            f = max;
        }

        if (f < -max) {
            f = -max;
        }

        float g = from + f;
        if (g < 0.0F) {
            g += 360.0F;
        } else if (g > 360.0F) {
            g -= 360.0F;
        }

        return g;
    }

    @Shadow private boolean method_25946(float f, float g) {
        EntityNavigation entityNavigation = this.entity.getNavigation();
        if (entityNavigation != null) {
            PathNodeMaker pathNodeMaker = entityNavigation.getNodeMaker();
            if (pathNodeMaker != null && pathNodeMaker.getDefaultNodeType(this.entity.world, MathHelper.floor(this.entity.getX() + (double)f), MathHelper.floor(this.entity.getY()), MathHelper.floor(this.entity.getZ() + (double)g)) != PathNodeType.WALKABLE) {
                return false;
            }
        }

        return true;
    }

    public void tick() {
        if (this.entity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) >= 1){
            this.entity.setForwardSpeed(0.0F);
        }
        if (this.entity.getDataTracker().get(ParalysisArrowEntity.PARALYSIS) == 0){
            float q;
            if (this.state == MoveControl.State.STRAFE) {
                float f = (float) this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED);
                float g = (float) this.speed * f;
                float h = this.forwardMovement;
                float i = this.sidewaysMovement;
                float j = MathHelper.sqrt(h * h + i * i);
                if (j < 1.0F) {
                    j = 1.0F;
                }

                j = g / j;
                h *= j;
                i *= j;
                float k = MathHelper.sin(this.entity.yaw * 0.017453292F);
                float l = MathHelper.cos(this.entity.yaw * 0.017453292F);
                float m = h * l - i * k;
                q = i * l + h * k;
                if (!this.method_25946(m, q)) {
                    this.forwardMovement = 1.0F;
                    this.sidewaysMovement = 0.0F;
                }

                this.entity.setMovementSpeed(g);
                this.entity.setForwardSpeed(this.forwardMovement);
                this.entity.setSidewaysSpeed(this.sidewaysMovement);
                this.state = MoveControl.State.WAIT;
            } else if (this.state == MoveControl.State.MOVE_TO) {
                this.state = MoveControl.State.WAIT;
                double d = this.targetX - this.entity.getX();
                double e = this.targetZ - this.entity.getZ();
                double o = this.targetY - this.entity.getY();
                double p = d * d + o * o + e * e;
                if (p < 2.500000277905201E-7D) {
                    this.entity.setForwardSpeed(0.0F);
                    return;
                }

                q = (float) (MathHelper.atan2(e, d) * 57.2957763671875D) - 90.0F;
                this.entity.yaw = this.changeAngle(this.entity.yaw, q, 90.0F);
                this.entity.setMovementSpeed((float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)));
                BlockPos blockPos = this.entity.getBlockPos();
                BlockState blockState = this.entity.world.getBlockState(blockPos);
                Block block = blockState.getBlock();
                VoxelShape voxelShape = blockState.getCollisionShape(this.entity.world, blockPos);
                if (o > (double) this.entity.stepHeight && d * d + e * e < (double) Math.max(1.0F, this.entity.getWidth()) || !voxelShape.isEmpty() && this.entity.getY() < voxelShape.getMax(Direction.Axis.Y) + (double) blockPos.getY() && !block.isIn(BlockTags.DOORS) && !block.isIn(BlockTags.FENCES)) {
                    this.entity.getJumpControl().setActive();
                    this.state = MoveControl.State.JUMPING;
                }
            } else if (this.state == MoveControl.State.JUMPING) {
                this.entity.setMovementSpeed((float) (this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)));
                if (this.entity.isOnGround()) {
                    this.state = MoveControl.State.WAIT;
                }
            } else {
                this.entity.setForwardSpeed(0.0F);
            }

        }
    }

}
