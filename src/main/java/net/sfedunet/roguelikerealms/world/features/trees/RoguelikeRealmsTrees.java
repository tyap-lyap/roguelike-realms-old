package net.sfedunet.roguelikerealms.world.features.trees;

import com.mojang.serialization.Codec;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.sfedunet.roguelikerealms.RoguelikeRealmsMod;
import net.sfedunet.roguelikerealms.world.features.trees.placers.DragonGrapeFoliagePlacer;
import net.sfedunet.roguelikerealms.world.features.trees.placers.DragonGrapeTrunkPlacer;
import net.sfedunet.roguelikerealms.world.features.trees.placers.DragonWillowFoliagePlacer;
import net.sfedunet.roguelikerealms.world.features.trees.placers.DragonWillowTrunkPlacer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


@SuppressWarnings({"unchecked", "rawtypes"})
public class RoguelikeRealmsTrees {

    private static Constructor<FoliagePlacerType> foliageConstructor;
    private static Constructor<TrunkPlacerType> trunkConstructor;

    public static FoliagePlacerType<DragonWillowFoliagePlacer> DRAGON_WILLOW_FOLIAGE;
    public static TrunkPlacerType<DragonWillowTrunkPlacer> DRAGON_WILLOW_TRUNK;

    public static FoliagePlacerType<DragonGrapeFoliagePlacer> DRAGON_GRAPE_FOLIAGE;
    public static TrunkPlacerType<DragonGrapeTrunkPlacer> DRAGON_GRAPE_TRUNK;

    public static <P extends FoliagePlacer> FoliagePlacerType<P> registerFoliage(String name, Codec<P> codec) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return Registry.register(Registry.FOLIAGE_PLACER_TYPE, new Identifier(RoguelikeRealmsMod.MODID, name), foliageConstructor.newInstance(codec));
    }
    public static <P extends TrunkPlacer> TrunkPlacerType<P> registerTrunk(String name, Codec<P> codec) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return Registry.register(Registry.TRUNK_PLACER_TYPE, new Identifier(RoguelikeRealmsMod.MODID, name), trunkConstructor.newInstance(codec));
    }


    public static void registerTrees() {
        try {
            DRAGON_WILLOW_FOLIAGE = registerFoliage("dragon_willow_folliage_placer", DragonWillowFoliagePlacer.CODEC);
            DRAGON_WILLOW_TRUNK = registerTrunk("dragon_willow_trunk_placer", DragonWillowTrunkPlacer.CODEC);

            DRAGON_GRAPE_FOLIAGE = registerFoliage("dragon_grape_folliage_placer", DragonGrapeFoliagePlacer.CODEC);
            DRAGON_GRAPE_TRUNK = registerTrunk("dragon_grape_trunk_placer", DragonGrapeTrunkPlacer.CODEC);
            foliageConstructor.setAccessible(false);
            trunkConstructor.setAccessible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static {
        try {
            foliageConstructor = FoliagePlacerType.class.getDeclaredConstructor(Codec.class);
            foliageConstructor.setAccessible(true);
            trunkConstructor = TrunkPlacerType.class.getDeclaredConstructor(Codec.class);
            trunkConstructor.setAccessible(true);
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
    }


}
