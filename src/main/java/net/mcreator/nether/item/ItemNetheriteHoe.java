
package net.mcreator.nether.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.nether.procedure.ProcedureNetheriteHoeItemIsCraftedsmelted;
import net.mcreator.nether.creativetab.TabNetherupdateBlocks;
import net.mcreator.nether.ElementsNetherMod;

import java.util.Set;
import java.util.Map;
import java.util.HashMap;

@ElementsNetherMod.ModElement.Tag
public class ItemNetheriteHoe extends ElementsNetherMod.ModElement {
	@GameRegistry.ObjectHolder("nether:netherite_hoe")
	public static final Item block = null;
	public ItemNetheriteHoe(ElementsNetherMod instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemHoe(EnumHelper.addToolMaterial("NETHERITE_HOE", 4, 2031, 9f, 0f, 15)) {
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("hoe", 4);
				return ret.keySet();
			}

			@Override
			public void onCreated(ItemStack itemstack, World world, EntityPlayer entity) {
				super.onCreated(itemstack, world, entity);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureNetheriteHoeItemIsCraftedsmelted.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("netherite_hoe").setRegistryName("netherite_hoe").setCreativeTab(TabNetherupdateBlocks.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("nether:netherite_hoe", "inventory"));
	}
}
