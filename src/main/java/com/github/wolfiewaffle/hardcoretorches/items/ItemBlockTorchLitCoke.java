package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLitCoke;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;

public class ItemBlockTorchLitCoke extends ItemBlock
{
	public ItemBlockTorchLitCoke(Block block) {
		super(block);
		setMaxDamage(BlockTorchLitCoke.MAX_FUEL_COKE);
		setMaxStackSize(1);
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
				
				//If the new damage is greater than the max damage, replace the item with a burnt coke torch
				if (getDamage(itemstack) > getMaxDamage(itemstack)){
					itemstack.func_150996_a(Item.getItemFromBlock(ModBlocks.torchBurntCoke));
				}
				itemstack.getTagCompound().setInteger("tickCounter", 0);
			} else {
				itemstack.getTagCompound().setInteger("tickCounter", itemstack.getTagCompound().getInteger("tickCounter") + 1);
			}
		}
	}
}
