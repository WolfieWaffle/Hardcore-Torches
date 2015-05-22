package com.github.wolfiewaffle.hardcoretorches.blocks;

import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

import com.github.wolfiewaffle.hardcoretorches.help.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTorchBurnt extends BlockTorch
{
	public BlockTorchBurnt()
	{
		super();
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName("torchBurnt");
		this.setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		this.setTickRandomly(false);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
		
    }
}