package net.flawedlogic.EvilOcean.providers;

import net.flawedlogic.EvilOcean.EvilOcean;
import net.minecraft.util.BlockPos;
import net.minecraft.world.WorldProviderSurface;
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
    protected void registerWorldChunkManager()
    {
        if (EvilOcean.instance.shouldBeOcean(worldObj))
        {
            worldChunkMgr = new WorldChunkManagerOcean(worldObj);
        } else {
        	worldChunkMgr = worldObj.getWorldInfo().getTerrainType().getChunkManager(worldObj);
            //worldChunkMgr = this.terrainType.getChunkManager(worldObj);
        }
    }

    @Override
    public IChunkProvider createChunkGenerator()
    {
        if (EvilOcean.instance.shouldBeOcean(worldObj))
        {
            return new ChunkProviderOcean(worldObj, worldObj.getSeed(), false);
        }
        return worldObj.getWorldInfo().getTerrainType().getChunkGenerator(worldObj, worldObj.getWorldInfo().getGeneratorOptions());
    }
}
