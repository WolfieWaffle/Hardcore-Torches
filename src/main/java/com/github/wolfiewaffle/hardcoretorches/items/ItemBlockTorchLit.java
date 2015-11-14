package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLit;

public class ItemBlockTorchLit extends ItemBlock
{
	public ItemBlockTorchLit(Block block) {
		super(block);
		setMaxDamage(BlockTorchLit.MAX_FUEL);
		setMaxStackSize(1);
	}
	
	/*public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
	    itemstack.stackTagCompound = new NBTTagCompound();
	    itemstack.stackTagCompound.setInteger("tickCounter", 0);
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity player, int p0, boolean p1) {
		if (!itemstack.hasTagCompound()) {
			itemstack.setTagCompound(new NBTTagCompound());
			itemstack.stackTagCompound.setInteger("tickCounter", 0);
		} else {
			if (itemstack.getTagCompound().getInteger("tickCounter") >= 20) {
				//Increment the damage
				setDamage(itemstack, getDamage(itemstack) + 1);
				
				//If the new damage is greater than the max damage, replace the item with a burnt torch
				if (getDamage(itemstack) > getMaxDamage(itemstack)){
					itemstack.func_150996_a(Item.getItemFromBlock(ModBlocks.torchBurnt));
				}
				itemstack.getTagCompound().setInteger("tickCounter", 0);
			} else {
				itemstack.getTagCompound().setInteger("tickCounter", itemstack.getTagCompound().getInteger("tickCounter") + 1);
			}
		}
	}*/
}
