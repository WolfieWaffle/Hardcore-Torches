package com.github.wolfiewaffle.hardcoretorches.handlers;

import java.util.Random;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import com.github.wolfiewaffle.hardcoretorches.init.ModItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class DropHandler {
	public static double rand;
	public Random r = new Random();
	
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		if       (event.entityLiving instanceof EntityCow && r.nextInt(100) <= 25) {
			event.entityLiving.dropItem(ModItems.animalFat, 1);
		} else if(event.entityLiving instanceof EntitySheep && r.nextInt(100) <= 30) {
			event.entityLiving.dropItem(ModItems.animalFat, 1);
		} else if(event.entityLiving instanceof EntityPig && r.nextInt(100) <= 45) {
			
		} else {};
				
	}
}