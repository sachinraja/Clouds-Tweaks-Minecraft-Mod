package com.xCloudfox.vanillatweaks.util.handlers;

import com.xCloudfox.vanillatweaks.blocks.containers.ContainerDiamondChest;
import com.xCloudfox.vanillatweaks.blocks.guis.GuiDiamondChest;
import com.xCloudfox.vanillatweaks.blocks.tileentities.TileEntityDiamondChest;
import com.xCloudfox.vanillatweaks.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == Reference.GUI_DIAMOND_CHEST) return new ContainerDiamondChest(player.inventory, (TileEntityDiamondChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		return null;
	}
	
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == Reference.GUI_DIAMOND_CHEST) return new GuiDiamondChest(player.inventory, (TileEntityDiamondChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		return null;
	}
	
	public static void registerGUIs()
	{
		
	}
}
