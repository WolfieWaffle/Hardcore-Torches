package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchUnlit;

public class ItemBlockTorchUnlitCoke extends ItemBlock {
	public ItemBlockTorchUnlitCoke(Block block) {
		super(block);
		setMaxDamage(BlockTorchUnlit.MAX_FUEL);
	}
}
