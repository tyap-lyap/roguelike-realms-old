package net.sfedunet.tools;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;

public class AnyItemsTools {
    public static final ToolMaterialCrypton CRYPTON_TOOLS = new ToolMaterialCrypton();
    public static final ToolMaterialCryptonSpraying CRYPTON_TOOLS_SPRAYING = new ToolMaterialCryptonSpraying();
    public static final DragonMaterialTool DRAGON_TOOL = new DragonMaterialTool();

    public static final RulerWill RULER_WILL = new RulerWill(new Item.Settings().group(AnyItemsMod.GENERAL).maxCount(1).maxDamage(2000));

    public static final EchserockToolMaterial ECHSEROCK_TOOL = new EchserockToolMaterial();


    public static void register(){
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_spraying_sword"), new CryptonSprayingSword(CRYPTON_TOOLS_SPRAYING));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_sword"), new CryptonSword(CRYPTON_TOOLS));

        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_spraying_pickaxe"), new CryptonSprayingPickaxe(CRYPTON_TOOLS_SPRAYING));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_pickaxe"), new CryptonPickaxe(CRYPTON_TOOLS));

        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_spraying_axe"), new CryptonSprayingAxe(CRYPTON_TOOLS_SPRAYING));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_axe"), new CryptonAxe(CRYPTON_TOOLS));

        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_spraying_shovel"), new CryptonSprayingShovel(CRYPTON_TOOLS_SPRAYING));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_shovel"), new CryptonShovel(CRYPTON_TOOLS));

        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_spraying_hoe"), new CryptonSprayingHoe(CRYPTON_TOOLS_SPRAYING));
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_hoe"), new CryptonHoe(CRYPTON_TOOLS));

        Registry.register(Registry.ITEM, new Identifier("anyitem:scythe"), new Scythe(new ScytheMaterial()));

        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_sword"), new DragonSword(DRAGON_TOOL));
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_pickaxe"), new DragonPickaxe(DRAGON_TOOL));
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_axe"), new DragonAxe(DRAGON_TOOL));
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_shovel"), new DragonShovel(DRAGON_TOOL));
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_hoe"), new DragonHoe(DRAGON_TOOL));


        Registry.register(Registry.ITEM, new Identifier("anyitem:ruler_will"), RULER_WILL);

        Registry.register(Registry.ITEM, new Identifier("anyitem:echserock_sword"), new EchserockSword(ECHSEROCK_TOOL));
        Registry.register(Registry.ITEM, new Identifier("anyitem:echserock_pickaxe"), new EchserockPickaxe(ECHSEROCK_TOOL));

    }
}