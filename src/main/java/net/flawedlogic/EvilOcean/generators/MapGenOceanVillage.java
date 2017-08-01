package net.flawedlogic.EvilOcean.generators;

import java.util.Arrays;
import java.util.Map;

import net.flawedlogic.EvilOcean.biomes.OceanBiome;
import net.flawedlogic.EvilOcean.biomes.OceanBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenVillage;

public class MapGenOceanVillage extends MapGenVillage {
	public MapGenOceanVillage() {
		VILLAGE_SPAWN_BIOMES = Arrays.<Biome>asList((Biome[])OceanBiome.ISLAND_BIOMES_LIST.toArray());
	}

	@SuppressWarnings("unchecked")
	public MapGenOceanVillage(@SuppressWarnings("rawtypes") Map par1Map) {
		super(par1Map);
		VILLAGE_SPAWN_BIOMES = Arrays.<Biome>asList((Biome[])OceanBiome.ISLAND_BIOMES_LIST.toArray());
	}
}