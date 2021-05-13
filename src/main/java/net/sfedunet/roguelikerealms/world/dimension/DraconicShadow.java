package net.sfedunet.roguelikerealms.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.sfedunet.roguelikerealms.RoguelikeRealmsMod;

public class DraconicShadow {

    public static final RegistryKey<World> DRACONIC_SHADOW = RegistryKey.of(Registry.DIMENSION, new Identifier(RoguelikeRealmsMod.MODID, "draconic_shadow"));

}
