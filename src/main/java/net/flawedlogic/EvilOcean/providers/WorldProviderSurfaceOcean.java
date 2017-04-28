package net.flawedlogic.EvilOcean.providers;

import net.flawedlogic.EvilOcean.EvilOcean;
import net.flawedlogic.EvilOcean.biomes.OceanBiome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderSurfaceOcean extends WorldProviderSurface
{
    @Override
    public boolean canCoordinateBeSpawn(int x, int z)
    {
        if (EvilOcean.instance.shouldBeOcean(worldObj)) {
            return true;
        }
        return super.canCoordinateBeSpawn(x, z);
    }

    @Override
    public BlockPos getRandomizedSpawnPoint()
    {
    	if (EvilOcean.instance.shouldBeOcean(worldObj)) {
            BlockPos spawn = worldObj.getSpawnPoint();
            spawn = worldObj.getTopSolidOrLiquidBlock(spawn);
            return spawn;
        } else {
            return super.getRandomizedSpawnPoint();
        }    	
    }

    @Override
    protected void createBiomeProvider()
    {
        if (EvilOcean.instance.shouldBeOcean(worldObj))
        {
        	biomeProvider = new WorldChunkManagerOcean(worldObj);
        } else {
        	biomeProvider = worldObj.getWorldInfo().getTerrainType().getBiomeProvider(worldObj);
            //worldChunkMgr = this.terrainType.getChunkManager(worldObj);
        }
    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        if (EvilOcean.instance.shouldBeOcean(worldObj))
        {
            return new ChunkProviderOcean(worldObj, worldObj.getSeed(), true, worldObj.getWorldInfo().getGeneratorOptions());
        }
        return worldObj.getWorldInfo().getTerrainType().getChunkGenerator(worldObj, worldObj.getWorldInfo().getGeneratorOptions());
    }
}
