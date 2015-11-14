package com.github.wolfiewaffle.hardcoretorches.blocks;

import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.wolfiewaffle.hardcoretorches.help.Reference;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchLitCoke;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTorchBurntCoke extends BlockTorch
{
	// The maximum fuel of a Lit Torch
	public static final int MAX_FUEL_COKE = BlockTorchLitCoke.MAX_FUEL_COKE;
	
	public BlockTorchBurntCoke()
	{
		super();
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName("torchBurntCoke");
		this.setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		this.setTickRandomly(false);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
		
    }
	
    //Right click
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float par7, float par8, float par9) {
		//Light torch
		if (player.inventory.getCurrentItem() != null)
		{
			if (player.inventory.getCurrentItem().getItem() == Item.getItemFromBlock(ModBlocks.torchLitCoke))
			{
				ItemStack stack = player.inventory.getStackInSlot(player.inventory.currentItem);
				int l = world.getBlockMetadata(x, y, z);
				int oldFuel = stack.getItemDamage();
		        double d0 = (double)((float)x + 0.5F);
		        double d1 = (double)((float)y + 0.7F);
		        double d2 = (double)((float)z + 0.5F);
		        double d3 = 0.2199999988079071D;
		        double d4 = 0.27000001072883606D;
		        
				if (l == 1)
				{
					world.setBlock(x, y, z, ModBlocks.torchLitCoke, l, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
						world.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);   
			        }
			        TileEntity te2 = (TileEntityTorchLitCoke)world.getTileEntity(x, y, z);
			        ((TileEntityTorchLitCoke)te2).setFuel(MAX_FUEL_COKE - oldFuel);
				}
				else if (l == 2)
				{
					world.setBlock(x, y, z, ModBlocks.torchLitCoke, l, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			        }
			        TileEntity te2 = (TileEntityTorchLitCoke)world.getTileEntity(x, y, z);
			        ((TileEntityTorchLitCoke)te2).setFuel(MAX_FUEL_COKE - oldFuel);
				}
				else if (l == 3)
				{
					world.setBlock(x, y, z, ModBlocks.torchLitCoke, l, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
			        }
			        TileEntity te2 = (TileEntityTorchLitCoke)world.getTileEntity(x, y, z);
			        ((TileEntityTorchLitCoke)te2).setFuel(MAX_FUEL_COKE - oldFuel);
				}
				else if (l == 4)
				{
					world.setBlock(x, y, z, ModBlocks.torchLitCoke, l, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
			        }
			        TileEntity te2 = (TileEntityTorchLitCoke)world.getTileEntity(x, y, z);
			        ((TileEntityTorchLitCoke)te2).setFuel(MAX_FUEL_COKE - oldFuel);
				}
				else
				{
					world.setBlock(x, y, z, ModBlocks.torchLitCoke, l, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
			        }
			        TileEntity te2 = (TileEntityTorchLitCoke)world.getTileEntity(x, y, z);
			        ((TileEntityTorchLitCoke)te2).setFuel(MAX_FUEL_COKE - oldFuel);
				}
				
				if (player.inventory.getCurrentItem().getItem() == Item.getItemFromBlock(ModBlocks.torchLitCoke))
				{
					player.inventory.decrStackSize(player.inventory.currentItem, 1);
				}
			}
		}
		return true;
	}
	
	//Don't drop anything
    public int quantityDropped(Random p_149745_1_) {
        return 0;
    }
}