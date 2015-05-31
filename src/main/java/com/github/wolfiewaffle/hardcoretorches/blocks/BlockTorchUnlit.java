package com.github.wolfiewaffle.hardcoretorches.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.wolfiewaffle.hardcoretorches.help.Reference;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchUnlit;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTorchUnlit extends BlockTorch implements ITileEntityProvider
{
	// The maximum fuel of a Lit Torch
	public static final int MAX_FUEL = 1000;
	
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
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {}
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityTorchUnlit();
    }

	private TileEntityTorchUnlit getTileEntity(World world, int x, int y, int z){
		return (TileEntityTorchUnlit)world.getTileEntity(x, y, z);
	}
	
    @Override
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase player, ItemStack itemstack) {
    	TileEntityTorchUnlit te = getTileEntity(world, i, j, k);
    	int itemMeta = itemstack.getItemDamage();

		// Item damage goes from 0 to 1000, TE fuel value goes from 1000 to 0
		// itemDamage + fuel = MAX_FUEL
    	te.setFuel(MAX_FUEL - itemMeta);
    }
    
    @Override
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest) {
      if(willHarvest) {
        return true;
      }
      return super.removedByPlayer(world, player, x, y, z, willHarvest);
    }
    
    @Override
    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
      super.harvestBlock(world, player, x, y, z, meta);
      world.setBlockToAir(x, y, z);
    }
    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
		TileEntityTorchUnlit te =  getTileEntity(world, x, y, z);
		
		// Item damage goes from 0 to 1000, TE fuel value goes from 1000 to 0
		// itemDamage + fuel = MAX_FUEL
		int itemMeta = MAX_FUEL - te.getFuelAmount();

		ArrayList<ItemStack> drop = new ArrayList<ItemStack>();
		drop.add(new ItemStack(getItemDropped(metadata, world.rand, fortune), quantityDropped(metadata, fortune, world.rand), itemMeta));
		return drop;
    }
    
    //Right click
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float par7, float par8, float par9) {
		//Debug
		if (!world.isRemote) {
			TileEntityTorchUnlit te = getTileEntity(world, x, y, z);
			System.out.printf("Right click. Fuel: %d\n", te.getFuelAmount());
		}
		
		//Light torch
		if (player.inventory.getCurrentItem() != null)
		{
			if (player.inventory.getCurrentItem().getItem() == Items.flint ||
				player.inventory.getCurrentItem().getItem() == Item.getItemFromBlock(ModBlocks.torchLit))
			{
				int l = world.getBlockMetadata(x, y, z);
		        double d0 = (double)((float)x + 0.5F);
		        double d1 = (double)((float)y + 0.7F);
		        double d2 = (double)((float)z + 0.5F);
		        double d3 = 0.2199999988079071D;
		        double d4 = 0.27000001072883606D;
		        
				if		(l == 1)
				{
					world.setBlock(x, y, z, ModBlocks.torchLit, 1, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
						world.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);   
			        }
				}
				else if (l == 2)
				{
					world.setBlock(x, y, z, ModBlocks.torchLit, 2, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
			        }
				}
				else if (l == 3)
				{
					world.setBlock(x, y, z, ModBlocks.torchLit, 3, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
			        }
				}
				else if (l == 4)
				{
					world.setBlock(x, y, z, ModBlocks.torchLit, 4, 3);
					world.playSoundEffect(d0, d1, d2, "fire.ignite", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			        for(int c = 1; c < 10+1; c++) {
			        	world.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
			        }
				}
				else
				{
					world.setBlock(x, y, z, ModBlocks.torchLit, 0, 3);
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