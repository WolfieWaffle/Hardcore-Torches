package com.github.wolfiewaffle.hardcoretorches.blocks;

import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.github.wolfiewaffle.hardcoretorches.help.Reference;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
	
	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
		
    }
	
	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int meta, float par7, float par8, float par9)
	{
		if (player.inventory.getCurrentItem() != null)
		{
			if (player.inventory.getCurrentItem().getItem() == Items.flint ||
				player.inventory.getCurrentItem().getItem() == Item.getItemFromBlock(ModBlocks.torchLit))
			{
				int l = world.getBlockMetadata(i, j, k);
		        double d0 = (double)((float)i + 0.5F);
		        double d1 = (double)((float)j + 0.7F);
		        double d2 = (double)((float)k + 0.5F);
		        double d3 = 0.2199999988079071D;
		        double d4 = 0.27000001072883606D;
		        
				if		(l == 1)
				{
					world.setBlock(i, j, k, ModBlocks.torchLit, 1, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
						world.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);   
			        }
				}
				else if (l == 2)
				{
					world.setBlock(i, j, k, ModBlocks.torchLit, 2, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			        }
				}
				else if (l == 3)
				{
					world.setBlock(i, j, k, ModBlocks.torchLit, 3, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
			        }
				}
				else if (l == 4)
				{
					world.setBlock(i, j, k, ModBlocks.torchLit, 4, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
			        }
				}
				else
				{
					world.setBlock(i, j, k, ModBlocks.torchLit, 0, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
			        }
				};
			}
			
			if (player.inventory.getCurrentItem().getItem() == Items.flint && !player.capabilities.isCreativeMode)
			{
				player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}
		}
		return true;
	}
}