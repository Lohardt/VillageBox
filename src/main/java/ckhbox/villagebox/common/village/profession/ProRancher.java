package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProRancher extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.cheese)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.mayonnaise)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(ModItems.ballOfWool)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5),new ItemStack(Blocks.WOOL,1)},
				new ItemStack(ModItems.ballOfWool)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("rancher");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.rancher");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.silverCoin,1),
				new ItemStack(Items.BUCKET,1),
				new ItemStack(Items.SHEARS,1)
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.BUCKET),
				new ItemStack(Items.SHEARS)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();	
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.BUCKET,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,12)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.SHEARS,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,12)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.WHEAT_SEEDS,10)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,6)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.WHEAT,10)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.BUCKET,1)},
				new ItemStack[]{new ItemStack(ModItems.mayonnaise,2)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.SHEARS,1)},
				new ItemStack[]{new ItemStack(ModItems.ballOfWool,3)}));
	}
}
