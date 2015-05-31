package com.github.wolfiewaffle.hardcoretorches.proxy;

import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchLit;
import com.github.wolfiewaffle.hardcoretorches.tileentities.TileEntityTorchUnlit;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{
	public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityTorchLit.class, TileEntityTorchLit.publicName);
        GameRegistry.registerTileEntity(TileEntityTorchUnlit.class, TileEntityTorchUnlit.publicName);
    }
}
