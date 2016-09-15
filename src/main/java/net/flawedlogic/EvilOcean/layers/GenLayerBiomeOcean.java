package net.flawedlogic.EvilOcean.layers;

import net.flawedlogic.EvilOcean.biomes.OceanBiomes;
import net.minecraft.init.Biomes;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomeOcean extends GenLayer {
	private Biome[] allowedBiomes;

	public GenLayerBiomeOcean(long par1, GenLayer par3GenLayer, WorldType par4WorldType) {
		super(par1);
		this.allowedBiomes = new Biome[] { OceanBiomes.DEEP_OCEAN, OceanBiomes.FOREST_OCEAN,
				OceanBiomes.DESERT_OCEAN, OceanBiomes.JUNGLE_OCEAN, OceanBiomes.MOUNTAIN_OCEAN, OceanBiomes.TAIGA_OCEAN,
				OceanBiomes.BIRCH_FOREST_OCEAN, OceanBiomes.ROOFED_FOREST_OCEAN, OceanBiomes.MESA_OCEAN };

		this.parent = par3GenLayer;
	}

	public int[] getInts(int par1, int par2, int par3, int par4) {
		int[] var5 = this.parent.getInts(par1, par2, par3, par4);
		int[] var6 = IntCache.getIntCache(par3 * par4);

		for (int var7 = 0; var7 < par4; ++var7) {
			for (int var8 = 0; var8 < par3; ++var8) {
				initChunkSeed(var8 + par1, var7 + par2);
				int var9 = var5[(var8 + var7 * par3)];

				if (var9 == 0) {
					var6[(var8 + var7 * par3)] = 0;
				} else if (var9 == Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND)) {
					var6[(var8 + var7 * par3)] = var9;
				} else if (var9 == 1) {
					var6[(var8 + var7 * par3)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
				} else {
					int var10 = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);

					if (var10 == Biome.getIdForBiome(Biomes.TAIGA)) {
						var6[(var8 + var7 * par3)] = var10;
					} else {
						var6[(var8 + var7 * par3)] = Biome.getIdForBiome(OceanBiomes.DEEP_OCEAN);
					}
				}
			}
		}

		return var6;
	}
}
