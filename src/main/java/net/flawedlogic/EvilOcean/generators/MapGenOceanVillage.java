package net.flawedlogic.EvilOcean.generators;

import java.util.Arrays;
import java.util.Map;

import net.flawedlogic.EvilOcean.biomes.BiomesOcean;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenVillage;

public class MapGenOceanVillage extends MapGenVillage {
	public MapGenOceanVillage() {
		villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomesOcean.desertIslands, BiomesOcean.forestIslands, BiomesOcean.taigaIslands, BiomesOcean.mountainIslands });
	}

	public MapGenOceanVillage(Map par1Map) {
		super(par1Map);
		villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomesOcean.desertIslands, BiomesOcean.forestIslands, BiomesOcean.taigaIslands, BiomesOcean.mountainIslands });
	}
}