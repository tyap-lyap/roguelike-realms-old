package net.sfedunet.entity;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.entity.mob.InferiorDragonEntity;
import net.sfedunet.render.entity.InferiorDragonEntityRenderer;

public class AnyItemsEntities {

    public static EntityType<InferiorDragonEntity> INFERIOR_DRAGON;

    public static void register() {
        INFERIOR_DRAGON = Registry.register(Registry.ENTITY_TYPE, new Identifier("anyitem:inferior_dragon"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InferiorDragonEntity::new).dimensions(EntityDimensions.fixed(0.65F, 2.1F)).build());
        FabricDefaultAttributeRegistry.register(INFERIOR_DRAGON, InferiorDragonEntity.createInferiorDragonAttributes());
        EntityRendererRegistry.INSTANCE.register(INFERIOR_DRAGON, (dispatcher, context) -> {
            return new InferiorDragonEntityRenderer(dispatcher);
        });
    }
}