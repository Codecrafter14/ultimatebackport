
package net.mcreator.nether.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.nether.creativetab.TabNetherupdateBlocks;
import net.mcreator.nether.ElementsNetherMod;

import java.util.Set;
import java.util.HashMap;

@ElementsNetherMod.ModElement.Tag
public class ItemNetheritepickaxe extends ElementsNetherMod.ModElement {
	@GameRegistry.ObjectHolder("nether:netheritepickaxe")
	public static final Item block = null;
	public ItemNetheritepickaxe(ElementsNetherMod instance) {
		super(instance, 28);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("NETHERITEPICKAXE", 4, 2031, 9f, 0f, 15)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 4);
				return ret.keySet();
			}
		}.setUnlocalizedName("netheritepickaxe").setRegistryName("netheritepickaxe").setCreativeTab(TabNetherupdateBlocks.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("nether:netheritepickaxe", "inventory"));
	}
}
