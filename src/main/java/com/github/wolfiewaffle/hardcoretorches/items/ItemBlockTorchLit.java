package com.github.wolfiewaffle.hardcoretorches.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;

public class ItemBlockTorchLit extends ItemBlock
{
	private static int maxDamage = 1000;
	
	public static int getTorchMaxDamage() {
		return maxDamage;
	}
	
	public ItemBlockTorchLit(Block block) {
		super(block);
		this.setMaxDamage(maxDamage);
	}
	
	public void onUpdate(ItemStack itemstack, World world, Entity player, int p0, boolean p1) {
		int damage = getDamage(itemstack);
		int maxdamage = getMaxDamage(itemstack);
		if (damage < maxdamage) {
			setDamage(itemstack, (damage += 1));
		} else if (damage == maxdamage) {
			itemstack.func_150996_a(getItemFromBlock(ModBlocks.torchBurnt));
		};
	}
}
