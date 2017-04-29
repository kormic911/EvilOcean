package net.flawedlogic.EvilOcean.providers;

import net.flawedlogic.EvilOcean.EvilOcean;
import net.minecraft.util.ChunkCoordinates;
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
    public ChunkCoordinates getRandomizedSpawnPoint()
    {
        if (EvilOcean.instance.shouldBeOcean(worldObj)) {
            ChunkCoordinates spawn = new ChunkCoordinates(worldObj.getSpawnPoint());
            spawn.posY = worldObj.getTopSolidOrLiquidBlock(spawn.posX, spawn.posZ);
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
            worldChunkMgr = terrainType.getChunkManager(worldObj);
        }
    }

    @Override
    public IChunkProvider createChunkGenerator()
    {
        if (EvilOcean.instance.shouldBeOcean(worldObj))
        {
            return new ChunkProviderOcean(worldObj, worldObj.getSeed(), true);
        }
        return terrainType.getChunkGenerator(worldObj, field_82913_c);
    }
}
