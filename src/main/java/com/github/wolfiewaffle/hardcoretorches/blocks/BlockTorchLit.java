package com.github.wolfiewaffle.hardcoretorches.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.github.wolfiewaffle.hardcoretorches.help.Reference;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchLit;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTorchLit extends BlockTorch implements ITileEntityProvider
{
	public BlockTorchLit()
	{
		super();
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundTypeStone);
		this.setBlockName("torchLit");
		this.setLightLevel(0.8f);
		this.setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	public void updateTick(World world, int i, int j, int k, Random rand)
	{
		if((world.isRaining() && world.canBlockSeeTheSky(i, j, k)))
		{
	        world.spawnParticle("smoke", i, j, k, 0.5D, 0.7D, 0.5D);
			
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
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
		
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityTorchLit();
    }
    
    public boolean hasTileEntity(int metadata) {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int meta, float par7, float par8, float par9) {
    	TileEntity te = world.getTileEntity(i, j, k);
    	
    	if(te instanceof TileEntityTorchLit) {
    		System.out.println(((TileEntityTorchLit)te).getFuelAmount());
    	}
    	
		return true;
    }
    
    @Override
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase player, ItemStack itemstack) {
    	TileEntity te = world.getTileEntity(i, j, k);
    	int meta = itemstack.getItemDamage();
    	
    	((TileEntityTorchLit)te).setFuel(meta);
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    	return Item.getItemFromBlock(ModBlocks.torchLit);
    }
    
    
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> drop = new ArrayList<ItemStack>();
        
        TileEntity te = world.getTileEntity(x, y, z);
        int count = quantityDropped(metadata, fortune, world.rand);
        for(int i = 0; i < count; i++)
        {
            Item item = getItemDropped(((TileEntityTorchLit)te).getFuelAmount(), world.rand, fortune);
            if (item != null)
            {
                drop.add(new ItemStack(item, 2, ((TileEntityTorchLit)te).getFuelAmount()));
            }
        }
        return drop;
    }
}