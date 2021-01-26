package net.sfedunet.world.dimension;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.sfedunet.AnyItemsMod;

public class DraconicShadow {

    public static final RegistryKey<World> DRACONIC_SHADOW = RegistryKey.of(Registry.DIMENSION, new Identifier(AnyItemsMod.MODID, "draconic_shadow"));

}
