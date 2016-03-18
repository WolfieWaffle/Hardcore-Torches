package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;

public class ItemBlockTorchLitCoke extends ItemBlockTorchLit
{
	public ItemBlockTorchLitCoke(Block block) {
		super(block);
		setMaxDamage(HardcoreTorches.configTorchBurnTimeCoke);
		setMaxStackSize(1);
	}
}
