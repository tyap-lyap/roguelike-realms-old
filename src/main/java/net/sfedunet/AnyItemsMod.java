package net.sfedunet;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AnyItemsMod implements ModInitializer {
	public static final Item ECHPOCHMAK = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().saturationModifier(10f).hunger(14).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20*5),0.5f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*5),0.5f).build()));
	public static final Item ONION = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().saturationModifier(2f).hunger(1).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 20*10),1f).build()));
	@Override
	public void onInitialize()
	{
		Registry.register(Registry.ITEM, new Identifier("modid", "echpochmak"), ECHPOCHMAK);
		Registry.register(Registry.ITEM, new Identifier("modid", "onion"), ONION);
	}
}
