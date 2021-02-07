package net.sfedunet.entity;

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
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.sfedunet.item.armor.AnyItemsArmor;

@SuppressWarnings("EntityConstructor")
public class SupremeDragonEntity extends HostileEntity {
    public SupremeDragonEntity(EntityType<? extends SupremeDragonEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
    }

    public EntityGroup getGroup() {
        return AnyItemsEntityGroup.DRAGON;
    }

    protected void initEquipment() {
        Item mainHand = Items.STONE_SWORD;
        Item offHand = Items.SHIELD;
        Item head = AnyItemsArmor.DRAGON_HELMET;
        //Item chest = AnyItemsArmor.DRAGON_CHESTPLATE;
        Item legs = AnyItemsArmor.DRAGON_LEGGINGS;
        Item feet = AnyItemsArmor.DRAGON_BOOTS;
        switch (this.world.getDifficulty()) {
            case PEACEFUL:
                mainHand = Items.NETHERITE_SWORD;
                break;
            case EASY:
                mainHand = Items.NETHERITE_SWORD;
                break;
            case NORMAL:
                mainHand = Items.NETHERITE_SWORD;
                break;
            case HARD:
                mainHand = Items.NETHERITE_SWORD;
                break;
        }
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(mainHand));
        this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(offHand));
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(head));
        //this.equipStack(EquipmentSlot.CHEST, new ItemStack(chest));
        this.equipStack(EquipmentSlot.LEGS, new ItemStack(legs));
        this.equipStack(EquipmentSlot.FEET, new ItemStack(feet));
    }
    
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable CompoundTag entityTag) {
        EntityData _entityData = super.initialize(world, difficulty, spawnReason, entityData, entityTag);
        this.initEquipment();
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
