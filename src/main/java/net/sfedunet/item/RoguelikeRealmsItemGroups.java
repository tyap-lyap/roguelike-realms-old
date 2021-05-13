package net.sfedunet.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.sfedunet.RoguelikeRealmsMod;
import net.sfedunet.block.RoguelikeRealmsBlocks;
import net.sfedunet.item.armor.RoguelikeRealmsArmor;
import net.sfedunet.item.tools.RoguelikeRealmsTools;

public class RoguelikeRealmsItemGroups {

    public static final ItemGroup ITEMS = FabricItemGroupBuilder.build(new Identifier(RoguelikeRealmsMod.MODID, "items"),
            ()->new ItemStack(RoguelikeRealmsItems.CRYPTON_DUST));

    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.build(new Identifier(RoguelikeRealmsMod.MODID, "blocks"),
            ()->new ItemStack(RoguelikeRealmsBlocks.CRYPTON_BLOCK));

    public static final ItemGroup TOOLS_AND_WEAPONS = FabricItemGroupBuilder.build(new Identifier(RoguelikeRealmsMod.MODID, "tools_and_weapons"),
            ()->new ItemStack(RoguelikeRealmsTools.CRYPTON_AXE));

    public static final ItemGroup ARMOR = FabricItemGroupBuilder.build(new Identifier(RoguelikeRealmsMod.MODID, "armor"),
            ()->new ItemStack(RoguelikeRealmsArmor.CRYPTON_HELMET));

}
