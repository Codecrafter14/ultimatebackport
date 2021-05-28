
package net.mcreator.nether.world.biome;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.init.Blocks;
import net.minecraft.entity.monster.EntitySkeleton;

import net.mcreator.nether.block.BlockSouldirt;
import net.mcreator.nether.ElementsNetherMod;

import java.util.Random;

@ElementsNetherMod.ModElement.Tag
public class BiomeSoulsandValley extends ElementsNetherMod.ModElement {
	@GameRegistry.ObjectHolder("nether:soulsand_valley")
	public static final BiomeGenCustom biome = null;
	public BiomeSoulsandValley(ElementsNetherMod instance) {
		super(instance, 65);
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
			super(new Biome.BiomeProperties("Soulsand Valley").setRainfall(0.5F).setBaseHeight(0.1F).setHeightVariation(0.2F).setTemperature(0.5F));
			setRegistryName("soulsand_valley");
			topBlock = BlockSouldirt.block.getDefaultState();
			fillerBlock = Blocks.SOUL_SAND.getDefaultState();
			decorator.treesPerChunk = 1;
			decorator.flowersPerChunk = 4;
			decorator.grassPerChunk = 4;
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
			this.spawnableCreatureList.add(new SpawnListEntry(EntitySkeleton.class, 20, 4, 4));
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
