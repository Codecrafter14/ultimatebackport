
package net.mcreator.nether.util;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;

import net.mcreator.nether.ElementsNetherMod;

@ElementsNetherMod.ModElement.Tag
public class OreDictPiglinloved extends ElementsNetherMod.ModElement {
	public OreDictPiglinloved(ElementsNetherMod instance) {
		super(instance, 52);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		OreDictionary.registerOre("piglinloved", new ItemStack(Blocks.GOLD_ORE, (int) (1)));
		OreDictionary.registerOre("piglinloved", new ItemStack(Blocks.GOLD_BLOCK, (int) (1)));
		OreDictionary.registerOre("piglinloved", new ItemStack(Items.GOLD_INGOT, (int) (1)));
		OreDictionary.registerOre("piglinloved", new ItemStack(Items.GOLD_NUGGET, (int) (1)));
		OreDictionary.registerOre("piglinloved", new ItemStack(Items.GOLDEN_HELMET, (int) (1)));
		OreDictionary.registerOre("piglinloved", new ItemStack(Items.GOLDEN_CHESTPLATE, (int) (1)));
		OreDictionary.registerOre("piglinloved", new ItemStack(Items.GOLDEN_LEGGINGS, (int) (1)));
		OreDictionary.registerOre("piglinloved", new ItemStack(Items.GOLDEN_BOOTS, (int) (1)));
		OreDictionary.registerOre("piglinloved", new ItemStack(Items.GOLDEN_APPLE, (int) (1), 1));
	}
}
