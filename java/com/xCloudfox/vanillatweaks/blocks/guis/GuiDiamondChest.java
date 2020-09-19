package com.xCloudfox.vanillatweaks.blocks.guis;

import com.xCloudfox.vanillatweaks.blocks.containers.ContainerDiamondChest;
import com.xCloudfox.vanillatweaks.blocks.tileentities.TileEntityDiamondChest;
import com.xCloudfox.vanillatweaks.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiDiamondChest extends GuiContainer
{
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MOD_ID + ":textures/gui/diamond_chest.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityDiamondChest te;
	
	public GuiDiamondChest(InventoryPlayer playerInventory, TileEntityDiamondChest chestInventory, EntityPlayer player) 
	{
		super(new ContainerDiamondChest(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.xSize = 179;
		this.ySize = 256;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 16639);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 16639);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
