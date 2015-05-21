package com.github.wolfiewaffle.hardcoretorches.init;

import net.minecraft.item.Item;

import com.github.wolfiewaffle.hardcoretorches.help.RegisterHelper;
import com.github.wolfiewaffle.hardcoretorches.items.EquivlentAlchemyItem;

public class ModItems
{
	public static Item philosophersStone = new EquivlentAlchemyItem().setUnlocalizedName("philosophersStone");
	public static void init()
	{
		RegisterHelper.registerItem(philosophersStone);
	}
}
