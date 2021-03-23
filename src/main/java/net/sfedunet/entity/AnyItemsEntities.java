package net.sfedunet.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;

public class AnyItemsEntities {

    public static final EntityType<ArmoredDragonEntity> ARMORED_DRAGON = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(AnyItemsMod.MODID, "armored_dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ArmoredDragonEntity::new).dimensions(EntityDimensions.fixed(0.65F, 2.1F)).build());   
    public static final EntityType<DragonBowmanEntity> DRAGON_BOWMAN = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(AnyItemsMod.MODID, "dragon_bowman"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DragonBowmanEntity::new).dimensions(EntityDimensions.fixed(0.65F, 2.1F)).build());
    public static final EntityType<DragonCrossbowmanEntity> DRAGON_CROSSBOWMAN = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(AnyItemsMod.MODID, "dragon_crossbowman"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DragonCrossbowmanEntity::new).dimensions(EntityDimensions.fixed(0.65F, 2.1F)).build());
    public static final EntityType<DragonSwordmanEntity> DRAGON_SWORDMAN = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(AnyItemsMod.MODID, "dragon_swordman"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DragonSwordmanEntity::new).dimensions(EntityDimensions.fixed(0.65F, 2.1F)).build());
    public static final EntityType<DragonWarlordEntity> DRAGON_WARLORD = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(AnyItemsMod.MODID, "dragon_warlord"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DragonWarlordEntity::new).dimensions(EntityDimensions.fixed(0.65F, 2.1F)).build());   
    public static final EntityType<InferiorDragonEntity> INFERIOR_DRAGON = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(AnyItemsMod.MODID, "inferior_dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InferiorDragonEntity::new).dimensions(EntityDimensions.fixed(0.65F, 2.1F)).build());
    public static final EntityType<CasterDragonEntity> CASTER_DRAGON = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(AnyItemsMod.MODID, "caster_dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CasterDragonEntity::new).dimensions(EntityDimensions.fixed(0.65F, 2.1F)).build());
    public static final EntityType<SupremeDragonEntity> SUPREME_DRAGON = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(AnyItemsMod.MODID, "supreme_dragon"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SupremeDragonEntity::new).dimensions(EntityDimensions.fixed(0.65F, 2.1F)).build());
    
    public static void register() {
        FabricDefaultAttributeRegistry.register(ARMORED_DRAGON, ArmoredDragonEntity.createAttr());
        FabricDefaultAttributeRegistry.register(DRAGON_BOWMAN, DragonBowmanEntity.createAttr());
        FabricDefaultAttributeRegistry.register(DRAGON_CROSSBOWMAN, DragonCrossbowmanEntity.createAttr());
        FabricDefaultAttributeRegistry.register(DRAGON_SWORDMAN, DragonSwordmanEntity.createAttr());
        FabricDefaultAttributeRegistry.register(DRAGON_WARLORD, DragonWarlordEntity.createAttr());
        FabricDefaultAttributeRegistry.register(INFERIOR_DRAGON, InferiorDragonEntity.createAttr());
        FabricDefaultAttributeRegistry.register(CASTER_DRAGON, CasterDragonEntity.createAttr());
        FabricDefaultAttributeRegistry.register(SUPREME_DRAGON, SupremeDragonEntity.createAttr());
    }

}