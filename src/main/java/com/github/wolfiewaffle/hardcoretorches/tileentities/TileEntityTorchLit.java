package com.github.wolfiewaffle.hardcoretorches.tileentities;

import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.items.ItemBlockTorchLit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityTorchLit extends TileEntity 
{
	public static final String publicName = "tileEntityTorchLit";
    private String name = "tileEntityTorchLit";
    
    public String getName() {
    	return name;
    }
    
    private int torchFuel;
    
    public int getFuelAmount() {
		return this.torchFuel;
	}
    
    @Override
    public void writeToNBT(NBTTagCompound par1) {
       super.writeToNBT(par1);
       par1.setInteger("torchFuelNBT", getFuelAmount());
    }
    
    @Override
    public void readFromNBT(NBTTagCompound par1) {
       super.readFromNBT(par1);
       this.torchFuel = par1.getInteger("torchfuelNBT");
    }
    
    @Override
    public void updateEntity() {
		int i = this.xCoord;
		int j = this.yCoord;
		int k = this.zCoord;
		World world = this.worldObj;
		
		if (torchFuel < ItemBlockTorchLit.getTorchMaxDamage()) {
			torchFuel = torchFuel + 1;
		}
		else if (torchFuel == ItemBlockTorchLit.getTorchMaxDamage()) {
    		this.worldObj.setBlock(i, j, k, ModBlocks.torchBurnt, world.getBlockMetadata(i, j, k), 3);
    	}
    	
    	System.out.println(/*"fuel: " + */torchFuel/* + " xyz: " + i + " " + j + " " + k*/);
    }

	public void setFuel(int f) {
		this.torchFuel = f;
	}
}