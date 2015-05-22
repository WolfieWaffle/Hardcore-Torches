package com.github.wolfiewaffle.hardcoretorches.blocks;

import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

import com.github.wolfiewaffle.hardcoretorches.help.Reference;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;

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
	
	@Override
	public void updateTick(World world, int i, int j, int k, Random rand)
	{
		if((world.rand.nextInt(100) == 0 || (world.isRaining() && world.canBlockSeeTheSky(i, j, k))))
		{
			world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			world.setBlock(i, j, k, ModBlocks.torchUnlit, world.getBlockMetadata(i, j, k), 3);
			
			int l = world.getBlockMetadata(i, j, k);
	        double d0 = (double)((float)i + 0.5F);
	        double d1 = (double)((float)j + 0.7F);
	        double d2 = (double)((float)k + 0.5F);
	        double d3 = 0.2199999988079071D;
	        double d4 = 0.27000001072883606D;
	        
			if		(l == 1)
			{
		        for(int c = 1; c < 10+1; c++) {
					world.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);   
		        }
			}
			else if (l == 2)
			{
		        for(int c = 1; c < 10+1; c++) {
		        	world.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		        }
			}
			else if (l == 3)
			{
		        for(int c = 1; c < 10+1; c++) {
		        	world.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
		        }
			}
			else if (l == 4)
			{
		        for(int c = 1; c < 10+1; c++) {
		        	world.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
		        }
			}
			else
			{
		        for(int c = 1; c < 10+1; c++) {
		        	world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		        }
			};
			
			return;
		}
	}
}