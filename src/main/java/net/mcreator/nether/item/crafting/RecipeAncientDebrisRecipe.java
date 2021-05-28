
package net.mcreator.nether.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

import net.mcreator.nether.item.ItemNetheriteScrap;
import net.mcreator.nether.block.BlockAncientdebris;
import net.mcreator.nether.ElementsNetherMod;

@ElementsNetherMod.ModElement.Tag
public class RecipeAncientDebrisRecipe extends ElementsNetherMod.ModElement {
	public RecipeAncientDebrisRecipe(ElementsNetherMod instance) {
		super(instance, 61);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockAncientdebris.block, (int) (1)), new ItemStack(ItemNetheriteScrap.block, (int) (1)), 1F);
	}
}
