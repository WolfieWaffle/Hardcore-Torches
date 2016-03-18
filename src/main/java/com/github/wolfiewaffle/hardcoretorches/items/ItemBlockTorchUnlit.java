package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;

public class ItemBlockTorchUnlit extends ItemBlock {
	public ItemBlockTorchUnlit(Block block) {
		super(block);
		setMaxDamage(HardcoreTorches.configTorchBurnTime);
	}
}
