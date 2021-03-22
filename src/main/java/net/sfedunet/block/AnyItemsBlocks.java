package net.sfedunet.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.block.base.BaseBlock;
import net.sfedunet.block.base.BasePlantBlock;
import net.sfedunet.item.AnyItemGroups;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnyItemsBlocks {

    private static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    public static final Block CRYPTON_BLOCK = add("crypton_block", new BaseBlock(Blocks.OBSIDIAN, BlockSoundGroup.BONE));
    public static final Block CRYPTON_ORE = add("crypton_ore", new BaseBlock());

    // todo: redo
    public static final Block ECHSEROCK = add("echserock", new BaseBlock(FabricBlockSettings.copyOf(Blocks.STONE).luminance(14)));
    public static final Block ASHES_BLOCK = add("ashes_block", new FallingBlock(FabricBlockSettings.copyOf(Blocks.SAND)));
    public static final Block DRAGON_INGOT_BLOCK = add("dragon_ingot_block", new BaseBlock(Blocks.IRON_BLOCK));
    public static final Block DRAGON_SCALES_BLOCK = add("dragon_scales_block", new DragonScalesBlock("normal"));
    public static final Block GILDED_DRAGON_SCALES_BLOCK = add("gilded_dragon_scales_block", new DragonScalesBlock("gilded"));

    public static final Block DRAGON_STONE = add("dragon_stone", new BaseBlock());
    public static final Block DRAGON_DIRT = add("dragon_dirt", new BaseBlock(Blocks.DIRT));
    public static final Block DRAGOSS = add("dragoss", new BaseBlock(Blocks.GRASS_BLOCK)); //драконий дерн оригинально да? P.s да
    public static final Block DRAGON_GRASS = add("dragon_grass", new BasePlantBlock(FabricBlockSettings.copyOf(Blocks.GRASS)));
    public static final Block DRAGON_DAISY = add("dragon_daisy", new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 240, FabricBlockSettings.copyOf(Blocks.OXEYE_DAISY).luminance(7)));
    public static final Block DRAGON_COBBLESTONE = add("dragon_cobblestone", new BaseBlock());
    public static final Block DRACONIC_SHADOW_PORTAL = add("draconic_shadow_portal", new DraconicShadowPortalBlock());
    public static final EmeraldPedestal EMERALD_PEDESTAL = add("emerald_pedestal", new EmeraldPedestal());

    public static final Block DRAGON_GRAPE_LOG = add("dragon_grape_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block DRAGON_GRAPE_PLANKS = add("dragon_grape_planks", new BaseBlock(Blocks.OAK_PLANKS));
    public static final Block DRAGON_GRAPE_LEAVES = add("dragon_grape_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block DRAGON_GRAPE_VINES = add("dragon_grape_vines", new GrapeVinesBlock("normal"));
    public static final Block DRAGON_GRAPE_VINES_TIP = add("dragon_grape_vines_tip", new GrapeVinesBlock("tip"));
    public static final Block GRAPED_DRAGON_GRAPE_VINES = add("graped_dragon_grape_vines", new GrapeVinesBlock("graped"));

    public static final Block DRAGON_WILLOW_LOG = add("dragon_willow_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
    public static final Block DRAGON_WILLOW_PLANKS = add("dragon_willow_planks", new BaseBlock(Blocks.OAK_PLANKS));
    public static final Block DRAGON_WILLOW_LEAVES = add("dragon_willow_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
    public static final Block DRAGON_WILLOW_VINES = add("dragon_willow_vines", new WillowVinesBlock("normal"));
    public static final Block DRAGON_WILLOW_VINES_TIP = add("dragon_willow_vines_tip", new WillowVinesBlock("tip"));


    private static <B extends Block> B add(String name, B block, ItemGroup tab) {
        Item.Settings settings = new Item.Settings();
        if (tab != null) {
            settings.group(tab);
        }
        return add(name, block, new BlockItem(block, settings));
    }

    private static <B extends Block> B add(String name, B block, BlockItem item) {
        addBlock(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(new Identifier(AnyItemsMod.MODID, name), item);
        }
        return block;
    }

    private static <B extends Block> B addBlock(String name, B block) {
        BLOCKS.put(new Identifier(AnyItemsMod.MODID, name), block);
        return block;
    }
    private static <B extends Block> B add(String name, B block) {
        Item.Settings settings = new Item.Settings();
        settings.group(AnyItemGroups.BLOCKS);
        return add(name, block, new BlockItem(block, settings));
    }

    private static <I extends BlockItem> I add(String name, I item) {
        item.appendBlocks(Item.BLOCK_ITEMS, item);
        ITEMS.put(new Identifier(AnyItemsMod.MODID, name), item);
        return item;
    }

    public static void register() {

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }

}
