package net.mcreator.nether.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

import net.mcreator.nether.block.BlockCrimsonPressurePlatePressed;
import net.mcreator.nether.ElementsNetherMod;

import java.util.Map;

@ElementsNetherMod.ModElement.Tag
public class ProcedureCrimsonPressurePlateEntityWalksOnTheBlock extends ElementsNetherMod.ModElement {
	public ProcedureCrimsonPressurePlateEntityWalksOnTheBlock(ElementsNetherMod instance) {
		super(instance, 136);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CrimsonPressurePlateEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CrimsonPressurePlateEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CrimsonPressurePlateEntityWalksOnTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CrimsonPressurePlateEntityWalksOnTheBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), BlockCrimsonPressurePlatePressed.block.getDefaultState(), 3);
	}
}
