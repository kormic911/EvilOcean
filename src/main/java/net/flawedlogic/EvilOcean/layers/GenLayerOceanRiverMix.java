package net.flawedlogic.EvilOcean.layers;

import net.flawedlogic.EvilOcean.biomes.BiomesOcean;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerRiverMix;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerOceanRiverMix extends GenLayerRiverMix {
	
    private GenLayer biomePatternGeneratorChain;
    private GenLayer riverPatternGeneratorChain;
    
	public GenLayerOceanRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_) {
		super(p_i2129_1_, p_i2129_3_, p_i2129_4_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
	}

	@Override
    public void initWorldGenSeed(long p_75905_1_)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(p_75905_1_);
        this.riverPatternGeneratorChain.initWorldGenSeed(p_75905_1_);
        super.initWorldGenSeed(p_75905_1_);
    }
	
	@Override
    public int[] getInts(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
        int[] aint2 = IntCache.getIntCache(p_75904_3_ * p_75904_4_);

        for (int i1 = 0; i1 < p_75904_3_ * p_75904_4_; ++i1)
        {
            if (aint[i1] != BiomesOcean.ocean.biomeID && aint[i1] != BiomesOcean.deepOcean.biomeID && 
            	aint[i1] != BiomesOcean.birchForestOcean.biomeID && aint[i1] != BiomesOcean.desertOcean.biomeID && 
            	aint[i1] != BiomesOcean.forestOcean.biomeID && aint[i1] != BiomesOcean.jungleOcean.biomeID && 
            	aint[i1] != BiomesOcean.mesaOcean.biomeID && aint[i1] != BiomesOcean.mountainOcean.biomeID && 
            	aint[i1] != BiomesOcean.roofedForestOcean.biomeID)
            {
                if (aint1[i1] == BiomesOcean.river.biomeID)
                {
                    if (aint[i1] == BiomesOcean.icePlains.biomeID || aint[i1] == BiomesOcean.taigaIslands.biomeID || aint[i1] == BiomesOcean.taigaOcean.biomeID || aint[i1] == BiomesOcean.megaTaigaOcean.biomeID)
                    {
                        aint2[i1] = BiomesOcean.frozenRiver.biomeID;
                    }
                    else if (aint[i1] != BiomeGenBase.mushroomIsland.biomeID && aint[i1] != BiomeGenBase.mushroomIslandShore.biomeID)
                    {
                        aint2[i1] = aint1[i1] & 255;
                    }
                    else
                    {
                        aint2[i1] = BiomeGenBase.mushroomIslandShore.biomeID;
                    }
                }
                else
                {
                    aint2[i1] = aint[i1];
                }
            }
            else
            {
                aint2[i1] = aint[i1];
            }
        }

        return aint2;
    }
}