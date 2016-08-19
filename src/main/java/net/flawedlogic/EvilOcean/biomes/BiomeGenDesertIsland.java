package net.flawedlogic.EvilOcean.biomes;

import java.util.List;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

public class BiomeGenDesertIsland extends BiomesOcean {
	public BiomeGenDesertIsland(int par1) {
		super(par1);
		this.spawnableCreatureList.clear();

		this.topBlock = Blocks.sand;
		this.fillerBlock = Blocks.sand;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = 2;
		this.theBiomeDecorator.reedsPerChunk = 50;
		this.theBiomeDecorator.cactiPerChunk = 10;
	}

	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		super.decorate(par1World, par2Random, par3, par4);

		if (par2Random.nextInt(500) != 0)
			return;
		int k = par3 + par2Random.nextInt(16) + 8;
		int l = par4 + par2Random.nextInt(16) + 8;
		WorldGenDesertWells worldgendesertwells = new WorldGenDesertWells();
		worldgendesertwells.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 1, l);
	}
}