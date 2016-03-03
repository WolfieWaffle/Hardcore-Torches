package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLit;

public class ItemBlockTorchLit extends ItemBlock
{
	public ItemBlockTorchLit(Block block) {
		super(block);
		setMaxDamage(BlockTorchLit.MAX_FUEL);
		setMaxStackSize(1);
	}
}
