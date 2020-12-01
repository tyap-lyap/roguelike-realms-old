package net.sfedunet.tools;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AnyItemsTools {
    public static final ToolMaterialCrypton CRYPTON_TOOLS = new ToolMaterialCrypton();
    public static final ToolMaterialCryptonSpraying CRYPTON_TOOLS_SPRAYING = new ToolMaterialCryptonSpraying();

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsprayingsword"), new CryptonSprayingSword(CRYPTON_TOOLS_SPRAYING));
        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsword"), new CryptonSword(CRYPTON_TOOLS));

        Registry.register(Registry.ITEM, new Identifier("anyitem:scythe"), new Scythe(new ScytheMaterial()));

        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsprayingpickaxe"), new CryptonSprayingPickaxe(CRYPTON_TOOLS_SPRAYING));
        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonpickaxe"), new CryptonPickaxe(CRYPTON_TOOLS));

        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsprayingaxe"), new CryptonSprayingAxe(CRYPTON_TOOLS_SPRAYING));
        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonaxe"), new CryptonAxe(CRYPTON_TOOLS));

        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsprayingshovel"), new CryptonSprayingShovel(CRYPTON_TOOLS_SPRAYING));
        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonshovel"), new CryptonShovel(CRYPTON_TOOLS));

        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonsprayinghoe"), new CryptonSprayingHoe(CRYPTON_TOOLS_SPRAYING));
        Registry.register(Registry.ITEM, new Identifier("anyitem:cryptonhoe"), new CryptonHoe(CRYPTON_TOOLS));
    }
}
