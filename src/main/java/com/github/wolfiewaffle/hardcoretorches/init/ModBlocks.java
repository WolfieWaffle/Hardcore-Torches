package com.github.wolfiewaffle.hardcoretorches.init;

import net.minecraft.block.Block;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchBurnt;
import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchBurntCoke;
import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLit;
import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLitCoke;
import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchUnlit;
import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchUnlitCoke;
import com.github.wolfiewaffle.hardcoretorches.items.ItemBlockTorchLit;
import com.github.wolfiewaffle.hardcoretorches.items.ItemBlockTorchLitCoke;
import com.github.wolfiewaffle.hardcoretorches.items.ItemBlockTorchUnlit;
import com.github.wolfiewaffle.hardcoretorches.items.ItemBlockTorchUnlitCoke;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static Block torchLit  = new BlockTorchLit();
	public static Block torchLitCoke  = new BlockTorchLitCoke();
	public static Block torchUnlit  = new BlockTorchUnlit();
	public static Block torchUnlitCoke  = new BlockTorchUnlitCoke();
	public static Block torchBurnt  = new BlockTorchBurnt();
	public static Block torchBurntCoke  = new BlockTorchBurntCoke();
	public static void init()
	{
		GameRegistry.registerBlock(torchLit, ItemBlockTorchLit.class, torchLit.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(torchLitCoke, ItemBlockTorchLitCoke.class, torchLitCoke.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(torchUnlit, ItemBlockTorchUnlit.class, torchUnlit.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(torchUnlitCoke, ItemBlockTorchUnlitCoke.class, torchUnlitCoke.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(torchBurnt, torchBurnt.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(torchBurntCoke, torchBurntCoke.getUnlocalizedName().substring(5));
	}
}
