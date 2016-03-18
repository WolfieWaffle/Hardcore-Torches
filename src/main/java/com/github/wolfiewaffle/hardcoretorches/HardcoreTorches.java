package com.github.wolfiewaffle.hardcoretorches;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import com.github.wolfiewaffle.hardcoretorches.crafting.RecipeRemover;
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

@Mod(modid = HardcoreTorches.MODID, name = HardcoreTorches.NAME, version = HardcoreTorches.VERSION)
public class HardcoreTorches
{
    public static final String MODID = "hardcoretorches";
    public static final String NAME = "Hardcore Torches";
    public static final String VERSION = "@VERSION@";

    // Config options
	public static int configTorchBurnTime;
	public static int configTorchBurnTimeCoke;
	public static boolean configLightInInventory;
	public static boolean configLightWithTorches;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		configTorchBurnTime = config.getInt("torch burn time", Configuration.CATEGORY_GENERAL, 2400, Integer.MIN_VALUE, Integer.MAX_VALUE, "The burn time of a regular torch in ticks.");
		configTorchBurnTimeCoke = config.getInt("coke torch burn time", Configuration.CATEGORY_GENERAL, 4800, Integer.MIN_VALUE, Integer.MAX_VALUE, "The burn time of a coke torch in ticks. Usually 2x torch burn time.");
		configLightInInventory = config.getBoolean("light in inventory", Configuration.CATEGORY_GENERAL, true, "Can torches be lit inside the inventory/crafting menu?");
		configLightWithTorches = config.getBoolean("light with torches", Configuration.CATEGORY_GENERAL, true, "Can lit torches be used to light other torches?");
		config.save();	
	}

	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		ModItems.init();
		ModBlocks.init();
		proxy.registerTileEntities();
		Recipes.init();
		MinecraftForge.EVENT_BUS.register(new DropHandler());
		RecipeRemover.removeAnyRecipe(Item.getItemFromBlock(Blocks.torch));
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}
