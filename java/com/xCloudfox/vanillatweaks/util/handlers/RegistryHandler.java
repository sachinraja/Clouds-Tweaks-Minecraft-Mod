package com.xCloudfox.vanillatweaks.util.handlers;

import com.xCloudfox.vanillatweaks.Main;
import com.xCloudfox.vanillatweaks.blocks.animation.RenderDiamondChest;
import com.xCloudfox.vanillatweaks.blocks.tileentities.TileEntityDiamondChest;
import com.xCloudfox.vanillatweaks.init.ModBlocks;
import com.xCloudfox.vanillatweaks.init.ModItems;
import com.xCloudfox.vanillatweaks.util.interfaces.IHasModel;
import com.xCloudfox.vanillatweaks.world.gen.WorldGenCustomStructures;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDiamondChest.class, new RenderDiamondChest());
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(ModBlocks.DIAMOND_CHEST), 0, null);
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel) 
			{
				((IHasModel)item).registerModels();
			}
		}
	}
	
	public static void preInitRegistries()
	{
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
	}
	
	public static void initRegistries()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}
}
