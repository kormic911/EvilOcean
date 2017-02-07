package net.flawedlogic.EvilOcean.providers;

import net.flawedlogic.EvilOcean.EvilOcean;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkGenerator;

public class WorldProviderSurfaceOcean extends WorldProviderSurface {
    @Override
    public boolean canCoordinateBeSpawn(int x, int z) {
        if ( EvilOcean.instance.shouldBeOcean(world) ) {
            return true;
        }
        return super.canCoordinateBeSpawn(x, z);
    }

    @Override
    public BlockPos getRandomizedSpawnPoint() {
        if ( EvilOcean.instance.shouldBeOcean(world) ) {
            BlockPos spawn = world.getSpawnPoint();
            spawn = world.getTopSolidOrLiquidBlock(spawn);
            return spawn;
        }
        else {
            return super.getRandomizedSpawnPoint();
        }
    }

    @Override
    protected void createBiomeProvider() {
        if ( EvilOcean.instance.shouldBeOcean(world) ) {
            biomeProvider = new WorldChunkManagerOcean(world);
        }
        else {
            biomeProvider = world.getWorldInfo().getTerrainType().getBiomeProvider(world);
            // worldChunkMgr = this.terrainType.getChunkManager(worldObj);
        }
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        if ( EvilOcean.instance.shouldBeOcean(world) ) {
            return new ChunkProviderOcean(world, world.getSeed(), false);
        }
        return world.getWorldInfo().getTerrainType().getChunkGenerator(world, world.getWorldInfo().getGeneratorOptions());
    }
}
