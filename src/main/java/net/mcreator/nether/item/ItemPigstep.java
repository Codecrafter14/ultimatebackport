
package net.mcreator.nether.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.nether.creativetab.TabNetherupdateBlocks;
import net.mcreator.nether.ElementsNetherMod;

@ElementsNetherMod.ModElement.Tag
public class ItemPigstep extends ElementsNetherMod.ModElement {
	@GameRegistry.ObjectHolder("nether:pigstep")
	public static final Item block = null;
	public ItemPigstep(ElementsNetherMod instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("nether:pigstep", "inventory"));
	}
	public static class MusicDiscItemCustom extends ItemRecord {
		public MusicDiscItemCustom() {
			super("pigstep", ElementsNetherMod.sounds.get(new ResourceLocation("nether:music.pigstep")));
			setUnlocalizedName("pigstep");
			setRegistryName("pigstep");
			setCreativeTab(TabNetherupdateBlocks.tab);
		}
	}
}
