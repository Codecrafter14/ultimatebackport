package net.mcreator.nether.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.nether.ElementsNetherMod;

import java.util.Map;

@ElementsNetherMod.ModElement.Tag
public class ProcedureRespawnancor3OnBlockRightClicked extends ElementsNetherMod.ModElement {
	public ProcedureRespawnancor3OnBlockRightClicked(ElementsNetherMod instance) {
		super(instance, 60);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Respawnancor3OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Respawnancor3OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Respawnancor3OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Respawnancor3OnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Respawnancor3OnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((((entity instanceof EntityLivingBase) ? ((EntityLivingBase) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Blocks.GLOWSTONE, (int) (1)).getItem())) {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).inventory.clearMatchingItems(new ItemStack(Blocks.GLOWSTONE, (int) (1)).getItem(), -1, (int) 1, null);
			world.playSound((EntityPlayer) null, x, y, z, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("nether:block.respawn_ancor.charge")), SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			world.playSound((EntityPlayer) null, x, y, z,
					(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
							.getObject(new ResourceLocation("nether:block.respawn_ancor.set_spawnpoint")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).setSpawnPoint(new BlockPos((int) x, (int) y, (int) z), true);
		}
	}
}
