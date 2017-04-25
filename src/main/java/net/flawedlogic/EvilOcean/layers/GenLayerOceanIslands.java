package net.flawedlogic.EvilOcean.layers;

import net.flawedlogic.EvilOcean.biomes.OceanBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOceanIslands extends GenLayer {
	public GenLayerOceanIslands(long par1, GenLayer par3GenLayer) {
		super(par1);
		this.parent = par3GenLayer;
	}

	public int[] getInts(int par1, int par2, int par3, int par4) {
		int[] var5 = this.parent.getInts(par1 - 1, par2 - 1, par3 + 2, par4 + 2);
		int[] var6 = IntCache.getIntCache(par3 * par4);

		for (int var7 = 0; var7 < par4; ++var7) {
			for (int var8 = 0; var8 < par3; ++var8) {
				initChunkSeed(var8 + par1, var7 + par2);
				int var9 = var5[(var8 + 1 + (var7 + 1) * (par3 + 2))];

				int var10 = var9;

				if (var9 == Biome.getIdForBiome(OceanBiomes.DESERT_OCEAN)) {
					var10 = Biome.getIdForBiome(OceanBiomes.DESERT_ISLANDS);
				} else if (var9 == Biome.getIdForBiome(OceanBiomes.FOREST_OCEAN)) {
					var10 = Biome.getIdForBiome(OceanBiomes.FOREST_ISLANDS);
				} else if (var9 == Biome.getIdForBiome(OceanBiomes.BIRCH_FOREST_OCEAN)) {
					var10 = Biome.getIdForBiome(OceanBiomes.BIRCH_FOREST_ISLANDS);
				} else if (var9 == Biome.getIdForBiome(OceanBiomes.ROOFED_FOREST_OCEAN)) {
					var10 = Biome.getIdForBiome(OceanBiomes.ROOFED_FOREST_ISLANDS);
				} else if (var9 == Biome.getIdForBiome(OceanBiomes.TAIGA_OCEAN)) {
					var10 = Biome.getIdForBiome(OceanBiomes.TAIGA_ISLANDS);
				} else if (var9 == Biome.getIdForBiome(OceanBiomes.JUNGLE_OCEAN)) {
					var10 = Biome.getIdForBiome(OceanBiomes.JUNGLE_ISLANDS);
				} else if (var9 == Biome.getIdForBiome(OceanBiomes.MOUNTAIN_OCEAN)) {
					var10 = Biome.getIdForBiome(OceanBiomes.MOUNTAIN_ISLANDS);
				} else if (var9 == Biome.getIdForBiome(OceanBiomes.MESA_OCEAN)) {
					var10 = Biome.getIdForBiome(OceanBiomes.MESA_ISLANDS);
				}

				if (var10 == var9) {
					var6[(var8 + var7 * par3)] = var9;
				} else {
					int var11 = var5[(var8 + 1 + (var7 + 1 - 1) * (par3 + 2))];
					int var12 = var5[(var8 + 1 + 1 + (var7 + 1) * (par3 + 2))];
					int var13 = var5[(var8 + 1 - 1 + (var7 + 1) * (par3 + 2))];
					int var14 = var5[(var8 + 1 + (var7 + 1 + 1) * (par3 + 2))];

					if ((var11 == var9) && (var12 == var9) && (var13 == var9) && (var14 == var9)) {
						var6[(var8 + var7 * par3)] = var10;
					} else {
						var6[(var8 + var7 * par3)] = var9;
					}
				}
			}
		}

		return var6;
	}
}
