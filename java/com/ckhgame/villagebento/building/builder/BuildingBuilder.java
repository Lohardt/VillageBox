package com.ckhgame.villagebento.building.builder;

import com.ckhgame.villagebento.building.fixdirection.BlockDirection;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.villager.Villager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BuildingBuilder {
	
	private static BuildingBuilder instance = null;
	public static BuildingBuilder getInstance(){
		if(instance == null)
			instance = new BuildingBuilder();
		return instance;
	}
	
	
	
	private World world;
	private EntityPlayer player;
	private int cx, cy, cz;
	private DataBuilding data;
	private int facing;
	
	private BuildingBuilder(){
		
	}
	
	public void reset(World w,EntityPlayer p, int x,int y,int z){
		this.world = w;
		this.player = p;
		this.cx = x;
		this.cy = y;
		this.cz = z;
	}
	
	public boolean generateData(int type,int sizeType){
		DataVillageBento villageBentoData = DataVillageBento.get(world);		

		data = null;
		
		//check if there is a building exists on the current location
		DataBuilding db = HelperDataVB.createDataBuilding(cx,cy,cz,type,sizeType);
		if(HelperDataVB.addBuildingData(villageBentoData, db)){
			
			data = db;
			villageBentoData.markDirty();
						
			return true;
		}	
		return false;
	}
	
	public void calculateFacing(){
		int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		facing = (l + 1 + 2)%4;//this is building face(where the entry faces to), NOT player facing
	}
	
	public void buildBlock(int dx,int dy,int dz,Block block,int metadata){
		int fx = dx;
		int fy = dy;
		int fz = dz;
		
		switch(facing){
		case 1://South
			fx = -dz;
			fz = dx;
			break;
		case 2://West
			fx = -dx;
			fz = -dz;
			break;
		case 3://North
			fx = dz;
			fz = -dx;
		case 0://East
			break;
			default://East
				break;
		}
					
		world.setBlock(	data.x+fx,
						data.y+fy,
						data.z+fz,
						block,0,2);
		
		world.setBlockMetadataWithNotify(	data.x+fx,
											data.y+fy,
											data.z+fz,
											BlockDirection.fix(block, metadata, facing),
											2);
	}

	//groundworks
	public void buildGroundwork(){

		//basic sets of village
		int xfrom = data.x - data.sizeX;
		int xto = data.x + data.sizeX;
		int zfrom = data.z - data.sizeZ;
		int zto = data.z + data.sizeZ;
		int y = data.y;
		int depth = ConfigBuilding.BuildingGroundWorkDepth;
		int height = ConfigBuilding.BuildingMaxHeight; // building center includes in height
		
		for(int x = xfrom;x <= xto;x++){
			for(int z = zfrom;z<= zto;z++){	
				buildGroundworkPerColumn(x, z, y, depth, height);
			}
		}
		
	}

	private void buildGroundworkPerColumn(int x, int z, int y, int depth, int height ){
		
		for(int dy = -depth; dy < 0;dy++){
			world.setBlock(x, y + dy, z, ConfigBuilding.GroundWorkBlock);
		}
		
		for(int dy = 0;dy<height;dy++){
			if (world.getBlock(x, dy+y, z).getMaterial() != Material.air){
				world.func_147480_a(x,dy+y,z,false);//destroy block
			}
		}
		
	}
	
	//villagers
	public void addBuildingVillager(Class<? extends Villager> c, String name, String skin, int dx, int dz){
		
		int fx = dx;
		int fz = dz;
		
		switch(facing){
		case 1://South
			fx = -dz;
			fz = dx;
			break;
		case 2://West
			fx = -dx;
			fz = -dz;
			break;
		case 3://North
			fx = dz;
			fz = -dx;
		case 0://East
			break;
			default://East
				break;
		}
		
		Villager.spawn(	world,
						data.x + fx, data.y, data.z + fz, 
						c, name, skin, data.id);
	}
}
