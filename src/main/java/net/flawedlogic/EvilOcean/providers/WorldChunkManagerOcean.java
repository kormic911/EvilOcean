package net.flawedlogic.EvilOcean.providers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.flawedlogic.EvilOcean.EvilOcean;
import net.flawedlogic.EvilOcean.biomes.OceanBiome;
import net.flawedlogic.EvilOcean.biomes.OceanBiomes;
import net.flawedlogic.EvilOcean.layers.GenLayerOcean;
import net.flawedlogic.EvilOcean.generators.IPlatformGenerator;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ReportedException;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import net.minecraftforge.fml.common.FMLLog;

public class WorldChunkManagerOcean extends BiomeProvider {
	public static List<Biome> allowedBiomes = Lists.newArrayList(OceanBiomes.DESERT_ISLANDS, OceanBiomes.FOREST_ISLANDS, OceanBiomes.MOUNTAIN_ISLANDS, OceanBiomes.JUNGLE_ISLANDS, OceanBiomes.TAIGA_ISLANDS, OceanBiomes.BIRCH_FOREST_ISLANDS, OceanBiomes.ROOFED_FOREST_ISLANDS, OceanBiomes.MESA_ISLANDS);
	private GenLayer genBiomes;
	private GenLayer biomeIndexLayer;
	private BiomeCache biomeCache;
	@SuppressWarnings("rawtypes")
	private List biomesToSpawnIn;
	private World world;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected WorldChunkManagerOcean() {
		this.biomeCache = new BiomeCache(this);
		this.biomesToSpawnIn = new ArrayList();
		this.biomesToSpawnIn.addAll(allowedBiomes);
	}

	public WorldChunkManagerOcean(long par1, WorldType par3WorldType, World world) {
		this();
		GenLayer[] agenlayer = GenLayerOcean.initializeAllBiomeGenerators(par1, par3WorldType);
		agenlayer = getModdedBiomeGenerators(par3WorldType, par1, agenlayer);
		this.genBiomes = agenlayer[0];
		this.biomeIndexLayer = agenlayer[1];
		this.world = world;
	}

	public WorldChunkManagerOcean(World par1World) {
		this(par1World.getSeed(), par1World.getWorldInfo().getTerrainType(), par1World);
	}

	@Override
    public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height)
    {
        IntCache.resetIntCache();

        if (biomes == null || biomes.length < width * height)
        {
            biomes = new Biome[width * height];
        }

        int[] aint = this.genBiomes.getInts(x, z, width, height);

        try
        {
            for (int i = 0; i < width * height; ++i)
            {
                biomes[i] = OceanBiome.getBiome(aint[i]);
            }

            return biomes;
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("RawBiomeBlock");
            crashreportcategory.addCrashSection("biomes[] size", Integer.valueOf(biomes.length));
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("w", Integer.valueOf(width));
            crashreportcategory.addCrashSection("h", Integer.valueOf(height));
            throw new ReportedException(crashreport);
        }
    }

	@Override
    public Biome[] getBiomeGenAt(@Nullable Biome[] listToReuse, int x, int z, int width, int length, boolean cacheFlag)
    {
        IntCache.resetIntCache();

        if (listToReuse == null || listToReuse.length < width * length)
        {
            listToReuse = new Biome[width * length];
        }

        if (cacheFlag && width == 16 && length == 16 && (x & 15) == 0 && (z & 15) == 0)
        {
            Biome[] abiome = this.biomeCache.getCachedBiomes(x, z);
            System.arraycopy(abiome, 0, listToReuse, 0, width * length);
            return listToReuse;
        }
        else
        {
            int[] aint = this.biomeIndexLayer.getInts(x, z, width, length);

            for (int i = 0; i < width * length; ++i)
            {
                listToReuse[i] = OceanBiome.getBiome(aint[i]);
            }

            return listToReuse;
        }
    }

	@SuppressWarnings("rawtypes")
	@Override
    public boolean areBiomesViable(int x, int z, int radius, List<Biome> allowed)
    {
        IntCache.resetIntCache();
        int i = x - radius >> 2;
        int j = z - radius >> 2;
        int k = x + radius >> 2;
        int l = z + radius >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.genBiomes.getInts(i, j, i1, j1);

        try
        {
            for (int k1 = 0; k1 < i1 * j1; ++k1)
            {
                Biome biome = OceanBiome.getBiome(aint[k1]);

                if (!allowed.contains(biome))
                {
                    return false;
                }
            }

            return true;
        }
        catch (Throwable throwable)
        {
            CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
            crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
            crashreportcategory.addCrashSection("x", Integer.valueOf(x));
            crashreportcategory.addCrashSection("z", Integer.valueOf(z));
            crashreportcategory.addCrashSection("radius", Integer.valueOf(radius));
            crashreportcategory.addCrashSection("allowed", allowed);
            throw new ReportedException(crashreport);
        }
    }

	
	@Override
    @Nullable
    public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random)
    {
        IntCache.resetIntCache();
        int i = x - range >> 2;
        int j = z - range >> 2;
        int k = x + range >> 2;
        int l = z + range >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        int[] aint = this.genBiomes.getInts(i, j, i1, j1);
        BlockPos blockpos = null;
        int k1 = 0;

        for (int l1 = 0; l1 < i1 * j1; ++l1)
        {
            int i2 = i + l1 % i1 << 2;
            int j2 = j + l1 / i1 << 2;
            Biome biome = OceanBiome.getBiome(aint[l1]);

            if (biomes.contains(biome) && (blockpos == null || random.nextInt(k1 + 1) == 0))
            {
                blockpos = new BlockPos(i2, 0, j2);
                ++k1;
            }
        }

        return blockpos;
    }
	

	@Override
	public void cleanupCache() {
		super.cleanupCache();
	}

	@Override
	public GenLayer[] getModdedBiomeGenerators(WorldType worldType, long seed, GenLayer[] original) {
		WorldTypeEvent.InitBiomeGens event = new WorldTypeEvent.InitBiomeGens(worldType, seed, original);
		MinecraftForge.TERRAIN_GEN_BUS.post(event);
		return event.getNewBiomeGens();
	}	
}