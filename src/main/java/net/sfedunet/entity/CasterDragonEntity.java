package net.sfedunet.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.sfedunet.AnyItemsMod;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.sfedunet.item.armor.AnyItemsArmor;

@SuppressWarnings("EntityConstructor")
public class CasterDragonEntity extends HostileEntity {

    public CasterDragonEntity(EntityType<? extends CasterDragonEntity> entityType, World world) {
        super(entityType, world);
        // if (SHOOTING == null) SHOOTING =
        // DataTracker.registerData(SpittingDragonEntity.class,
        // TrackedDataHandlerRegistry.BOOLEAN);
    }

    protected void initGoals() {
        this.goalSelector.add(1, new CasterDragonEntity.ShootFireballGoal(this));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
    }

    public EntityGroup getGroup() {
        return AnyItemsEntityGroup.DRAGON;
    }

    public static DefaultAttributeContainer.Builder createAttr(){
        return HostileEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1).add(EntityAttributes.GENERIC_MAX_HEALTH, 35);
    }

    protected void initEquipment() {
         Item mainHand = Items.STONE_SWORD;
        // Item offHand = Items.SHIELD;
        Item head = AnyItemsArmor.DRAGON_HELMET;
        // Item chest = AnyItemsArmor.DRAGON_CHESTPLATE;
        //Item legs = AnyItemsArmor.DRAGON_LEGGINGS;
        Item feet = AnyItemsArmor.DRAGON_BOOTS;
        switch (this.world.getDifficulty()) {
            case PEACEFUL:
                // mainHand = Items.POPPY;
                break;
            case EASY:
                 mainHand = Items.STICK;
                 head = Items.AIR;
                 feet = Items.GOLDEN_BOOTS;
                break;
            case NORMAL:
                mainHand = Items.STICK;
                head = Items.GOLDEN_HELMET;
                feet = Items.GOLDEN_BOOTS;
                break;
            case HARD:
                 mainHand = Items.BONE;
                 head = Items.NETHERITE_HELMET;
                 feet = Items.NETHERITE_BOOTS;
                break;
        }
         this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(mainHand));
        // this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(offHand));
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(head));
        // this.equipStack(EquipmentSlot.CHEST, new ItemStack(chest));
        //this.equipStack(EquipmentSlot.LEGS, new ItemStack(legs));
        this.equipStack(EquipmentSlot.FEET, new ItemStack(feet));
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
            @Nullable EntityData entityData, @Nullable CompoundTag entityTag) {
        EntityData _entityData = super.initialize(world, difficulty, spawnReason, entityData, entityTag);
        this.initEquipment();
        if (this.getEquippedStack(EquipmentSlot.FEET).isEmpty()) {
            LocalDate localDate = LocalDate.now();
            int i = localDate.get(ChronoField.DAY_OF_MONTH);
            int j = localDate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 10 && i == 31 && this.random.nextFloat() < 0.25F) {
                this.equipStack(EquipmentSlot.FEET,
                        new ItemStack(this.random.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
                this.armorDropChances[EquipmentSlot.FEET.getEntitySlotId()] = 0.0F;
            }
        }
        return _entityData;
    }

    public void setShooting(boolean shooting) {
    }

    static class ShootFireballGoal extends Goal {
        private final CasterDragonEntity dragon;
        public int cooldown;

        public ShootFireballGoal(CasterDragonEntity dragon) {
            this.dragon = dragon;
        }

        public boolean canStart() {
            return this.dragon.getTarget() != null;
        }

        public void start() {
            this.cooldown = 0;
        }

        public void stop() {
            this.dragon.setShooting(false);
        }

        public void tick() {
            LivingEntity livingEntity = this.dragon.getTarget();
            if (livingEntity.squaredDistanceTo(this.dragon) < 4096.0D && this.dragon.canSee(livingEntity)) {
                World world = this.dragon.world;
                ++this.cooldown;
                if (this.cooldown == 10 && !this.dragon.isSilent()) {
                    //world.syncWorldEvent((PlayerEntity) null, 1015, this.dragon.getBlockPos(), 0);
                    world.playSound(null, this.dragon.getBlockPos(), AnyItemsMod.SPITTING_PEW, SoundCategory.AMBIENT, 1.0F, 1.0F);
                }

                if (this.cooldown == 20) {
                    double f = livingEntity.getX() - (this.dragon.getX());
                    double g = livingEntity.getBodyY(0.5D) - (0.5D + this.dragon.getBodyY(0.5D));
                    double h = livingEntity.getZ() - (this.dragon.getZ());
                    if (!this.dragon.isSilent()) {
                        world.syncWorldEvent((PlayerEntity) null, 1016, this.dragon.getBlockPos(), 0);
                    }

                    FireballEntity fireballEntity = new FireballEntity(world, this.dragon, f, g, h);
                    fireballEntity.explosionPower = this.dragon.getFireballStrength();
                    fireballEntity.updatePosition(this.dragon.getX(), this.dragon.getBodyY(0.5D) + 0.75D, fireballEntity.getZ());
                    world.spawnEntity(fireballEntity);
                    this.cooldown = -40;
                }
            } else if (this.cooldown > 0) {
                --this.cooldown;
            }

            this.dragon.setShooting(this.cooldown > 10);
        }
    }

    public int getFireballStrength() {
        return 1;
    }

}
