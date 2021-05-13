package net.sfedunet.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.sfedunet.item.armor.RoguelikeRealmsArmor;

@SuppressWarnings("EntityConstructor")
public class DragonBowmanEntity extends HostileEntity implements RangedAttackMob {

    public DragonBowmanEntity(EntityType<? extends DragonBowmanEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(4, new BowAttackGoal<>(this, 1.0D, 20, 15.0F));
        this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(1, (new RevengeGoal(this, new Class[0])).setGroupRevenge(new Class[]{ZombifiedPiglinEntity.class}));
    }

    public EntityGroup getGroup() {
        return RoguelikeRealmsEntityGroup.DRAGON;
    }

    public static DefaultAttributeContainer.Builder createAttr(){
        return HostileEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3).add(EntityAttributes.GENERIC_MAX_HEALTH, 30);
    }

    protected void initEquipment() {
        Item mainHand = Items.BOW;
        //Item offHand = Items.SHIELD;
        Item head = RoguelikeRealmsArmor.DRAGON_HELMET;
        // Item chest = AnyItemsArmor.DRAGON_CHESTPLATE;
        Item legs = RoguelikeRealmsArmor.DRAGON_LEGGINGS;
       // Item feet = AnyItemsArmor.DRAGON_BOOTS;
        switch (this.world.getDifficulty()) {
            case PEACEFUL:
                //mainHand = Items.POPPY;
                break;
            case EASY:
                head = Items.GOLDEN_HELMET;
                legs = Items.GOLDEN_LEGGINGS;
                break;
            case NORMAL:
                head = Items.NETHERITE_HELMET;
                legs = Items.NETHERITE_LEGGINGS;
                break;
            case HARD:
                //mainHand = Items.STONE_SWORD;
                break;
        }
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(mainHand));
        //this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(offHand));
        this.equipStack(EquipmentSlot.HEAD, new ItemStack(head));
        // this.equipStack(EquipmentSlot.CHEST, new ItemStack(chest));
        this.equipStack(EquipmentSlot.LEGS, new ItemStack(legs));
       // this.equipStack(EquipmentSlot.FEET, new ItemStack(feet));
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
            @Nullable EntityData entityData, @Nullable CompoundTag entityTag) {
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

    @Override
    public void attack(LivingEntity target, float pullProgress) {
        ItemStack itemStack = this.getArrowType(this.getStackInHand(ProjectileUtil.getHandPossiblyHolding(this, Items.BOW)));
        PersistentProjectileEntity persistentProjectileEntity = this.createArrowProjectile(itemStack, pullProgress);
        double d = target.getX() - this.getX();
        double e = target.getBodyY(0.3333333333333333D) - persistentProjectileEntity.getY();
        double f = target.getZ() - this.getZ();
        double g = (double) MathHelper.sqrt(d * d + f * f);
        persistentProjectileEntity.setVelocity(d, e + g * 0.20000000298023224D, f, 1.6F, (float) (14 - this.world.getDifficulty().getId() * 4));
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(persistentProjectileEntity);
    }

    protected PersistentProjectileEntity createArrowProjectile(ItemStack arrow, float damageModifier) {
        return ProjectileUtil.createArrowProjectile(this, arrow, damageModifier);
     }
}
