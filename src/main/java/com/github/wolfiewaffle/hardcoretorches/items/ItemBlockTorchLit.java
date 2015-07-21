package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchLit;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;

public class ItemBlockTorchLit extends ItemBlock
{
	public ItemBlockTorchLit(Block block) {
		super(block);
		setMaxDamage(BlockTorchLit.MAX_FUEL);
		setMaxStackSize(1);
	}
	
	private int tickCounter = 0;
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity player, int p0, boolean p1) {
		if (!world.isRemote) {
			tickCounter ++;
			
			if (tickCounter == 20) {
				// Increment the damage
				setDamage(itemstack, getDamage(itemstack) + 1);
				
				// If the new damage is greater than the max damage, replace the item with a Burnt Torch
				if (getDamage(itemstack) > getMaxDamage(itemstack)){
					itemstack.func_150996_a(Item.getItemFromBlock(ModBlocks.torchBurnt));
				}
				tickCounter = 0;
			}
		}
	}
}
