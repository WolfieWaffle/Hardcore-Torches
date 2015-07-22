package com.github.wolfiewaffle.hardcoretorches.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLitCoke;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;

public class TileEntityTorchLitCoke extends TileEntityTorchLit
{
	public static final String publicName = "tileEntityTorchLitCoke";
    @SuppressWarnings("unused")
	private String name = "tileEntityTorchLitCoke";
    private int tickCounter = 0; 
    private int torchFuel = BlockTorchLitCoke.MAX_FUEL_COKE;
    
    @Override
    public void updateEntity() {
		if (worldObj.isRemote){return;}
		tickCounter ++;
		
		if (tickCounter == 20) {
			// Decrement the torch fuel
			torchFuel = torchFuel - 1;
			// Mark that the value has changed
			markDirty();
			
			// If the new fuel value is less than 0, replace the block with a Burnt Torch
			if (torchFuel < 0) {
				System.out.printf("Torch at %d,%d,%d has burnt (fuel %d)\n", xCoord, yCoord, zCoord, torchFuel);
	    		this.worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.torchBurntCoke, worldObj.getBlockMetadata(xCoord, yCoord, zCoord), 3);
	    	}
			
			tickCounter = 0;
		} else {}
    }
}