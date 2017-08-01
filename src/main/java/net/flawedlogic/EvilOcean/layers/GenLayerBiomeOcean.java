package net.flawedlogic.EvilOcean.layers;

import net.flawedlogic.EvilOcean.EvilOcean;
import net.flawedlogic.EvilOcean.biomes.OceanBiome;
import net.flawedlogic.EvilOcean.biomes.OceanBiomes;
import net.minecraft.init.Biomes;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomeOcean extends GenLayer {
	protected Object[] allowedBiomes = OceanBiome.ISLAND_OCEAN_BIOMES_LIST.toArray();
	
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
                if(nextInt(EvilOcean.instance.islandSpawnRate) == 0 && EvilOcean.instance.enableIslands) {
                	dest[(dx + dz * width)] = OceanBiome.getIdForBiome((Biome)this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
                } else {
                	dest[(dx + dz * width)] = Biome.getIdForBiome(Biomes.OCEAN);
                }
            } 
        } 
        return dest;
	}
}
