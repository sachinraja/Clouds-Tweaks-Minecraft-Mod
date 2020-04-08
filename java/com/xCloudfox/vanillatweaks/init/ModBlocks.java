package com.xCloudfox.vanillatweaks.init;

import java.util.ArrayList;
import java.util.List;

import com.xCloudfox.vanillatweaks.blocks.BlockBase;
import com.xCloudfox.vanillatweaks.blocks.BlockDiamondChest;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block DIAMOND_CHEST = new BlockDiamondChest("diamond_chest", Material.IRON);
}
