package com.github.wolfiewaffle.equivlentalchemy.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;

public class ModTorch extends BlockTorch
{
	public ModTorch()
	{
		super();
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
