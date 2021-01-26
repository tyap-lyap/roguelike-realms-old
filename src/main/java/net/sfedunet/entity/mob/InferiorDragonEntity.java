package net.sfedunet.entity.mob;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class InferiorDragonEntity extends HostileEntity {
    public InferiorDragonEntity(EntityType<? extends InferiorDragonEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createInferiorDragonAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 25.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 6.0D);
    }

    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }

    protected void initEquipment() {
        Item item = Items.STONE_SWORD;
        switch (this.world.getDifficulty()) {
            case PEACEFUL:
                item = Items.POPPY;
                break;
            case EASY:
                item = Items.STICK;
                break;
            case NORMAL:
                item = Items.STONE_AXE;
                break;
            case HARD:
                item = Items.STONE_SWORD;
                break;
        }
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(item));
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable CompoundTag entityTag) {
        EntityData _entityData = super.initialize(world, difficulty, spawnReason, entityData, entityTag);
        this.initEquipment(difficulty);
        this.updateEnchantments(difficulty);
        if (this.getEquippedStack(EquipmentSlot.HEAD).isEmpty()) {
            LocalDate localDate = LocalDate.now();
            int i = localDate.get(ChronoField.DAY_OF_MONTH);
            int j = localDate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 10 && i == 31 && this.random.nextFloat() < 0.25F) {
                this.equipStack(EquipmentSlot.HEAD,
                        new ItemStack(this.random.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
                this.armorDropChances[EquipmentSlot.HEAD.getEntitySlotId()] = 0.0F;
            }
        }
        return _entityData;
    }
}
