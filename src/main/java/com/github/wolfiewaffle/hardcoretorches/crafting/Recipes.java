package com.github.wolfiewaffle.hardcoretorches.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{

	public static void init()
	{
		//Shaped
		//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.torchLit)), "A", "B", 'A', Items.coal, 'B', "stickWood"));
		
		//Shapeless
		GameRegistry.addShapelessRecipe(new ItemStack(Items.stick), new ItemStack(Item.getItemFromBlock(ModBlocks.torchBurnt)));
	}
	
	//RecipeRemover.removeAnyRecipe(Blocks.torch);
}
