
package net.mcreator.nether.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.nether.ElementsNetherMod;

@ElementsNetherMod.ModElement.Tag
public class TabNetherupdateBlocks extends ElementsNetherMod.ModElement {
	public TabNetherupdateBlocks(ElementsNetherMod instance) {
		super(instance, 42);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabnetherupdate_blocks") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(Blocks.NETHERRACK, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
