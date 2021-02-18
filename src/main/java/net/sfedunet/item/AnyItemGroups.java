package net.sfedunet.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.block.AnyItemsBlocks;
import net.sfedunet.item.armor.AnyItemsArmor;
import net.sfedunet.item.tools.AnyItemsTools;

public class AnyItemGroups {

    public static final ItemGroup ITEMS = FabricItemGroupBuilder.build(new Identifier(AnyItemsMod.MODID, "items"),
            ()->new ItemStack(AnyItemsItems.DRAGON_FIRE));

    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.build(new Identifier(AnyItemsMod.MODID, "blocks"),
            ()->new ItemStack(AnyItemsBlocks.CRYPTON_BLOCK));

    public static final ItemGroup TOOLS_AND_WEAPONS = FabricItemGroupBuilder.build(new Identifier(AnyItemsMod.MODID, "tools_and_weapons"),
            ()->new ItemStack(AnyItemsTools.DRAGON_PICKAXE));

    public static final ItemGroup ARMOR = FabricItemGroupBuilder.build(new Identifier(AnyItemsMod.MODID, "armor"),
            ()->new ItemStack(AnyItemsArmor.CRYPTON_HELMET));

}
