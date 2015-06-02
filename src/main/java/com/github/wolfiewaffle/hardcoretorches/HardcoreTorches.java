package com.github.wolfiewaffle.hardcoretorches;

import net.minecraftforge.common.MinecraftForge;

import com.github.wolfiewaffle.hardcoretorches.crafting.Recipes;
import com.github.wolfiewaffle.hardcoretorches.handlers.DropHandler;
import com.github.wolfiewaffle.hardcoretorches.help.Reference;
import com.github.wolfiewaffle.hardcoretorches.init.ModBlocks;
import com.github.wolfiewaffle.hardcoretorches.init.ModItems;
import com.github.wolfiewaffle.hardcoretorches.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class HardcoreTorches
{
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModItems.init();
		ModBlocks.init();
		proxy.registerTileEntities();
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		Recipes.init();
		MinecraftForge.EVENT_BUS.register(new DropHandler());
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
