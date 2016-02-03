package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProFolk extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.wheat_seeds,10),new ItemStack(Items.apple,5)},
				new ItemStack(Items.bread)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.iron_axe,1),new ItemStack(Items.beef,3)},
				new ItemStack(Items.bed)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.bone,6),new ItemStack(Blocks.torch,20)},
				new ItemStack(Items.boat)));
	}

}
