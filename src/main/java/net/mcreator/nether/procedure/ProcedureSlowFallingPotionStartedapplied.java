package net.mcreator.nether.procedure;

import net.minecraft.entity.Entity;

import net.mcreator.nether.ElementsNetherMod;

import java.util.Map;

@ElementsNetherMod.ModElement.Tag
public class ProcedureSlowFallingPotionStartedapplied extends ElementsNetherMod.ModElement {
	public ProcedureSlowFallingPotionStartedapplied(ElementsNetherMod instance) {
		super(instance, 69);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SlowFallingPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.fallDistance = (float) (0);
	}
}
