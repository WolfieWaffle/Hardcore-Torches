package com.github.wolfiewaffle.equivlentalchemy.blocks;

import net.minecraft.creativetab.CreativeTabs;

import com.github.wolfiewaffle.equivlentalchemy.help.Reference;

public class BlockTorchLit extends ModTorch
{
	public BlockTorchLit()
	{
		super();
		this.setLightLevel(.9375f);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
