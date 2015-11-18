package com.ckhgame.villagebento.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.init.Items;

public class VillagerTailor extends Villager {

	@Override
	public String getProfessionName() {
		// TODO Auto-generated method stub
		return "Tailor";
	}

	@Override
	public String getProfessionDescription() {
		// TODO Auto-generated method stub
		return "Tailoring.";
	}

	@Override
	public boolean canSpawn() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	@Override
	public void createComponents(ArrayList<VillagerComponent> components) {

        components.add(new VillagerCompAbout());
        
        VillagerCompBuy compBuy = new VillagerCompBuy();

        components.add(compBuy);

	}

	@Override
	public void initVillagerChat(VillagerChat villagerChat) {

		villagerChat.add(0, "Look at this new design...");
		villagerChat.add(0, "Wanna warm clothes?");
		villagerChat.add(0, "How about this one?");
		
	}

	@Override
	public String getSkinName() {
		return "tailor";
	}

}