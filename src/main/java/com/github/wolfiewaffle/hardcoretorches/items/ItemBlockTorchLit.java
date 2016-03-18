package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;

public class ItemBlockTorchLit extends ItemBlock
{
	public ItemBlockTorchLit(Block block) {
		super(block);
		setMaxDamage(HardcoreTorches.configTorchBurnTime);
		setMaxStackSize(1);
	}
}
