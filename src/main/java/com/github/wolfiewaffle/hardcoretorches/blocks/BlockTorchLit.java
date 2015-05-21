package com.github.wolfiewaffle.hardcoretorches.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;

import com.github.wolfiewaffle.hardcoretorches.help.Reference;

public class BlockTorchLit extends BlockTorch
{
	public BlockTorchLit()
	{
		super();
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName("torchLit");
		this.setLightLevel(0.8f);
		this.setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
}