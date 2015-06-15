package com.github.wolfiewaffle.hardcoretorches.init;

import net.minecraft.block.Block;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchBurnt;
import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLit;
import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchUnlit;
import com.github.wolfiewaffle.hardcoretorches.items.ItemBlockTorchLit;
import com.github.wolfiewaffle.hardcoretorches.items.ItemBlockTorchUnlit;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static Block torchLit  = new BlockTorchLit();
	public static Block torchUnlit  = new BlockTorchUnlit();
	public static Block torchBurnt  = new BlockTorchBurnt();
	public static void init()
	{
		GameRegistry.registerBlock(torchLit, ItemBlockTorchLit.class, torchLit.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(torchUnlit, ItemBlockTorchUnlit.class, torchUnlit.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(torchBurnt, torchBurnt.getUnlocalizedName().substring(5));
	}
}
