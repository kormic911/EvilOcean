package net.flawedlogic.EvilOcean.generators;

import java.util.Arrays;
import java.util.Map;

import net.flawedlogic.EvilOcean.biomes.OceanBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenVillage;

public class MapGenOceanVillage extends MapGenVillage {
	public MapGenOceanVillage() {
		VILLAGE_SPAWN_BIOMES = Arrays.<Biome>asList(new Biome[] {OceanBiomes.DESERT_ISLANDS, OceanBiomes.FOREST_ISLANDS, OceanBiomes.TAIGA_ISLANDS, OceanBiomes.MOUNTAIN_ISLANDS});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MapGenOceanVillage(Map par1Map) {
		super(par1Map);
		VILLAGE_SPAWN_BIOMES = Arrays.<Biome>asList(new Biome[] {OceanBiomes.DESERT_ISLANDS, OceanBiomes.FOREST_ISLANDS, OceanBiomes.TAIGA_ISLANDS, OceanBiomes.MOUNTAIN_ISLANDS});
	}
}