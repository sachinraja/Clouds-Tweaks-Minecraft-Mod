package com.xCloudfox.vanillatweaks.util.handlers;

import com.xCloudfox.vanillatweaks.blocks.tileentities.TileEntityDiamondChest;
import com.xCloudfox.vanillatweaks.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityDiamondChest.class, new ResourceLocation(Reference.MOD_ID + ":diamond_chest"));
	}
}
