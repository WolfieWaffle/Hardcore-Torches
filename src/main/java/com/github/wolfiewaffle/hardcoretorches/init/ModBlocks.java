package com.github.wolfiewaffle.hardcoretorches.init;

import net.minecraft.block.Block;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLit;
import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchUnlit;
import com.github.wolfiewaffle.hardcoretorches.help.RegisterHelper;

public class ModBlocks
{
	public static Block torchLit  = new BlockTorchLit();
	public static Block torchUnlit  = new BlockTorchUnlit();
	public static void init()
	{
		RegisterHelper.registerBlock(torchLit);
		RegisterHelper.registerBlock(torchUnlit);
	}
}
