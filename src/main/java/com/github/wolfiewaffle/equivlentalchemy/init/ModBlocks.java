package com.github.wolfiewaffle.equivlentalchemy.init;

import net.minecraft.block.Block;

import com.github.wolfiewaffle.equivlentalchemy.blocks.BlockTorchLit;
import com.github.wolfiewaffle.equivlentalchemy.blocks.ModTorch;
import com.github.wolfiewaffle.equivlentalchemy.help.RegisterHelper;

public class ModBlocks
{
	public static Block modTorch  = new ModTorch();
	//public static Block torchLit  = new BlockTorchLit();
	public static void init()
	{
		RegisterHelper.registerBlock(modTorch);
		//RegisterHelper.registerBlock(torchLit);
	}
}
