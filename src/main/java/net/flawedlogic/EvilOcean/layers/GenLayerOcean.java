package net.flawedlogic.EvilOcean.layers;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerAddIsland;
import net.minecraft.world.gen.layer.GenLayerAddMushroomIsland;
import net.minecraft.world.gen.layer.GenLayerAddSnow;
import net.minecraft.world.gen.layer.GenLayerDeepOcean;
import net.minecraft.world.gen.layer.GenLayerEdge;
import net.minecraft.world.gen.layer.GenLayerFuzzyZoom;
import net.minecraft.world.gen.layer.GenLayerHills;
import net.minecraft.world.gen.layer.GenLayerIsland;
import net.minecraft.world.gen.layer.GenLayerRareBiome;
import net.minecraft.world.gen.layer.GenLayerRemoveTooMuchOcean;
import net.minecraft.world.gen.layer.GenLayerRiver;
import net.minecraft.world.gen.layer.GenLayerRiverInit;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.GenLayerShore;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayerOcean extends GenLayer {

	public static GenLayer[] initializeAllBiomeGenerators(long par0, WorldType par2WorldType) {
		GenLayer biomes = new GenLayerBiomeOcean(1L);
		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		biomes = new GenLayerZoom(1003L, biomes);
		biomes = new GenLayerOceanIslands(1003L, biomes);
		biomes = GenLayerZoom.magnify(1000L, biomes, 0);
		biomes = new GenLayerDeepOcean(4L, biomes);
        
        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes); 
        biomes.initWorldGenSeed(par0); 
        genlayervoronoizoom.initWorldGenSeed(par0);
        
        return new GenLayer[] {biomes, genlayervoronoizoom, biomes};
	}

	public GenLayerOcean(long par1) {
		super(par1);
	}
	
    @Override 
    public int[] getInts(int x, int z, int width, int depth) { 
        return new int[0]; 
    }
}
