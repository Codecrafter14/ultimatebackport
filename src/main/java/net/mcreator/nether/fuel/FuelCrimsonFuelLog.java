
package net.mcreator.nether.fuel;

import net.minecraft.item.ItemStack;

import net.mcreator.nether.block.BlockCrimsonLog;
import net.mcreator.nether.ElementsNetherMod;

@ElementsNetherMod.ModElement.Tag
public class FuelCrimsonFuelLog extends ElementsNetherMod.ModElement {
	public FuelCrimsonFuelLog(ElementsNetherMod instance) {
		super(instance, 73);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(BlockCrimsonLog.block, (int) (1)).getItem())
			return 1600;
		return 0;
	}
}
