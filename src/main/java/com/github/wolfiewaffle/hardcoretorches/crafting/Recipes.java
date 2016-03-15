package com.github.wolfiewaffle.hardcoretorches.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.init.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init()
	{
		//Shaped
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlit)), "A", "B", 'A', new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlit), 2), "AC", "B ", 'A', new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 'B', "stickWood", 'C', ModItems.animalFat));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlit), 2), "CA", " B", 'A', new ItemStack(Items.coal, 1, OreDictionary.WILDCARD_VALUE), 'B', "stickWood", 'C', ModItems.animalFat));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlitCoke)), "A", "B", 'A', "fuelCoke", 'B', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlitCoke), 2), "AC", "B ", 'A', "fuelCoke", 'B', "stickWood", 'C', ModItems.animalFat));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchUnlitCoke), 2), "CA", " B", 'A', "fuelCoke", 'B', "stickWood", 'C', ModItems.animalFat));

		//Shapeless
		GameRegistry.addShapelessRecipe(new ItemStack(Items.stick), new ItemStack(Item.getItemFromBlock(ModBlocks.torchBurnt)));
	}
}
