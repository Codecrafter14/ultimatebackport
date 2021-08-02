
package net.mcreator.nether.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

import net.mcreator.nether.ElementsNetherMod;

@ElementsNetherMod.ModElement.Tag
public class LootTableNetherGoldLoot extends ElementsNetherMod.ModElement {
	public LootTableNetherGoldLoot(ElementsNetherMod instance) {
		super(instance, 135);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("nether", "nether_gold_loot"));
	}
}
