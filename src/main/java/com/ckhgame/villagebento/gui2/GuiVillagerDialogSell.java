package com.ckhgame.villagebento.gui2;

import java.util.ArrayList;
import java.util.List;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerSell;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.village.ItemPrice;
import com.ckhgame.villagebento.villagercomponent.VillagerCompSell;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;

public class GuiVillagerDialogSell extends GuiVillagerDialogGrid{

	private static final int ButtonID_Back = 0;
	
	private static final int ContentID_Sell = 0;
	
	private VillagerCompSell villagerCompSell;
	
	public GuiVillagerDialogSell(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}

	@Override
	public void initDialog() {
		this.villagerCompSell = (VillagerCompSell)this.entityVBVillager.getVillagerComponent(VillagerCompSell.class);
		if(this.villagerCompSell == null){ // the villager doesn't have component sell
			this.hideCenterContent();
			this.setDialogString("Sorry, I have nothing to sell...");
			this.addDialogOptions(ButtonID_Back, 0, "Back");
		}
		else if(!this.entityVBVillager.getProfession().getTimeSchedule().isWorkTimeNow()){ // has component sell but is out of open hours now..
			this.hideCenterContent();
			this.setDialogString("Sorry, It's out of my open hours now...");
			this.addDialogOptions(ButtonID_Back, 0, "Back");
		}
		else{  // send a packet to query the item list, the sell gui will display after receiving
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompSell);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionSyncVillagerComp.class, new Object[]{this.entityVBVillager.getEntityId(),compIdx, Minecraft.getMinecraft().thePlayer.getEntityId(),null});
		}
	}
	
	@Override
	public boolean updateWithVBCompResult(VBCompResult vbCompResult) {
		if(!super.updateWithVBCompResult(vbCompResult)){
			this.setDialogString("What do you want to sell?");
			this.addDialogOptions(ButtonID_Back, 0, "Back");
			this.showCenterContent(ContentID_Sell);
		}
		return false;
	}
	
	@Override
	protected void drawGridCell(int idx, int mx, int my, int x, int y) {
		if(idx < this.villagerCompSell.itemListCurrent.size()){
			ItemStack itemStack = this.villagerCompSell.itemListCurrent.get(idx);
			boolean hover = this.drawItem(mx, my, x + 3, y + 3, itemStack);
			if(hover){
				List texts = new ArrayList();
				texts.add(itemStack.getDisplayName());
				texts.add(ItemPrice.getSellPrice(itemStack.getItem()) + " G");
				this.setMouseHoverTexts(texts);
			}
		}
	}	
	
	@Override
	protected void onGridCellClicked(int idx) {
		if(idx < this.villagerCompSell.itemListCurrent.size()){
			ItemStack itemStack = this.villagerCompSell.itemListCurrent.get(idx);
			System.out.println(itemStack.getDisplayName());
			
			ItemStack itemSell = this.villagerCompSell.itemListCurrent.get(idx).copy();
			itemSell.stackSize = 1;

			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerCompSell);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionDoVillagerSell.class, new Object[]{	this.entityVBVillager.getEntityId(),
																		compIdx, 
																		Minecraft.getMinecraft().thePlayer.getEntityId(),
																		new Object[]{itemSell}});
		}
	}

	@Override
	protected void drawCenterContent(int centerContentID, int mx, int my, float f) {
		super.drawCenterContent(centerContentID, mx, my, f);
		if(centerContentID == ContentID_Sell){
			this.drawCenteredString(this.fontRendererObj, "Sell items to " + this.entityVBVillager.getName(), this.boundCenterContent.getIntCenterX(),this.boundCenterContent.getIntY() + 8, 0xFFFFFF00);
			this.drawGrid(mx, my);
		}
	}

	@Override
	protected void actionPerformed(GuiButton guiButton) {
		super.actionPerformed(guiButton);
		
		switch(guiButton.id){
		case ButtonID_Back:
			this.mc.displayGuiScreen(new GuiVillagerDialogMenu(this.entityVBVillager));
			break;
		}
	}

	@Override
	protected void mouseClicked(int mx, int my, int button) {
		super.mouseClicked(mx, my, button);
		
		if(button == 1){ // right click
			this.gridCellMouseClick(mx, my);
		}
		
	}
	
}
