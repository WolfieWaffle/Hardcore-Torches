package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

import com.github.wolfiewaffle.hardcoretorches.blocks.BlockTorchUnlit;

public class ItemBlockTorchUnlit extends ItemBlock
{
	public ItemBlockTorchUnlit(Block block) {
		super(block);
		setMaxDamage(BlockTorchUnlit.MAX_FUEL);
	}
	
	/*@Override
	public void onUpdate(ItemStack itemstack, World world, Entity player, int p0, boolean p1) {
		// Increment the damage
		//setDamage(itemstack, getDamage(itemstack) + 1);
		
		// If the new damage is greater than the max damage, replace the item with a Burnt Torch
		if (getDamage(itemstack) > getMaxDamage(itemstack)){
			itemstack.func_150996_a(Item.getItemFromBlock(ModBlocks.torchBurnt));
		}
	}*/
}
