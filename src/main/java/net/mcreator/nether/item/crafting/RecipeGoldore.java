
package net.mcreator.nether.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.nether.block.BlockGoldNether;
import net.mcreator.nether.ElementsNetherMod;

@ElementsNetherMod.ModElement.Tag
public class RecipeGoldore extends ElementsNetherMod.ModElement {
	public RecipeGoldore(ElementsNetherMod instance) {
		super(instance, 47);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockGoldNether.block, (int) (1)), new ItemStack(Items.GOLD_INGOT, (int) (1)), 3F);
	}
}
