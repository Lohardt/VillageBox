package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.registry.IRegistrable;
import com.ckhgame.villagebento.util.registry.Registry;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class Profession implements IRegistrable {
	
	private int professionID;
	public int getProfessionID(){
		return professionID;
	}
	
	public int getRegID() {
		
		return professionID;
	}

	public void setRegID(int regID) {
		professionID = regID;
	}
	
	//villager entity class
	public Class<? extends EntityVBVillager> getEntityClass(){
		return EntityVBVillager.class;
	}
	
	//gender
	public boolean isMale(){
		return true;
	}
	
	//skin
	private ResourceLocation skinTexture;
	private void setSkin(String skin){
		skinTexture = new ResourceLocation(Main.MODID + ":" + "textures/entity/villager/"+skin+".png");
	}
	public ResourceLocation getSkin(){
		return skinTexture;
	}
		
	//level & exp
	protected int[] expLvls;
	
	protected void setExpBase(){
		expLvls = new int[]{200,300,400,500};
	}
	
	public int getNextLevelExp(int currentLevel){
		if(currentLevel >= 0 && currentLevel <expLvls.length){
			return expLvls[currentLevel];
		}
		else
			return -1;
	}
	
	public boolean isMaxLevel(int currentLevel){
		return (currentLevel >= expLvls.length);
	}
	
	public int expToLevel(int exp){
		return 0;
	}
	
	//villager chat
	private VillagerChat villagerChat = new VillagerChat();
	public VillagerChat getVillagerChat(){
		return villagerChat;
	}
	
	public abstract String getProfessionName();
	public abstract String getProfessionDescription();
	public abstract String getSkinName();
	public abstract boolean canSpawn();
	public abstract void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager);
	protected abstract void initVillagerChat(VillagerChat villagerChat);
	
	public Profession(){
		initVillagerChat(villagerChat);
		setExpBase();
		setSkin(this.getSkinName());
	}
	
	
	//---------------------------------
	public static Registry<Profession> registry = new Registry<Profession>();
}

