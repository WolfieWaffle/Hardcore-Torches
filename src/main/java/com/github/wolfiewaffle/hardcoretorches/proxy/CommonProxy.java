package com.github.wolfiewaffle.hardcoretorches.proxy;

import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchLit;
import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchLitCoke;
import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchUnlit;
import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchUnlitCoke;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{
	public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityTorchLit.class, TileEntityTorchLit.publicName);
        GameRegistry.registerTileEntity(TileEntityTorchUnlit.class, TileEntityTorchUnlit.publicName);
        GameRegistry.registerTileEntity(TileEntityTorchLitCoke.class, TileEntityTorchLitCoke.publicName);
        GameRegistry.registerTileEntity(TileEntityTorchUnlitCoke.class, TileEntityTorchUnlitCoke.publicName);
    }
}
