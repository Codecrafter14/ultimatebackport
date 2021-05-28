
package net.mcreator.nether.world.biome;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.monster.EntityEnderman;

import net.mcreator.nether.entity.EntityStrider;
import net.mcreator.nether.block.BlockWarpedFloor;
import net.mcreator.nether.block.BlockNewNetherRack;
import net.mcreator.nether.ElementsNetherMod;

import java.util.Random;

@ElementsNetherMod.ModElement.Tag
public class BiomeWarpedforest extends ElementsNetherMod.ModElement {
	@GameRegistry.ObjectHolder("nether:warpedforest")
	public static final BiomeGenCustom biome = null;
	public BiomeWarpedforest(ElementsNetherMod instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 10));
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Warpedforest").setRainfall(0.5F).setBaseHeight(0.1F).setHeightVariation(0.2F).setTemperature(0.5F));
			setRegistryName("warpedforest");
			topBlock = BlockWarpedFloor.block.getDefaultState();
			fillerBlock = BlockNewNetherRack.block.getDefaultState();
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
			this.spawnableCreatureList.add(new SpawnListEntry(EntityEnderman.class, 20, 1, 10));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityStrider.EntityCustom.class, 20, 1, 4));
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
