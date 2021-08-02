package net.mcreator.nether.procedure;

import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

import net.mcreator.nether.ElementsNetherMod;

import java.util.function.Supplier;
import java.util.Map;

@ElementsNetherMod.ModElement.Tag
public class ProcedureTaken extends ElementsNetherMod.ModElement {
	public ProcedureTaken(ElementsNetherMod instance) {
		super(instance, 109);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Taken!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Taken!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Taken!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Taken!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Taken!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double time = 0;
		if (entity instanceof EntityPlayerMP) {
			Container _current = ((EntityPlayerMP) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
					_current.detectAndSendChanges();
				}
			}
		}
		if (entity instanceof EntityPlayerMP) {
			Container _current = ((EntityPlayerMP) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					((Slot) ((Map) invobj).get((int) (1))).putStack(ItemStack.EMPTY);
					_current.detectAndSendChanges();
				}
			}
		}
		world.playSound((EntityPlayer) null, x, y, z,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("nether:smithing_table")),
				SoundCategory.NEUTRAL, (float) 1, (float) 1);
	}
}
