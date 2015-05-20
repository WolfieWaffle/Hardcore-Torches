package com.github.wolfiewaffle.equivlentalchemy;

import com.github.wolfiewaffle.equivlentalchemy.crafting.Recipes;
import com.github.wolfiewaffle.equivlentalchemy.help.Reference;
import com.github.wolfiewaffle.equivlentalchemy.init.ModBlocks;
import com.github.wolfiewaffle.equivlentalchemy.init.ModItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class EquivlentAlchemy
{
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModItems.init();
		ModBlocks.init();
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		Recipes.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
