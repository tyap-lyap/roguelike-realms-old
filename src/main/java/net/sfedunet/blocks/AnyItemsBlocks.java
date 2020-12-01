package net.sfedunet.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;

public class AnyItemsBlocks {
    public static final Block CRYPTON_BLOCK = new Block(FabricBlockSettings.copy(Blocks.OBSIDIAN).sounds(BlockSoundGroup.BONE));
    public static final Block CRYPTON_ORE = new Block(FabricBlockSettings.copy(Blocks.DIAMOND_ORE).sounds(BlockSoundGroup.STONE));
    public static final Block ECHSEROCK = new Block(FabricBlockSettings.copy(AnyItemsBlocks.CRYPTON_ORE).strength(10f));
    public static final Block DRAGON_INGOT_BLOCK = new Block(FabricBlockSettings.copy(Blocks.DIAMOND_BLOCK));
    public static final Block ASHES_BLOCK = new FallingBlock(FabricBlockSettings.copy(Blocks.SAND));

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
    }

}
