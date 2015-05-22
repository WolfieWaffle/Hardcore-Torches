package com.github.wolfiewaffle.hardcoretorches.init;

import net.minecraft.item.Item;

import com.github.wolfiewaffle.hardcoretorches.help.RegisterHelper;
import com.github.wolfiewaffle.hardcoretorches.items.ItemAnimalFat;

public class ModItems
{
	public static Item itemHardcoreTorches = new ItemAnimalFat().setUnlocalizedName("itemHardcoreTorches");
	public static Item animalFat = new ItemAnimalFat().setUnlocalizedName("animalFat");
	public static void init()
	{
		RegisterHelper.registerItem(itemHardcoreTorches);
		RegisterHelper.registerItem(animalFat);
	}
}
