package com.github.wolfiewaffle.hardcoretorches.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.wolfiewaffle.hardcoretorches.HardcoreTorches;
import com.github.wolfiewaffle.hardcoretorches.help.Reference;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchLitCoke;
import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchUnlitCoke;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTorchLitCoke extends BlockTorchLit implements ITileEntityProvider
{
	public static final int MAX_FUEL = HardcoreTorches.configTorchBurnTimeCoke;

	public BlockTorchLitCoke() {
		super();
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setStepSound(soundTypeStone);
		this.setBlockName("torchLitCoke");
		this.setLightLevel(0.8f);
		this.setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}

	//Particles and burning out
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		int meta = world.getBlockMetadata(x, y, z);
        double d0 = (double)((float)x + 0.5F);
        double d1 = (double)((float)y + 0.7F);
        double d2 = (double)((float)z + 0.5F);
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;
        int oldFuel = ((TileEntityTorchLitCoke)world.getTileEntity(x, y, z)).getFuelAmount();
		
        //Particles
        if (meta == 1)
        {
            world.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (meta == 2)
        {
            world.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
        }
        else if (meta == 3)
        {
            world.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
        }
        else if (meta == 4)
        {
            world.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
        }
        else
        {
            world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
        
        //Rain extinguishing
		if((world.isRaining() && world.canBlockSeeTheSky(x, y, z))) {
	        
	        //Set world block
			world.setBlock(x, y, z, ModBlocks.torchUnlitCoke, meta, 3);
			world.playSoundEffect(d0, d1, d2, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
			
			//Set the fuel value
	        TileEntity te2 = (TileEntityTorchUnlitCoke)world.getTileEntity(x, y, z);
	        ((TileEntityTorchUnlitCoke)te2).setFuel(oldFuel);
	        
	        //Not working
			if (meta == 1) {
		        for(int c = 1; c < 10+1; c++) {
					world.spawnParticle("smoke", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);   
		        }
			}
			else if (meta == 2) {
		        for(int c = 1; c < 10+1; c++) {
		        	world.spawnParticle("smoke", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
		        }
			}
			else if (meta == 3) {
		        for(int c = 1; c < 10+1; c++) {
		        	world.spawnParticle("smoke", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
		        }
			}
			else if (meta == 4) {
		        for(int c = 1; c < 10+1; c++) {
		        	world.spawnParticle("smoke", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
		        }
			}
			else {
		        for(int c = 1; c < 10+1; c++) {
		        	world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		        }
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityTorchLitCoke();
    }

	private TileEntityTorchLitCoke getTileEntity(World world, int x, int y, int z){
		return (TileEntityTorchLitCoke) world.getTileEntity(x, y, z);
	}

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TileEntityTorchLitCoke te = getTileEntity(world, x, y, z);
			System.out.printf("Right click. Fuel: %d\n", te.getFuelAmount());
		}

		if (player.inventory.getCurrentItem() != null)
		{
			// Light a held torch
			if ((player.inventory.getCurrentItem().getItem() == Item.getItemFromBlock(ModBlocks.torchUnlit) ||
				player.inventory.getCurrentItem().getItem() == Item.getItemFromBlock(ModBlocks.torchUnlitCoke)) &&
				HardcoreTorches.configLightInInventory) {
				lightHeldTorch(player);
			}
		}
		return true;
    }

    @Override
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase player, ItemStack itemstack) {
    	TileEntityTorchLitCoke te = getTileEntity(world, i, j, k);
    	int itemMeta = itemstack.getItemDamage();

		//Item damage goes from 0 to 1000, TE fuel value goes from 1000 to 0
		//itemDamage + fuel = MAX_FUEL
    	te.setFuel(MAX_FUEL - itemMeta);
    }

	// I forgot what this is for...
	@Override
	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest) {
		if (willHarvest) {
			return true;
		}
		return super.removedByPlayer(world, player, x, y, z, willHarvest);
	}

	// Harvest method, needs to be modified for some reason I forgot
	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
		super.harvestBlock(world, player, x, y, z, meta);
		world.setBlockToAir(x, y, z);
	}

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
    	TileEntityTorchLitCoke te =  getTileEntity(world, x, y, z);
		
		//Item damage goes from 0 to 1000, TE fuel value goes from 1000 to 0
		//itemDamage + fuel = MAX_FUEL_COKE
		int itemMeta = MAX_FUEL - te.getFuelAmount();
		
		ArrayList<ItemStack> drop = new ArrayList<ItemStack>();
		drop.add(new ItemStack(ModBlocks.torchUnlitCoke, quantityDropped(metadata, fortune, world.rand), itemMeta));
		return drop;
    }
}