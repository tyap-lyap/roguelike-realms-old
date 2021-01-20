package net.sfedunet.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.tools.AnyItemsTools;

public class AnyItemsBlocks {
    public static final Block CRYPTON_BLOCK = new Block(FabricBlockSettings.copy(Blocks.OBSIDIAN).sounds(BlockSoundGroup.BONE));
    public static final Block CRYPTON_ORE = new Block(FabricBlockSettings.copy(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.STONE));
    public static final Block ECHSEROCK = new Block(FabricBlockSettings.copy(AnyItemsBlocks.CRYPTON_ORE).strength(8f));
    public static final Block ASHES_BLOCK = new FallingBlock(FabricBlockSettings.copy(Blocks.SAND));
    public static final Block DRAGON_INGOT_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(5f).sounds(BlockSoundGroup.METAL));
    public static final Block DRAGON_SCALES_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES).strength(4f).sounds(BlockSoundGroup.NETHER_BRICKS));
    public static final Block DRAGON_WOOD = new Block(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).sounds(BlockSoundGroup.WOOD).strength(1f));
    public static final Block DRAGON_STONE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(2f).sounds(BlockSoundGroup.STONE));
    public static final Block DRAGON_COBBLESTONE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(2f).sounds(BlockSoundGroup.STONE));
    public static final Block DRAGON_PLANKS = new Block(FabricBlockSettings.copy(Blocks.ACACIA_PLANKS).strength(1f).sounds(BlockSoundGroup.WOOD));
    public static final Block DRAGON_LEAVES1 = new LeavesBlock(FabricBlockSettings.copy(Blocks.BIRCH_LEAVES).strength(0f).sounds(BlockSoundGroup.GRASS));
    public static final Block DRAGON_LEAVES2 = new LeavesBlock(FabricBlockSettings.copy(Blocks.BIRCH_LEAVES).strength(0f).sounds(BlockSoundGroup.GRASS));

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("anyitem:echserock"), ECHSEROCK);
        Registry.register(Registry.ITEM, new Identifier("anyitem:echserock"), new BlockItem(ECHSEROCK, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:dragon_ingot_block"), DRAGON_INGOT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_ingot_block"), new BlockItem(DRAGON_INGOT_BLOCK, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:ashes_block"), ASHES_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("anyitem:ashes_block"), new BlockItem(ASHES_BLOCK, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:crypton_block"), CRYPTON_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_block"), new BlockItem(CRYPTON_BLOCK, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:crypton_ore"), CRYPTON_ORE);
        Registry.register(Registry.ITEM, new Identifier("anyitem:crypton_ore"), new BlockItem(CRYPTON_ORE, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:dragon_scales_block"), DRAGON_SCALES_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_scales_block"), new BlockItem(DRAGON_SCALES_BLOCK, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:dragon_wood"), DRAGON_WOOD);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_wood"), new BlockItem(DRAGON_WOOD, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:dragon_stone"), DRAGON_STONE);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_stone"), new BlockItem(DRAGON_STONE, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:dragon_cobblestone"), DRAGON_COBBLESTONE);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_cobblestone"), new BlockItem(DRAGON_COBBLESTONE, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:dragon_planks"), DRAGON_PLANKS);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_planks"), new BlockItem(DRAGON_PLANKS, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:dragon_leaves1"), DRAGON_LEAVES1);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_leaves1"), new BlockItem(DRAGON_LEAVES1, new FabricItemSettings().group(AnyItemsMod.GENERAL)));

        Registry.register(Registry.BLOCK, new Identifier("anyitem:dragon_leaves2"), DRAGON_LEAVES2);
        Registry.register(Registry.ITEM, new Identifier("anyitem:dragon_leaves2"), new BlockItem(DRAGON_LEAVES2, new FabricItemSettings().group(AnyItemsMod.GENERAL)));
    }

}
