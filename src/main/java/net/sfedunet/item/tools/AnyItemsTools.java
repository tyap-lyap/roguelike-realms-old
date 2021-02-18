package net.sfedunet.item.tools;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.item.AnyItemGroups;
import net.sfedunet.item.base.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnyItemsTools {

    private static final Map<Identifier, Item> ITEMS = new LinkedHashMap<>();

    public static final Item CRYPTON_SPR_SWORD = add("crypton_spraying_sword", new BaseSwordItem(AnyToolMaterials.CRYPTON_SPRAING_TM, 1, -2));
    public static final Item CRYPTON_SWORD = add("crypton_sword", new BaseSwordItem(AnyToolMaterials.CRYPTON_TOOL_MATERIAL, 0, -1));
    public static final Item CRYPTON_SPR_PICKAXE = add("crypton_spraying_pickaxe", new BasePickaxeItem(AnyToolMaterials.CRYPTON_SPRAING_TM, -2, -2));
    public static final Item CRYPTON_PICKAXE = add("crypton_pickaxe", new BasePickaxeItem(AnyToolMaterials.CRYPTON_TOOL_MATERIAL, -3, -1));
    public static final Item CRYPTON_SPR_AXE = add("crypton_spraying_axe", new BaseAxeItem(AnyToolMaterials.CRYPTON_SPRAING_TM, 2, -2));
    public static final Item CRYPTON_AXE = add("crypton_axe", new BaseAxeItem(AnyToolMaterials.CRYPTON_TOOL_MATERIAL, 3, -1));
    public static final Item CRYPTON_SPR_SHOVEL = add("crypton_spraying_shovel", new BaseShovelItem(AnyToolMaterials.CRYPTON_SPRAING_TM, -2, -2));
    public static final Item CRYPTON_SHOVEL = add("crypton_shovel", new BaseShovelItem(AnyToolMaterials.CRYPTON_TOOL_MATERIAL, -1, -1));
    public static final Item CRYPTON_SPR_HOE = add("crypton_spraying_hoe", new BaseHoeItem(AnyToolMaterials.CRYPTON_SPRAING_TM, -3, -3));
    public static final Item CRYPTON_HOE = add("crypton_hoe", new BaseHoeItem(AnyToolMaterials.CRYPTON_TOOL_MATERIAL, -5, -3));

    public static final Item SCYTHE = add("scythe", new Scythe(AnyToolMaterials.SCYTHE_MATERIAL));
    public static final Item DRAGON_SWORD = add("dragon_sword", new BaseSwordItem(AnyToolMaterials.DRAGON_TOOL_MATERIAL, 0, 1));
    public static final Item DRAGON_PICKAXE = add("dragon_pickaxe", new BasePickaxeItem(AnyToolMaterials.DRAGON_TOOL_MATERIAL, 0, 1));
    public static final Item DRAGON_AXE = add("dragon_axe", new BaseAxeItem(AnyToolMaterials.DRAGON_TOOL_MATERIAL, 2, 1));
    public static final Item DRAGON_SHOVEL = add("dragon_shovel", new BaseShovelItem(AnyToolMaterials.DRAGON_TOOL_MATERIAL, 0, 1));
    public static final Item DRAGON_HOE = add("dragon_hoe", new BaseHoeItem(AnyToolMaterials.DRAGON_TOOL_MATERIAL, -5, -3));
    public static final Item RULER_WILL = add("ruler_will", new RulerWill(new Item.Settings().group(AnyItemGroups.TOOLS_AND_WEAPONS).maxCount(1).maxDamage(2000)));
    public static final Item ECHSEROCK_SWORD = add("echserock_sword", new BaseSwordItem(AnyToolMaterials.ECHSEROCK_TOOL_MATERIAL, 0, 0));
    public static final Item ECHSEROCK_PICKAXE = add("echserock_pickaxe", new BasePickaxeItem(AnyToolMaterials.ECHSEROCK_TOOL_MATERIAL, 0, 0));

    private static <I extends Item> I add(String name, I item) {
        ITEMS.put(new Identifier(AnyItemsMod.MODID, name), item);
        return item;
    }

    public static void register(){

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
    }
}