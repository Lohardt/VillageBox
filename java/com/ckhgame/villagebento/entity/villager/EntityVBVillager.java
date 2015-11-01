package com.ckhgame.villagebento.entity.villager;

import java.util.ArrayList;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.gui.GuiVillagerChat;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompAbout;
import com.ckhgame.villagebento.villager.component.VillagerCompChat;
import com.ckhgame.villagebento.villager.component.VillagerCompTrade;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPlay;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityVBVillager extends EntityAgeable{

	private int dataVillagerID;
	private String name;
	private String skin;
	private int profession;
	private ArrayList<VillagerComponent> components;
	
	public String getName(){
		return name;
	}
	
	public int getProfession(){
		return profession;
	}
	
	public void setVillagerComponents(ArrayList<VillagerComponent> components){
		this.components = components;
		for(VillagerComponent c : this.components){
			c.getGui().setEntityVillager(this);
		}
	}
	
	public ArrayList<VillagerComponent> getVillagerComponents(){
		return this.components;
	}
	
	public void setVillagerData(DataVillager dv){
		this.dataVillagerID = dv.id;
		this.name = dv.name;
		this.skin = dv.skin;
		this.profession = dv.profession;
	}
	
	public EntityVBVillager(World p_i1578_1_) {
		super(p_i1578_1_);

		this.setSize(0.6F, 1.8F);
		this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityVillager.class, 5.0F, 0.02F));
        this.tasks.addTask(9, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
	}

	@Override
	public EntityVBVillager createChild(EntityAgeable p_90011_1_) {
		EntityVBVillager entityvillager = new EntityVBVillager(this.worldObj);
        entityvillager.onSpawnWithEgg((IEntityLivingData)null);
        return entityvillager;
	}
	
    public boolean interact(EntityPlayer p_70085_1_)
    {
    	if(!this.worldObj.isRemote){
    		
    		//guiChat.setChat(name, "Nice to meet you! Nice to meet you! Nice to meet you! Nice to meet you! Nice to meet you!");
    		if(components != null && components.size() > 0){
    			Minecraft.getMinecraft().displayGuiScreen(components.get(0).getGui());
    		}   		
    		
    		System.out.println("Hi! My name is " + name);
    	}
        return true;
    }

    
    
	@Override
	public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		// TODO Auto-generated method stub
		super.writeEntityToNBT(p_70014_1_);
		p_70014_1_.setInteger(ConfigData.KeyVillagerEntityDataVillagerID, dataVillagerID);
		p_70014_1_.setString(ConfigData.KeyVillagerEntityName, name);
		p_70014_1_.setString(ConfigData.KeyVillagerEntitySkin, skin);
		p_70014_1_.setInteger(ConfigData.KeyVillagerEntityProfession, profession);
		
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		// TODO Auto-generated method stub
		super.readEntityFromNBT(p_70037_1_);
		
		dataVillagerID = p_70037_1_.getInteger(ConfigData.KeyVillagerEntityDataVillagerID);
		name = p_70037_1_.getString(ConfigData.KeyVillagerEntityName);
		skin = p_70037_1_.getString(ConfigData.KeyVillagerEntitySkin);
		profession = p_70037_1_.getInteger(ConfigData.KeyVillagerEntityProfession);
		
		//add components
		Villager v = Villager.registry.get(profession);
		if(v!=null){
			this.setVillagerComponents(v.createComponents());
		}
	}

	@Override
	protected boolean canDespawn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onDeath(DamageSource p_70645_1_) {
		super.onDeath(p_70645_1_);
		
		//when the villager is dead, we should tell the DataVillager he is dead, and he will be revive on next noon
		DataVillageBento dataVB = DataVillageBento.get(this.worldObj);
		HelperDataVB.setVillageDeath(dataVB, this.dataVillagerID);
	}
	
	
    
	
    
	
	
	
}
