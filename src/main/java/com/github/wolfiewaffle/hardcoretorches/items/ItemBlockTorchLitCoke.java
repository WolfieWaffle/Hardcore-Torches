package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLit;

public class ItemBlockTorchLitCoke extends ItemBlock
{
	public ItemBlockTorchLitCoke(Block block) {
		super(block);
		setMaxDamage(BlockTorchLit.MAX_FUEL*2);
		setMaxStackSize(1);
	}
}
