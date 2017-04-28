package net.flawedlogic.EvilOcean;

import net.flawedlogic.EvilOcean.providers.ChunkProviderOcean;
import net.flawedlogic.EvilOcean.providers.WorldChunkManagerOcean;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldTypeOcean extends WorldType {
	public WorldTypeOcean(String par2Str) {
		super(par2Str);
	}

	@Override
	public BiomeProvider getBiomeProvider(World world) {
		return new WorldChunkManagerOcean(world);
	}

	@Override
	public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
		return new ChunkProviderOcean(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
	}
}