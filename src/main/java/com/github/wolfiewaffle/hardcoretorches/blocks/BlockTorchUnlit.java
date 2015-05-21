package com.github.wolfiewaffle.hardcoretorches.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;

import com.github.wolfiewaffle.hardcoretorches.help.Reference;

public class BlockTorchUnlit extends BlockTorch
{
	public BlockTorchUnlit()
	{
		super();
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName("torchUnlit");
		this.setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
}