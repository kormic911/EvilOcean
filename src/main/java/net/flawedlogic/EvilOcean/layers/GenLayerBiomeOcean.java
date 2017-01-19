package net.flawedlogic.EvilOcean.layers;

import net.flawedlogic.EvilOcean.biomes.BiomesOcean;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomeOcean extends GenLayer {
	private BiomeGenBase[] allowedBiomes;

	public GenLayerBiomeOcean(long par1, GenLayer par3GenLayer, WorldType par4WorldType) {
		super(par1);
		this.allowedBiomes = new BiomeGenBase[] { BiomesOcean.ocean, BiomesOcean.deepOcean, BiomesOcean.forestOcean,
				BiomesOcean.desertOcean, BiomesOcean.jungleOcean, BiomesOcean.mountainOcean, BiomesOcean.taigaOcean,
				BiomesOcean.birchForestOcean, BiomesOcean.roofedForestOcean, BiomesOcean.mesaOcean };

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
				} else if (var9 == BiomeGenBase.mushroomIsland.biomeID) {
					var6[(var8 + var7 * par3)] = var9;
				} else if (var9 == 1) {
					var6[(var8 + var7 * par3)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
				} else {
					int var10 = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;

					if (var10 == BiomeGenBase.taiga.biomeID) {
						var6[(var8 + var7 * par3)] = var10;
					} else {
						var6[(var8 + var7 * par3)] = BiomesOcean.deepOcean.biomeID;
					}
				}
			}
		}

		return var6;
	}
}
