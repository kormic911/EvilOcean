package net.flawedlogic.EvilOcean.providers;

import java.util.List;
import java.util.Random;

import net.flawedlogic.EvilOcean.generators.MapGenOceanVillage;
import net.flawedlogic.EvilOcean.util.OceanChunkPrimer;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextOverworld;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraft.world.WorldEntitySpawner;

public class ChunkProviderOcean implements IChunkGenerator {
	private Random rand;
	
    private NoiseGeneratorOctaves minLimitPerlinNoise;
    private NoiseGeneratorOctaves maxLimitPerlinNoise;
    private NoiseGeneratorOctaves mainPerlinNoise;
    private NoiseGeneratorPerlin surfaceNoise;
    public NoiseGeneratorOctaves scaleNoise;
    public NoiseGeneratorOctaves depthNoise;
    public NoiseGeneratorOctaves forestNoise;	
	
	private World worldObj;
	private final boolean mapFeaturesEnabled;
	private WorldType field_147435_p;
	private final double[] field_147434_q;
	private final float[] parabolicField;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenCaves();
 

	private MapGenStronghold strongholdGenerator = new MapGenStronghold();

	private MapGenVillage villageGenerator = new MapGenOceanVillage();

	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();

	private MapGenBase ravineGenerator = new MapGenRavine();
	private Biome[] biomesForGeneration;
	double[] field_147427_d;
	double[] field_147428_e;
	double[] field_147425_f;
	double[] field_147426_g;
	int[][] field_73219_j = new int[32][32];

	public ChunkProviderOcean(World par1World, long par2, boolean par4) {
		this.worldObj = par1World;
		this.mapFeaturesEnabled = par4;
		this.field_147435_p = par1World.getWorldInfo().getTerrainType();
		this.rand = new Random(par2);
		
        this.minLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.maxLimitPerlinNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.mainPerlinNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.surfaceNoise = new NoiseGeneratorPerlin(this.rand, 4);
        this.scaleNoise = new NoiseGeneratorOctaves(this.rand, 10);
        this.depthNoise = new NoiseGeneratorOctaves(this.rand, 16);
        this.forestNoise = new NoiseGeneratorOctaves(this.rand, 8);
        
		this.field_147434_q = new double[825];
		this.parabolicField = new float[25];

		for (int j = -2; j <= 2; ++j) {
			for (int k = -2; k <= 2; ++k) {
				float f = 10.0F / MathHelper.sqrt(j * j + k * k + 0.2F);
				this.parabolicField[(j + 2 + (k + 2) * 5)] = f;
			}
		}

		ContextOverworld noiseGens = new ContextOverworld(minLimitPerlinNoise, maxLimitPerlinNoise, mainPerlinNoise, surfaceNoise, scaleNoise, depthNoise, forestNoise);
		noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
        this.minLimitPerlinNoise = noiseGens.getLPerlin1();
        this.maxLimitPerlinNoise = noiseGens.getLPerlin2();
        this.mainPerlinNoise = noiseGens.getPerlin();
        this.surfaceNoise = noiseGens.getHeight();
        this.scaleNoise = noiseGens.getScale();
        this.depthNoise = noiseGens.getDepth();
        this.forestNoise = noiseGens.getForest();
	}

	public void func_147424_a(int x, int z, OceanChunkPrimer chunkPrimer) {
		byte b0 = 63;
		//chunkPrimer.setBlockState(index, state);
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
		func_147423_a(x * 4, 0, z * 4);

		for (int k = 0; k < 4; ++k) {
			int l = k * 5;
			int i1 = (k + 1) * 5;

			for (int j1 = 0; j1 < 4; ++j1) {
				int k1 = (l + j1) * 33;
				int l1 = (l + j1 + 1) * 33;
				int i2 = (i1 + j1) * 33;
				int j2 = (i1 + j1 + 1) * 33;

				for (int k2 = 0; k2 < 32; ++k2) {
					double d0 = 0.125D;
					double d1 = this.field_147434_q[(k1 + k2)];
					double d2 = this.field_147434_q[(l1 + k2)];
					double d3 = this.field_147434_q[(i2 + k2)];
					double d4 = this.field_147434_q[(j2 + k2)];
					double d5 = (this.field_147434_q[(k1 + k2 + 1)] - d1) * d0;
					double d6 = (this.field_147434_q[(l1 + k2 + 1)] - d2) * d0;
					double d7 = (this.field_147434_q[(i2 + k2 + 1)] - d3) * d0;
					double d8 = (this.field_147434_q[(j2 + k2 + 1)] - d4) * d0;

					for (int l2 = 0; l2 < 8; ++l2) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for (int i3 = 0; i3 < 4; ++i3) {
							int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
							short short1 = 256;
							j3 -= short1;
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double d15 = d10 - d16;

							for (int k3 = 0; k3 < 4; ++k3) {
								if ((d15 += d16) > 0.0D) {
									chunkPrimer.setBlockState((j3 += short1), Blocks.STONE.getDefaultState());
								} else if (k2 * 8 + l2 < b0) {
									chunkPrimer.setBlockState((j3 += short1), Blocks.WATER.getDefaultState());
								} else {
									chunkPrimer.setBlockState((j3 += short1), null);
								}
							}

							d10 += d12;
							d11 += d13;
						}

						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}
	
	public void replaceBlocksForBiome(int x, int z, ChunkPrimer chunkPrimer, Biome[] biomesForGeneration) {
		if(!ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, chunkPrimer, this.worldObj)) {
			return;
		}

		double d0 = 0.03125D;
		this.stoneNoise = this.surfaceNoise.getRegion(this.stoneNoise, x * 16, z * 16, 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

		for (int k = 0; k < 16; ++k) {
			for (int l = 0; l < 16; ++l) {
				Biome Biome = biomesForGeneration[(l + k * 16)];
				
				Biome.genTerrainBlocks(this.worldObj, this.rand, chunkPrimer, x * 16 + k, z * 16 + l, this.stoneNoise[(l + k * 16)]);
			}
		}		
	}

	public Chunk loadChunk(int par1, int par2) {
		return provideChunk(par1, par2);
	}
	
	@Override
	public Chunk provideChunk(int x, int z) {
		this.rand.setSeed(x * 341873128712L + z * 132897987541L);
		
		OceanChunkPrimer chunkPrimer = new OceanChunkPrimer();
		
		func_147424_a(x, z, chunkPrimer);
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		
		replaceBlocksForBiome(x, z, chunkPrimer, this.biomesForGeneration);
		
		this.caveGenerator.generate(this.worldObj, x, z, chunkPrimer);
		this.ravineGenerator.generate(this.worldObj, x, z, chunkPrimer);

		if (this.mapFeaturesEnabled) {
			this.mineshaftGenerator.generate(this.worldObj, x, z, chunkPrimer);
			this.villageGenerator.generate(this.worldObj, x, z, chunkPrimer);
			this.strongholdGenerator.generate(this.worldObj, x, z, chunkPrimer);
			this.scatteredFeatureGenerator.generate(this.worldObj, x, z, chunkPrimer);
		}

		Chunk chunk = new Chunk(this.worldObj, chunkPrimer, x, z);
		byte[] abyte1 = chunk.getBiomeArray();

		for (int k = 0; k < abyte1.length; ++k) {
			abyte1[k] = (byte) Biome.getIdForBiome(this.biomesForGeneration[k]);
		}

		chunk.generateSkylightMap();
		return chunk;
	}

	private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
		this.field_147426_g = this.depthNoise.generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
		this.field_147427_d = this.mainPerlinNoise.generateNoiseOctaves(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.field_147428_e = this.minLimitPerlinNoise.generateNoiseOctaves(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.41200000000003D, 684.41200000000003D, 684.41200000000003D);
		this.field_147425_f = this.maxLimitPerlinNoise.generateNoiseOctaves(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.41200000000003D, 684.41200000000003D, 684.41200000000003D);
		int l = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < 5; ++j1) {
			for (int k1 = 0; k1 < 5; ++k1) {
				float f = 0.0F;
				float f1 = 0.0F;
				float f2 = 0.0F;
				byte b0 = 2;
				Biome biome = this.biomesForGeneration[(j1 + 2 + (k1 + 2) * 10)];

				for (int l1 = -b0; l1 <= b0; ++l1) {
					for (int i2 = -b0; i2 <= b0; ++i2) {
						Biome biome1 = this.biomesForGeneration[(j1 + l1 + 2 + (k1 + i2 + 2) * 10)];
						float f3 = biome1.getBaseHeight();
						float f4 = biome1.getHeightVariation();

						if ((this.field_147435_p == WorldType.AMPLIFIED) && (f3 > 0.0F)) {
							f3 = 1.0F + f3 * 2.0F;
							f4 = 1.0F + f4 * 4.0F;
						}

						float f5 = this.parabolicField[(l1 + 2 + (i2 + 2) * 5)] / (f3 + 2.0F);
						if (biome1.getBaseHeight() > biome.getBaseHeight()) {
							f5 /= 2.0F;
						}

						f += f4 * f5;
						f1 += f3 * f5;
						f2 += f5;
					}
				}

				f /= f2;
				f1 /= f2;
				f = f * 0.9F + 0.1F;
				f1 = (f1 * 4.0F - 1.0F) / 8.0F;
				double d13 = this.field_147426_g[i1] / 8000.0D;

				if (d13 < 0.0D) {
					d13 = -d13 * 0.3D;
				}

				d13 = d13 * 3.0D - 2.0D;

				if (d13 < 0.0D) {
					d13 /= 2.0D;

					if (d13 < -1.0D) {
						d13 = -1.0D;
					}

					d13 /= 1.4D;
					d13 /= 2.0D;
				} else {
					if (d13 > 1.0D) {
						d13 = 1.0D;
					}

					d13 /= 8.0D;
				}

				++i1;
				double d12 = f1;
				double d14 = f;
				d12 += d13 * 0.2D;
				d12 = d12 * 8.5D / 8.0D;
				double d5 = 8.5D + d12 * 4.0D;

				for (int j2 = 0; j2 < 33; ++j2) {
					double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;

					if (d6 < 0.0D) {
						d6 *= 4.0D;
					}

					double d7 = this.field_147428_e[l] / 512.0D;
					double d8 = this.field_147425_f[l] / 512.0D;
					double d9 = (this.field_147427_d[l] / 10.0D + 1.0D) / 2.0D;
					double d10 = MathHelper.clampedLerp(d7, d8, d9) - d6;

					if (j2 > 29) {
						double d11 = (j2 - 29) / 3.0F;
						d10 = d10 * (1.0D - d11) + -10.0D * d11;
					}

					this.field_147434_q[l] = d10;
					++l;
				}
			}
		}
	}


	@Override
	public void populate(int par2, int par3) {
		net.minecraft.block.BlockFalling.fallInstantly = true;
		int k = par2 * 16;
		int l = par3 * 16;
		Biome biome = this.worldObj.getBiome(new BlockPos(k + 16, 0, l + 16));
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.getSeed());
		boolean flag = false;
		ChunkPos chunkCoord = new ChunkPos(par2, par3);

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(this, this.worldObj, this.rand, par2, par3, flag));

		if (this.mapFeaturesEnabled) {
			this.mineshaftGenerator.generateStructure(this.worldObj, this.rand, chunkCoord);
			flag = this.villageGenerator.generateStructure(this.worldObj, this.rand, chunkCoord);
			this.strongholdGenerator.generateStructure(this.worldObj, this.rand, chunkCoord);
			this.scatteredFeatureGenerator.generateStructure(this.worldObj, this.rand, chunkCoord);
		}
		
		if ((biome != Biomes.DESERT) && (biome != Biomes.DESERT_HILLS) && (!(flag)) && (this.rand.nextInt(4) == 0) && (TerrainGen.populate(this, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAKE))) {
			int k1 = k + this.rand.nextInt(16) + 8;
			int l1 = this.rand.nextInt(256);
			int i2 = l + this.rand.nextInt(16) + 8;
			new WorldGenLakes(Blocks.WATER).generate(this.worldObj, this.rand, new BlockPos(k1, l1, i2));
		}

		if ((TerrainGen.populate(this, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAVA)) && (!(flag)) && (this.rand.nextInt(8) == 0)) {
			int k1 = k + this.rand.nextInt(16) + 8;
			int l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
			int i2 = l + this.rand.nextInt(16) + 8;

			if ((l1 < 63) || (this.rand.nextInt(10) == 0)) {
				new WorldGenLakes(Blocks.LAVA).generate(this.worldObj, this.rand, new BlockPos(k1, l1, i2));
			}
		}

		boolean doGen = TerrainGen.populate(this, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.DUNGEON);
		for (int k1 = 0; (doGen) && (k1 < 8); ++k1) {
			int l1 = k + this.rand.nextInt(16) + 8;
			int i2 = this.rand.nextInt(256);
			int j2 = l + this.rand.nextInt(16) + 8;
			new WorldGenDungeons().generate(this.worldObj, this.rand, new BlockPos(l1, i2, j2));
		}

		biome.decorate(this.worldObj, this.rand, new BlockPos(k, 0, l));
		//SpawnerAnimals.performWorldGenSpawning(this.worldObj, biome, k + 8, l + 8, 16, 16, this.rand);
		WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biome, k + 8, l + 8, 16, 16, this.rand);
		k += 8;
		l += 8;

		doGen = TerrainGen.populate(this, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.ICE);
		for (int k1 = 0; (doGen) && (k1 < 16); ++k1) {
			for (int l1 = 0; l1 < 16; ++l1) {
				BlockPos i2 = this.worldObj.getPrecipitationHeight(new BlockPos(k + k1, 0, l + l1));

				setSnowIce(k1 + k, i2.getY(), l1 + l);
			}
		}

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(this, this.worldObj, this.rand, par2, par3, flag));

		net.minecraft.block.BlockFalling.fallInstantly = false;
	}

	public void setSnowIce(int x, int y, int z) {
		boolean going = false;

		if(this.worldObj.canBlockFreeze(new BlockPos(x, y - 1, z), false)) {
			this.worldObj.setBlockState(new BlockPos(x, y - 1, z), Blocks.ICE.getDefaultState());
		}


		if ((this.worldObj.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.AIR) && (this.worldObj.canSnowAt(new BlockPos(x, y, z), true)) && (Blocks.SNOW_LAYER.canPlaceBlockAt(this.worldObj, new BlockPos(x, y, z)))) {
			this.worldObj.setBlockState(new BlockPos(x, y, z), Blocks.SNOW_LAYER.getDefaultState());
		}

		if (this.worldObj.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.LEAVES) {
			going = true;
		}
		--y;
		while (going) {
			--y;
			Block block = this.worldObj.getBlockState(new BlockPos(x, y, z)).getBlock();
			if ((block != Blocks.AIR) && (block != Blocks.LEAVES)) {
				going = false;
			}
			setSnowIce(x, y, z);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, BlockPos pos) {
		Biome Biome = this.worldObj.getBiome(pos);
		return (((par1EnumCreatureType == EnumCreatureType.MONSTER) && (this.scatteredFeatureGenerator.isSwampHut(pos))) ? this.scatteredFeatureGenerator.getScatteredFeatureSpawnList() : Biome.getSpawnableList(par1EnumCreatureType));
	}

	@Override
	public void recreateStructures(Chunk chunk, int par1, int par2) {
		if (!(this.mapFeaturesEnabled)) {
			return;
		}
		this.mineshaftGenerator.generate(this.worldObj, par1, par2, (ChunkPrimer) null);
		this.villageGenerator.generate(this.worldObj, par1, par2, (ChunkPrimer) null);
		this.strongholdGenerator.generate(this.worldObj, par1, par2, (ChunkPrimer) null);
		this.scatteredFeatureGenerator.generate(this.worldObj, par1, par2, (ChunkPrimer) null);
	}
	
	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position, boolean p_180706_3_) {
        if ("Stronghold".equals(structureName))
        {
        	return this.strongholdGenerator.getClosestStrongholdPos(worldIn, position, p_180706_3_);
        }

        return null;
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		return false;
	}
}