
package net.mcreator.nether.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.nether.creativetab.TabNetherupdateBlocks;
import net.mcreator.nether.ElementsNetherMod;

@ElementsNetherMod.ModElement.Tag
public class ItemNetheiteArmor extends ElementsNetherMod.ModElement {
	@GameRegistry.ObjectHolder("nether:netheite_armorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("nether:netheite_armorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("nether:netheite_armorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("nether:netheite_armorboots")
	public static final Item boots = null;
	public ItemNetheiteArmor(ElementsNetherMod instance) {
		super(instance, 35);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("NETHEITE_ARMOR", "nether:netherite__", 37, new int[]{2, 5, 6, 2}, 9,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 3f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("netheite_armorhelmet")
				.setRegistryName("netheite_armorhelmet").setCreativeTab(TabNetherupdateBlocks.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("netheite_armorbody")
				.setRegistryName("netheite_armorbody").setCreativeTab(TabNetherupdateBlocks.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("netheite_armorlegs")
				.setRegistryName("netheite_armorlegs").setCreativeTab(TabNetherupdateBlocks.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("netheite_armorboots")
				.setRegistryName("netheite_armorboots").setCreativeTab(TabNetherupdateBlocks.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("nether:netheite_armorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("nether:netheite_armorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("nether:netheite_armorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("nether:netheite_armorboots", "inventory"));
	}
}
