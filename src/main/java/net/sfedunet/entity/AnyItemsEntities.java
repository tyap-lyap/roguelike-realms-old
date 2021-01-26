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

    public static final EntityType<InferiorDragonEntity> INFERIOR_DRAGON = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(AnyItemsMod.MODID, "inferior_dragon"),
            FabricEntityTypeBuilder
                    .create(SpawnGroup.MONSTER, InferiorDragonEntity::new)
                    .dimensions(EntityDimensions.fixed(0.65F, 2.1F)).build());

    public static void register() {
        FabricDefaultAttributeRegistry.register(INFERIOR_DRAGON, InferiorDragonEntity.createInferiorDragonAttributes());
    }

}