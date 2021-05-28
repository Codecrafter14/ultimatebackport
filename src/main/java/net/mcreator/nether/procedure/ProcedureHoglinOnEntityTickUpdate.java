package net.mcreator.nether.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.nether.entity.EntityZoglin;
import net.mcreator.nether.ElementsNetherMod;

import java.util.Map;

@ElementsNetherMod.ModElement.Tag
public class ProcedureHoglinOnEntityTickUpdate extends ElementsNetherMod.ModElement {
	public ProcedureHoglinOnEntityTickUpdate(ElementsNetherMod instance) {
		super(instance, 54);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure HoglinOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure HoglinOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure HoglinOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure HoglinOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure HoglinOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((entity.dimension) == (0))) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityZoglin.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
			(entity).world.removeEntity(entity);
		}
	}
}
