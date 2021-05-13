package net.sfedunet.item.base;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Language;
import net.minecraft.world.World;
import net.sfedunet.RoguelikeRealmsMod;
import net.sfedunet.item.RoguelikeRealmsItemGroups;

import java.util.List;

public class BaseArmorItem extends ArmorItem {

    private final String fullSetEffect;

    public BaseArmorItem(ArmorMaterial material, EquipmentSlot slot, String fullSetEffect) {
        super(material, slot, new FabricItemSettings().group(RoguelikeRealmsItemGroups.ARMOR));

        this.fullSetEffect = fullSetEffect;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        if(!this.fullSetEffect.equals("none")){
            String full_set_effect = Language.getInstance().get("tooltip." + RoguelikeRealmsMod.MODID + ".full_set_effect");

            String effect = Language.getInstance().get("tooltip." + RoguelikeRealmsMod.MODID + "." + fullSetEffect);

            tooltip.add(new LiteralText(full_set_effect + effect));
        }
    }



}
