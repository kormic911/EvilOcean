package net.flawedlogic.EvilOcean.biomes;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraft.world.biome.BiomeGenMesa;
import net.minecraft.world.biome.BiomeGenTaiga;

public abstract class BiomesOcean extends BiomeGenBase {
	protected static final BiomeGenBase.Height height_deepOcean = new BiomeGenBase.Height(-1.8F, 0.1F);
	protected static final BiomeGenBase.Height height_normalOcean = new BiomeGenBase.Height(-1.5F, 0.2F);
	protected static final BiomeGenBase.Height height_mountainOcean = new BiomeGenBase.Height(-1.5F, 0.3F);
	protected static final BiomeGenBase.Height height_normalIsland = new BiomeGenBase.Height(0.0F, 0.3F);
	protected static final BiomeGenBase.Height height_mountainIsland = new BiomeGenBase.Height(0.3F, 1.0F);

	
	public static final BiomeGenBase ocean = new BiomeGenBigOcean(79).setColor(112).setBiomeName("Ocean").setHeight(height_normalOcean);
	
	public static final BiomeGenBase deepOcean = new BiomeGenBigOcean(80).setColor(112).setBiomeName("Deep Ocean").setHeight(height_deepOcean);
	
	public static final BiomeGenBase desertOcean = new BiomeGenDesertIsland(81).setColor(16421912).setBiomeName("Ocean").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setHeight(height_normalOcean);

	public static final BiomeGenBase mountainOcean = new BiomeGenMountains(82).setColor(6316128).setBiomeName("Ocean").setHeight(height_mountainOcean).setTemperatureRainfall(0.2F, 0.3F);

	public static final BiomeGenBase forestOcean = new BiomeGenOceanLilypads(83).setColor(353825).setBiomeName("Ocean").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.7F, 0.8F).setHeight(height_normalOcean);

	public static final BiomeGenBase taigaOcean = new BiomeGenBigOcean(84).setColor(1456435).setBiomeName("Ocean").setFillerBlockMetadata(5159473).setEnableSnow().setTemperatureRainfall(0.05F, 0.8F).setHeight(height_normalOcean);

	public static final BiomeGenBase jungleOcean = new BiomeGenOceanLilypads(88).setColor(5470985).setBiomeName("Ocean").setFillerBlockMetadata(5470985).setTemperatureRainfall(1.2F, 0.9F).setHeight(height_normalOcean);

	public static final BiomeGenBase birchForestOcean = new BiomeGenOceanLilypads(95).setColor(353825).setBiomeName("Ocean").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.7F, 0.8F).setHeight(height_normalOcean);

	public static final BiomeGenBase roofedForestOcean = new BiomeGenOceanLilypads(96).setColor(353825).setBiomeName("Ocean").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.7F, 0.8F).setHeight(height_normalOcean);

	public static final BiomeGenBase mesaOcean = new BiomeGenOceanLilypads(97).setColor(14238997).setBiomeName("Ocean").setFillerBlockMetadata(5159473).setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setHeight(height_normalOcean);

	public static final BiomeGenBase megaTaigaOcean = new BiomeGenBigOcean(98).setColor(1456435).setBiomeName("Ocean").setFillerBlockMetadata(5159473).setEnableSnow().setTemperatureRainfall(0.05F, 0.8F).setHeight(height_normalOcean);

	public static final BiomeGenBase desertIslands = new BiomeGenDesertIsland(85).setColor(13786898).setBiomeName("Desert Island").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setHeight(height_normalIsland);

	public static final BiomeGenBase forestIslands = new BiomeGenForestIsland(86, 0).setColor(2250012).setBiomeName("Forest Island").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.7F, 0.8F).setHeight(height_normalIsland);

	public static final BiomeGenBase taigaIslands = new BiomeGenTaiga(87, 0).setColor(1456435).setBiomeName("Taiga Island").setEnableSnow().setFillerBlockMetadata(5159473).setTemperatureRainfall(0.05F, 0.8F).setHeight(height_normalIsland);

	public static final BiomeGenBase jungleIslands = new BiomeGenJungleIsland(89).setColor(2900485).setBiomeName("Jungle Island").setFillerBlockMetadata(5470985).setTemperatureRainfall(1.2F, 0.9F).setHeight(height_normalIsland);

	public static final BiomeGenBase mountainIslands = new BiomeGenMountains(90).setColor(6316128).setBiomeName("Mountain Island").setHeight(height_mountainIsland).setTemperatureRainfall(1.9F, 0.5F);

	public static final BiomeGenBase roofedForestIslands = new BiomeGenForestIsland(91, 3).setColor(4215066).setBiomeName("Forest Island").setHeight(height_normalIsland);

	public static final BiomeGenBase birchForestIslands = new BiomeGenForestIsland(92, 2).setBiomeName("Forest Island").setColor(3175492).setHeight(height_normalIsland);

	public static final BiomeGenBase mesaIslands = new BiomeGenMesa(93, false, false).setColor(14238997).setBiomeName("Mesa Island").setHeight(height_normalIsland);

	public static BiomeGenBase[] oceanBiomes = { ocean, deepOcean, desertOcean, mountainOcean, forestOcean, taigaOcean,
			jungleOcean, desertIslands, forestIslands, jungleIslands, mountainIslands, roofedForestIslands,
			mushroomIsland, birchForestIslands, mesaIslands };

	protected BiomesOcean(int par1) {
		super(par1);
	}

	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorOcean();
	}
}