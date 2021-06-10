
package net.mcreator.nether.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.util.ResourceLocation;

import net.mcreator.nether.ElementsNetherMod;

@ElementsNetherMod.ModElement.Tag
public class LootTableHoglinCookedPorkchop extends ElementsNetherMod.ModElement {
	public LootTableHoglinCookedPorkchop(ElementsNetherMod instance) {
		super(instance, 106);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		LootTableList.register(new ResourceLocation("nether", "hoglin_cooked_porkchop"));
	}
}
