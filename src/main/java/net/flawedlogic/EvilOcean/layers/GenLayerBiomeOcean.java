package net.flawedlogic.EvilOcean.layers;

import net.flawedlogic.EvilOcean.biomes.BiomesOcean;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomeOcean extends GenLayer {
	protected BiomeGenBase[] allowedBiomes = {
			BiomeGenBase.ocean, 
			BiomeGenBase.deepOcean, 
			BiomesOcean.forestOcean,
			BiomesOcean.desertOcean, 
			BiomesOcean.jungleOcean, 
			BiomesOcean.mountainOcean, 
			BiomesOcean.taigaOcean,
			BiomesOcean.birchForestOcean, 
			BiomesOcean.roofedForestOcean, 
			BiomesOcean.mesaOcean
	};

	public GenLayerBiomeOcean(long par1) {
		super(par1);
	}
	
	public GenLayerBiomeOcean(long par1, GenLayer par3GenLayer) {
		super(par1);
		this.parent = par3GenLayer;
	}
	
	public GenLayerBiomeOcean(long par1, GenLayer par3GenLayer, WorldType par4WorldType) {
		super(par1);
		this.parent = par3GenLayer;
	}

	public int[] getInts(int x, int z, int width, int depth) {
        int[] dest = IntCache.getIntCache(width * depth); 
        for (int dz = 0; dz < depth; dz++) { 
            for (int dx = 0; dx < width; dx++) { 
                this.initChunkSeed(dx + x, dz + z); 
                if(nextInt(10) == 0) {
                	dest[(dx + dz * width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID; 
                } else {
                	dest[(dx + dz * width)] = BiomeGenBase.ocean.biomeID;
                }
            } 
        } 
        return dest; 
	}
}
