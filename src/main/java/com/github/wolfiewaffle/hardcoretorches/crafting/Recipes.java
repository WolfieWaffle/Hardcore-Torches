package com.github.wolfiewaffle.hardcoretorches.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.init.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init()
	{
		// Shaped
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlit)), "A", "B", 'A', new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlit), 2), "AC", "B ", 'A', new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 'B', "stickWood", 'C', ModItems.animalFat));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlit), 2), "CA", " B", 'A', new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 'B', "stickWood", 'C', ModItems.animalFat));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlitCoke)), "A", "B", 'A', "fuelCoke", 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlitCoke), 2), "AC", "B ", 'A', "fuelCoke", 'B', "stickWood", 'C', ModItems.animalFat));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlitCoke), 2), "CA", " B", 'A', "fuelCoke", 'B', "stickWood", 'C', ModItems.animalFat));

		// Light in inventory
		if (HardcoreTorches.configLightInInventory) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchLit)), new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlit)), new ItemStack(Items.flint)));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchLitCoke)), new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlitCoke)), new ItemStack(Items.flint)));
		}

		// Shapeless
		GameRegistry.addShapelessRecipe(new ItemStack(Items.stick), new ItemStack(Item.getItemFromBlock(ModBlocks.torchBurnt)));
	}
}
