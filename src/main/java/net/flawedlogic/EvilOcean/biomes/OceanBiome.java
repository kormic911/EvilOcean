package net.flawedlogic.EvilOcean.biomes;

import org.apache.logging.log4j.Level;

import net.flawedlogic.EvilOcean.EvilOcean;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomeMesa;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;

public abstract class OceanBiome extends Biome {

    public OceanBiome(BiomeProperties properties) {
        super(properties);
    }
    
    public static void registerBiomes() {
        // Biome.registerBiomes();
        // Ocean Biomes
        registerBiome(79, "eo_ocean", new BiomeOcean((new BiomePropertiesExtended("Ocean")).setBaseHeight(-1.5F).setHeightVariation(0.1F).setWaterColor(112)));
        registerBiome(80, "eo_deep_ocean", new BiomeBigOcean((new BiomePropertiesExtended("Deep Ocean")).setBaseHeight(-1.8F).setHeightVariation(0.1F).setWaterColor(112)));
        registerBiome(81, "desert_ocean", new BiomeDesertIsland((new BiomePropertiesExtended("Desert Ocean")).setBaseHeight(-1.5F).setHeightVariation(0.2F).setWaterColor(16421912).setRainDisabled().setRainfall(0.0F).setTemperature(2.0F)));
        registerBiome(82, "mountain_ocean", new BiomeMountainIslands((new BiomePropertiesExtended("Mountain Ocean")).setBaseHeight(-1.5F).setHeightVariation(0.2F).setRainfall(0.3F).setTemperature(0.2F).setWaterColor(6316128)));
        registerBiome(83, "forest_ocean", new BiomeGenOceanLilypads((new BiomePropertiesExtended("Forest Ocean")).setBaseHeight(-1.5F).setHeightVariation(0.2F).setRainfall(0.8F).setTemperature(0.7F).setWaterColor(353825)));
        registerBiome(84, "taiga_ocean", new BiomeBigOcean((new BiomePropertiesExtended("Taiga Ocean")).setBaseHeight(-1.5F).setHeightVariation(0.2F).setRainfall(0.8F).setTemperature(0.5F).setSnowEnabled().setWaterColor(1456435)));
        registerBiome(88, "jungle_ocean", new BiomeGenOceanLilypads((new BiomePropertiesExtended("Jungle Ocean")).setBaseHeight(-1.5F).setHeightVariation(0.2F).setRainfall(0.9F).setTemperature(1.2F).setWaterColor(5470985)));
        registerBiome(95, "birch_forest_ocean", new BiomeGenOceanLilypads((new BiomePropertiesExtended("Birch Forest Ocean")).setBaseHeight(-1.5F).setHeightVariation(0.2F).setRainfall(0.8F).setTemperature(0.7F).setWaterColor(353825)));
        registerBiome(96, "roofed_forest_ocean", new BiomeGenOceanLilypads((new BiomePropertiesExtended("Roofed Forest Ocean")).setBaseHeight(-1.5F).setHeightVariation(0.2F).setRainfall(0.8F).setTemperature(0.7F).setWaterColor(353825)));
        registerBiome(97, "mesa_ocean", new BiomeGenOceanLilypads((new BiomePropertiesExtended("Mesa Ocean")).setBaseHeight(-1.5F).setHeightVariation(0.2F).setRainfall(0.0F).setTemperature(2.0F).setWaterColor(14238997).setRainDisabled()));
        registerBiome(98, "mega_taiga_ocean", new BiomeBigOcean((new BiomePropertiesExtended("Mega Taiga Ocean")).setBaseHeight(-1.5F).setHeightVariation(0.2F).setRainfall(0.05F).setTemperature(0.5F).setWaterColor(1456435).setSnowEnabled()));

        // Island Biomes
        registerBiome(85, "desert_islands", new BiomeDesertIsland((new BiomePropertiesExtended("Desert Island")).setBaseHeight(0.0F).setHeightVariation(0.3F).setRainfall(0.0F).setTemperature(2.0F).setRainDisabled().setWaterColor(13786898)));
        registerBiome(86, "forest_islands", new BiomeForestIsland(BiomeForest.Type.NORMAL, (new BiomePropertiesExtended("Forest Island")).setBaseHeight(0.0F).setHeightVariation(0.3F).setRainfall(0.8F).setTemperature(0.7F).setWaterColor(2250012)));
        registerBiome(87, "taiga_islands", new BiomeTaiga(BiomeTaiga.Type.NORMAL, (new BiomePropertiesExtended("Taiga Island")).setBaseHeight(0.0F).setHeightVariation(0.3F).setRainfall(0.8F).setTemperature(0.05F).setWaterColor(1456435).setSnowEnabled()));
        registerBiome(89, "jungle_islands", new BiomeJungleIsland((new BiomePropertiesExtended("Jungle Island")).setBaseHeight(0.0F).setHeightVariation(0.3F).setRainfall(0.9F).setTemperature(1.2F).setWaterColor(2900485)));
        registerBiome(90, "mountain_islands", new BiomeMountainIslands((new BiomePropertiesExtended("Mountain Island")).setBaseHeight(0.3F).setHeightVariation(1.0F).setRainfall(0.5F).setTemperature(1.9F).setWaterColor(6316128)));
        registerBiome(91, "roofed_forest_islands", new BiomeForestIsland(BiomeForest.Type.ROOFED, (new BiomePropertiesExtended("Forest Island")).setBaseHeight(0.0F).setHeightVariation(0.3F).setWaterColor(4215066)));
        registerBiome(92, "birch_forest_islands", new BiomeForestIsland(BiomeForest.Type.BIRCH, (new BiomePropertiesExtended("Forest Island")).setBaseHeight(0.0F).setHeightVariation(0.3F).setWaterColor(3175492)));
        registerBiome(93, "mesa_islands", new BiomeMesa(false, false, (new BiomePropertiesExtended("Mesa Island")).setBaseHeight(0.0F).setHeightVariation(0.3F).setWaterColor(14238997)));
        FMLLog.log(Level.INFO, "Registered all biomes");

        Configuration config = EvilOcean.config;
        if(config.hasChanged()) config.save();
        
    }

    public BiomeDecorator createBiomeDecorator() {
        return new BiomeDecoratorOcean();
    }
    
    public static class BiomePropertiesExtended extends Biome.BiomeProperties {

        private String name;
        public BiomePropertiesExtended(String nameIn) {
            super(nameIn);
            this.name = nameIn;
            this.name.replace(" ", "_");
        }
        
        @Override
        public BiomeProperties setWaterColor(int waterColorIn) {
            int waterColor = EvilOcean.config.getInt("waterColor_" + this.name, "Biome Colors", waterColorIn, 0, 99999999, "water color for " + this.name);
            return super.setWaterColor(waterColor);
        }
        
    }
}