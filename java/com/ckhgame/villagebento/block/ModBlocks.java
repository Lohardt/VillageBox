package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.building.BuildingArchitectsHome;
import com.ckhgame.villagebento.building.BuildingAutumnGarden;
import com.ckhgame.villagebento.building.BuildingBlacksmithsShop;
import com.ckhgame.villagebento.building.BuildingChickenShop;
import com.ckhgame.villagebento.building.BuildingChristmas;
import com.ckhgame.villagebento.building.BuildingCowShop;
import com.ckhgame.villagebento.building.BuildingDefenceTower;
import com.ckhgame.villagebento.building.BuildingFarmland;
import com.ckhgame.villagebento.building.BuildingFarmlandSmall;
import com.ckhgame.villagebento.building.BuildingFishingStore;
import com.ckhgame.villagebento.building.BuildingFlowerShop;
import com.ckhgame.villagebento.building.BuildingGroundworkLarge;
import com.ckhgame.villagebento.building.BuildingGroundworkMedium;
import com.ckhgame.villagebento.building.BuildingGroundworkSmall;
import com.ckhgame.villagebento.building.BuildingHunterHouse;
import com.ckhgame.villagebento.building.BuildingLargeBakery;
import com.ckhgame.villagebento.building.BuildingLargeCasino;
import com.ckhgame.villagebento.building.BuildingLargeHotel;
import com.ckhgame.villagebento.building.BuildingLargeMilitaryCamp;
import com.ckhgame.villagebento.building.BuildingLargeTavern;
import com.ckhgame.villagebento.building.BuildingLibrary;
import com.ckhgame.villagebento.building.BuildingMarket;
import com.ckhgame.villagebento.building.BuildingMiningHouse;
import com.ckhgame.villagebento.building.BuildingPeacefulGarden;
import com.ckhgame.villagebento.building.BuildingPotionStore;
import com.ckhgame.villagebento.building.BuildingProArchitectsHouse;
import com.ckhgame.villagebento.building.BuildingRoseBridge;
import com.ckhgame.villagebento.building.BuildingRosePath;
import com.ckhgame.villagebento.building.BuildingSheepShop;
import com.ckhgame.villagebento.building.BuildingSmallBakery;
import com.ckhgame.villagebento.building.BuildingSmallCasino;
import com.ckhgame.villagebento.building.BuildingSmallHotel;
import com.ckhgame.villagebento.building.BuildingSmallMilitaryCamp;
import com.ckhgame.villagebento.building.BuildingSmallTavern;
import com.ckhgame.villagebento.building.BuildingSunflower;
import com.ckhgame.villagebento.building.BuildingTeaChair;
import com.ckhgame.villagebento.building.BuildingVillageCenter;
import com.ckhgame.villagebento.item.ItemBlockVillageBuilding;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public final class ModBlocks {
    
    public static BlockBuildingScanner blockBuildingScanner;
    
    public static BlockBuildingDestroyer blockBuildingDestroyer;
    
    //buildings
    public static BlockVillageBuilding blockGroundworkOnlySmall;
    public static BlockVillageBuilding blockGroundworkOnlyMedium;
    public static BlockVillageBuilding blockGroundworkOnlyLarge;
    
    public static BlockVillageBuilding blockVillageCenter;
    public static BlockVillageBuilding blockMiningHouse;
    public static BlockVillageBuilding blockBlackSmithsShop;
    public static BlockVillageBuilding blockSmallBakery;
    public static BlockVillageBuilding blockArchitectsHome;
    public static BlockVillageBuilding blockFishingStore;
    public static BlockVillageBuilding blockSmallHotel;
    public static BlockVillageBuilding blockSmallTavern;
    public static BlockVillageBuilding blockCowShop;
    public static BlockVillageBuilding blockSheepShop;
    public static BlockVillageBuilding blockChickenShop;
    public static BlockVillageBuilding blockSmallCasino;
    public static BlockVillageBuilding blockFarmland;
    public static BlockVillageBuilding blockFlowerShop;
    public static BlockVillageBuilding blockPotionStore;
    public static BlockVillageBuilding blockDefenceTower;
    public static BlockVillageBuilding blockHunterHouse;
    public static BlockVillageBuilding blockSmallMilitaryCamp;
    public static BlockVillageBuilding blockLargeTavern;
    public static BlockVillageBuilding blockLargeMilitaryCamp;
    public static BlockVillageBuilding blockLargeCasino;
    public static BlockVillageBuilding blockLargeBakery;
    public static BlockVillageBuilding blockProArchitectsHouse;
    public static BlockVillageBuilding blockLargeHotel;
    public static BlockVillageBuilding blockMarket;
    public static BlockVillageBuilding blockFarmlandSmall;
    public static BlockVillageBuilding blockLibrary;
    
//  Decoration Blocks
    public static BlockVillageBuilding blockAutumnGarden;
    public static BlockVillageBuilding blockChristmas;
    public static BlockVillageBuilding blockPeacefulGarden;
    public static BlockVillageBuilding blockRoseBridge;
    public static BlockVillageBuilding blockRosePath;
    public static BlockVillageBuilding blockSunflower;
    public static BlockVillageBuilding blockTeaChair;
    
    
    
    public static final void init() {
        
    	GameRegistry.registerBlock(blockBuildingScanner = new BlockBuildingScanner(), "BlockBuildingScanner");
         
    	GameRegistry.registerBlock(blockBuildingDestroyer = new BlockBuildingDestroyer(), "BlockBuildingDestroyer");
             
        //buildings
        registerVillageBlock(blockGroundworkOnlySmall = new BlockVillageBuilding(BuildingGroundworkSmall.class,"BlockGroundworkOnlySmall"),"BlockGroundworkOnlySmall");
        registerVillageBlock(blockGroundworkOnlyMedium = new BlockVillageBuilding(BuildingGroundworkMedium.class,"BlockGroundworkOnlyMedium"),"BlockGroundworkOnlyMedium");
        registerVillageBlock(blockGroundworkOnlyLarge = new BlockVillageBuilding(BuildingGroundworkLarge.class,"BlockGroundworkOnlyLarge"),"BlockGroundworkOnlyLarge");
        
        registerVillageBlock(blockVillageCenter = new BlockVillageBuilding(BuildingVillageCenter.class,"BlockVillageCenter"),"BlockVillageCenter");
        registerVillageBlock(blockBlackSmithsShop = new BlockVillageBuilding(BuildingBlacksmithsShop.class,"BlockBlackSmithsShop"),"BlockBlackSmithsShop");
        registerVillageBlock(blockArchitectsHome = new BlockVillageBuilding(BuildingArchitectsHome.class,"BlockArchitectsHome"),"BlockArchitectsHome");
        registerVillageBlock(blockFishingStore = new BlockVillageBuilding(BuildingFishingStore.class,"BlockFishingStore"),"BlockFishingStore");
        registerVillageBlock(blockMiningHouse = new BlockVillageBuilding(BuildingMiningHouse.class,"BlockMiningHouse"),"BlockMiningHouse");
        registerVillageBlock(blockSmallBakery = new BlockVillageBuilding(BuildingSmallBakery.class,"BlockSmallBakery"),"BlockSmallBakery");
        registerVillageBlock(blockSmallHotel = new BlockVillageBuilding(BuildingSmallHotel.class,"BlockSmallHotel"),"BlockSmallHotel");
        registerVillageBlock(blockSmallTavern = new BlockVillageBuilding(BuildingSmallTavern.class,"BlockSmallTavern"),"BlockSmallTavern");
        
        registerVillageBlock(blockCowShop = new BlockVillageBuilding(BuildingCowShop.class,"BlockCowShop"),"BlockCowShop");
        registerVillageBlock(blockSheepShop = new BlockVillageBuilding(BuildingSheepShop.class,"BlockSheepShop"),"BlockSheepShop");
        registerVillageBlock(blockChickenShop = new BlockVillageBuilding(BuildingChickenShop.class,"BlockChickenShop"),"BlockChickenShop");
        registerVillageBlock(blockSmallCasino = new BlockVillageBuilding(BuildingSmallCasino.class,"BlockSmallCasino"),"BlockSmallCasino");
        registerVillageBlock(blockFarmland = new BlockVillageBuilding(BuildingFarmland.class,"BlockFarmland"),"BlockFarmland");
        registerVillageBlock(blockFarmlandSmall = new BlockVillageBuilding(BuildingFarmlandSmall.class,"BlockFarmlandSmall"),"BlockFarmlandSmall");
        registerVillageBlock(blockFlowerShop = new BlockVillageBuilding(BuildingFlowerShop.class,"BlockFlowerShop"),"BlockFlowerShop");
        registerVillageBlock(blockPotionStore = new BlockVillageBuilding(BuildingPotionStore.class,"BlockPotionStore"),"BlockPotionStore");
        registerVillageBlock(blockDefenceTower = new BlockVillageBuilding(BuildingDefenceTower.class,"BlockDefenceTower"),"BlockDefenceTower");
        registerVillageBlock(blockHunterHouse = new BlockVillageBuilding(BuildingHunterHouse.class,"BlockHunterHouse"),"BlockHunterHouse");
        registerVillageBlock(blockSmallMilitaryCamp = new BlockVillageBuilding(BuildingSmallMilitaryCamp.class,"BlockSmallMilitaryCamp"),"BlockSmallMilitaryCamp");
        registerVillageBlock(blockLargeMilitaryCamp = new BlockVillageBuilding(BuildingLargeMilitaryCamp.class,"BlockLargeMilitaryCamp"),"BlockLargeMilitaryCamp");
        registerVillageBlock(blockLargeTavern = new BlockVillageBuilding(BuildingLargeTavern.class,"BlockLargeTavern"),"BlockLargeTavern");
        registerVillageBlock(blockLargeCasino = new BlockVillageBuilding(BuildingLargeCasino.class,"BlockLargeCasino"),"BlockLargeCasino");
        registerVillageBlock(blockLargeBakery = new BlockVillageBuilding(BuildingLargeBakery.class,"BlockLargeBakery"),"BlockLargeBakery");
        registerVillageBlock(blockProArchitectsHouse = new BlockVillageBuilding(BuildingProArchitectsHouse.class,"BlockProArchitectsHouse"),"BlockProArchitectsHouse");
        registerVillageBlock(blockLargeHotel = new BlockVillageBuilding(BuildingLargeHotel.class,"BlockLargeHotel"),"BlockLargeHotel");
        registerVillageBlock(blockMarket = new BlockVillageBuilding(BuildingMarket.class,"BlockMarket"),"BlockMarket");
       	registerVillageBlock(blockLibrary = new BlockVillageBuilding(BuildingLibrary.class,"BlockLibrary"),"BlockLibrary");
        
        //	Decoration Blocks
        registerVillageBlock(blockAutumnGarden = new BlockVillageBuilding(BuildingAutumnGarden.class,"BlockAutumnGarden"),"BlockAutumnGarden");
        registerVillageBlock(blockChristmas = new BlockVillageBuilding(BuildingChristmas.class,"BlockChristmas"),"BlockChristmas");
        registerVillageBlock(blockSunflower = new BlockVillageBuilding(BuildingSunflower.class,"BlockSunflower"),"BlockSunflower");
        registerVillageBlock(blockRosePath = new BlockVillageBuilding(BuildingRosePath.class,"BlockRosePath"),"BlockRosePath");
        registerVillageBlock(blockRoseBridge = new BlockVillageBuilding(BuildingRoseBridge.class,"BlockRoseBridge"),"BlockRoseBridge");
       	registerVillageBlock(blockTeaChair = new BlockVillageBuilding(BuildingTeaChair.class,"BlockTeaChair"),"BlockTeaChair");
       	registerVillageBlock(blockPeacefulGarden = new BlockVillageBuilding(BuildingPeacefulGarden.class,"BlockPeacefulGarden"),"BlockPeacefulGarden");
    }
    
    private static void registerVillageBlock(Block block,String name){
    	GameRegistry.registerBlock(block,ItemBlockVillageBuilding.class,name);
    }
}
