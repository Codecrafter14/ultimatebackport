
package net.mcreator.nether.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.nether.creativetab.TabNetherupdateBlocks;
import net.mcreator.nether.ElementsNetherMod;

import java.util.Set;
import java.util.HashMap;

@ElementsNetherMod.ModElement.Tag
public class ItemNetheriteShovel extends ElementsNetherMod.ModElement {
	@GameRegistry.ObjectHolder("nether:netherite_shovel")
	public static final Item block = null;
	public ItemNetheriteShovel(ElementsNetherMod instance) {
		super(instance, 30);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("NETHERITE_SHOVEL", 4, 100, 9f, 0f, 15)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 4);
				return ret.keySet();
			}
		}.setUnlocalizedName("netherite_shovel").setRegistryName("netherite_shovel").setCreativeTab(TabNetherupdateBlocks.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("nether:netherite_shovel", "inventory"));
	}
}
