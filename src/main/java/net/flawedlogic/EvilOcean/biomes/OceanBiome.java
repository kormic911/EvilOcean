package net.flawedlogic.EvilOcean.biomes;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import net.minecraftforge.common.BiomeDictionary;

import org.apache.logging.log4j.Level;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import net.flawedlogic.EvilOcean.generators.IPlatformGenerator;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomeForestMutated;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.biome.BiomeJungle;
import net.minecraft.world.biome.BiomeMesa;
import net.minecraft.world.biome.BiomeMushroomIsland;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.biome.BiomeSavannaMutated;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.biome.BiomeSwamp;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraftforge.fml.common.FMLLog;

public abstract class OceanBiome extends Biome {
	
    public static final Set<Biome> ISLAND_BIOMES_LIST = Sets.<Biome>newHashSet();
    public static final Set<Biome> ISLAND_OCEAN_BIOMES_LIST = Sets.<Biome>newHashSet();
    public static final Map<Biome, Biome> OCEAN_TO_ISLAND_MAP = Maps.newHashMap();
    private static final float oceanBaseHeight = -1.5F;

	public OceanBiome(BiomeProperties properties) {
		super(properties);
	}
	
	public static void registerBiomes() {
		ISLAND_OCEAN_BIOMES_LIST.add(Biomes.OCEAN);
		ISLAND_OCEAN_BIOMES_LIST.add(Biomes.DEEP_OCEAN);
		// Ocean Biomes
		registerIslandOceanBiome(40, "plains_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F)));
		registerIslandOceanBiome(41, "desert_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.05F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(42, "forest_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setTemperature(0.7F).setRainfall(0.8F)));
		registerIslandOceanBiome(43, "extreme_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.5F).setTemperature(0.2F).setRainfall(0.3F)));
		registerIslandOceanBiome(44, "taiga_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.2F).setTemperature(0.25F).setRainfall(0.8F).setSnowEnabled()));
		registerIslandOceanBiome(45, "jungle_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setTemperature(0.95F).setRainfall(0.9F)));
		registerIslandOceanBiome(46, "birch_forest_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setTemperature(0.6F).setRainfall(0.6F)));
		registerIslandOceanBiome(47, "roofed_forest_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setTemperature(0.7F).setRainfall(0.8F)));
		registerIslandOceanBiome(48, "mesa_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(49, "swampland_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.1F).setTemperature(0.8F).setRainfall(0.9F).setWaterColor(14745518)));
		registerIslandOceanBiome(50, "ice_flats_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.05F).setTemperature(0.0F).setRainfall(0.5F).setSnowEnabled()));
		registerIslandOceanBiome(51, "ice_mountains_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(0.0F).setRainfall(0.5F).setSnowEnabled()));
		registerIslandOceanBiome(52, "mushroom_island_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(0.9F).setRainfall(1.0F)));
		registerIslandOceanBiome(53, "desert_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(54, "forest_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(0.7F).setRainfall(0.8F)));
		registerIslandOceanBiome(55, "taiga_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setTemperature(0.25F).setRainfall(0.8F).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F)));
		registerIslandOceanBiome(56, "smaller_extreme_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(0.2F).setRainfall(0.3F)));
		registerIslandOceanBiome(57, "jungle_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(0.95F).setRainfall(0.9F)));
		registerIslandOceanBiome(58, "birch_forest_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(0.6F).setRainfall(0.6F)));
		registerIslandOceanBiome(59, "taiga_cold_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.2F).setTemperature(-0.5F).setRainfall(0.4F).setSnowEnabled()));
		registerIslandOceanBiome(60, "taiga_cold_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(-0.5F).setRainfall(0.4F).setSnowEnabled()));
		registerIslandOceanBiome(61, "redwood_taiga_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setTemperature(0.3F).setRainfall(0.8F).setBaseHeight(oceanBaseHeight).setHeightVariation(0.2F)));
		registerIslandOceanBiome(62, "redwood_taiga_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(0.3F).setRainfall(0.8F)));
		registerIslandOceanBiome(63, "extreme_hills_with_trees_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.5F).setTemperature(0.2F).setRainfall(0.3F)));
		registerIslandOceanBiome(64, "savanna_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.05F).setTemperature(1.2F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(65, "savanna_rock_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.025F).setTemperature(1.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(66, "mesa_rock_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.025F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(67, "mesa_clear_rock_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.025F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(68, "mutated_plains_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F)));
		registerIslandOceanBiome(69, "mutated_desert_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.25F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(70, "mutated_extreme_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.5F).setTemperature(0.2F).setRainfall(0.3F)));
		registerIslandOceanBiome(71, "mutated_forest_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.4F).setTemperature(0.7F).setRainfall(0.8F)));
		registerIslandOceanBiome(72, "mutated_taiga_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.4F).setTemperature(0.25F).setRainfall(0.8F)));
		registerIslandOceanBiome(73, "mutated_swampland_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(0.8F).setRainfall(0.9F).setWaterColor(14745518)));
		registerIslandOceanBiome(74, "mutated_ice_flats_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.45000002F).setTemperature(0.0F).setRainfall(0.5F).setSnowEnabled()));
		registerIslandOceanBiome(75, "mutated_jungle_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.4F).setTemperature(0.95F).setRainfall(0.9F)));
		registerIslandOceanBiome(76, "mutated_jungle_edge_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.4F).setTemperature(0.95F).setRainfall(0.8F)));
		registerIslandOceanBiome(77, "mutated_birch_forest_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.4F).setTemperature(0.6F).setRainfall(0.6F)));
		registerIslandOceanBiome(78, "mutated_birch_forest_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.5F).setTemperature(0.6F).setRainfall(0.6F)));
		registerIslandOceanBiome(79, "mutated_roofed_forest_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.4F).setTemperature(0.7F).setRainfall(0.8F)));
		registerIslandOceanBiome(80, "mutated_taiga_cold_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.4F).setTemperature(-0.5F).setRainfall(0.4F).setSnowEnabled()));
		registerIslandOceanBiome(81, "mutated_redwood_taiga_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.2F).setTemperature(0.25F).setRainfall(0.8F)));
		registerIslandOceanBiome(82, "mutated_redwood_taiga_hills_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.2F).setTemperature(0.25F).setRainfall(0.8F)));
		registerIslandOceanBiome(83, "mutated_extreme_hills_with_trees_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.5F).setTemperature(0.2F).setRainfall(0.3F)));
		registerIslandOceanBiome(84, "mutated_savanna_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(0.3625F).setHeightVariation(oceanBaseHeight).setTemperature(1.1F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(85, "mutated_savanna_rock_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(1.2125001F).setTemperature(1.0F).setRainfall(0.0F).setRainDisabled()));
		//registerIslandOceanBiome(86, "mutated_mesa_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(87, "mutated_mesa_rock_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandOceanBiome(88, "mutated_mesa_clear_rock_ocean", new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(oceanBaseHeight).setHeightVariation(0.3F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));

		// Island Biomes
		registerIslandBiome(168, "plains_islands", new BiomePlains(false, (new Biome.BiomeProperties("Plains Island")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F)));
		registerIslandBiome(169, "desert_islands", new BiomeDesert((new Biome.BiomeProperties("Desert Island")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandBiome(170, "forest_islands", new BiomeForest(BiomeForest.Type.NORMAL, (new Biome.BiomeProperties("Forest Island")).setTemperature(0.7F).setRainfall(0.8F)));
		registerIslandBiome(171, "extreme_hills_islands", new BiomeHills(BiomeHills.Type.NORMAL, (new Biome.BiomeProperties("Extreme Hills Island")).setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(0.2F).setRainfall(0.3F)));
		registerIslandBiome(172, "taiga_islands", new BiomeTaiga(BiomeTaiga.Type.NORMAL, (new Biome.BiomeProperties("Taiga Island")).setBaseHeight(0.2F).setHeightVariation(0.2F).setTemperature(0.25F).setRainfall(0.8F).setSnowEnabled()));
		registerIslandBiome(173, "jungle_islands", new BiomeJungle(false, (new Biome.BiomeProperties("Jungle Island")).setTemperature(0.95F).setRainfall(0.9F)));
		registerIslandBiome(174, "birch_forest_islands", new BiomeForest(BiomeForest.Type.BIRCH, (new Biome.BiomeProperties("Birch Forest Island")).setTemperature(0.6F).setRainfall(0.6F)));
		registerIslandBiome(175, "roofed_forest_islands", new BiomeForest(BiomeForest.Type.ROOFED, (new Biome.BiomeProperties("Roofed Forest Island")).setTemperature(0.7F).setRainfall(0.8F)));
		registerIslandBiome(176, "mesa_islands", new BiomeMesa(false, false, (new Biome.BiomeProperties("Mesa Island")).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandBiome(177, "swampland_islands", new BiomeSwampIsland((new Biome.BiomeProperties("Swampland Island")).setBaseHeight(-0.2F).setHeightVariation(0.1F).setTemperature(0.8F).setRainfall(0.9F).setWaterColor(14745518)));
		registerIslandBiome(178, "ice_flats_islands", new BiomeSnow(false, (new Biome.BiomeProperties("Ice Plains Island")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.0F).setRainfall(0.5F).setSnowEnabled()));
		registerIslandBiome(179, "ice_mountains_islands", new BiomeSnow(false, (new Biome.BiomeProperties("Ice Mountain Island")).setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.0F).setRainfall(0.5F).setSnowEnabled()));
		registerIslandBiome(180, "mushroom_island_islands", new BiomeMushroomIsland((new Biome.BiomeProperties("Mushroom Island")).setBaseHeight(0.2F).setHeightVariation(0.3F).setTemperature(0.9F).setRainfall(1.0F)));
		registerIslandBiome(181, "desert_hills_islands", new BiomeDesert((new Biome.BiomeProperties("Desert Hills Island")).setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandBiome(182, "forest_hills_islands", new BiomeForest(BiomeForest.Type.NORMAL, (new Biome.BiomeProperties("Forest Hills Island")).setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.7F).setRainfall(0.8F)));
		registerIslandBiome(183, "taiga_hills_islands", new BiomeTaiga(BiomeTaiga.Type.NORMAL, (new Biome.BiomeProperties("Taiga Hills Island")).setTemperature(0.25F).setRainfall(0.8F).setBaseHeight(0.45F).setHeightVariation(0.3F)));
		registerIslandBiome(184, "smaller_extreme_hills_islands", new BiomeHills(BiomeHills.Type.EXTRA_TREES, (new Biome.BiomeProperties("Extreme Hills Edge Island")).setBaseHeight(0.8F).setHeightVariation(0.3F).setTemperature(0.2F).setRainfall(0.3F)));
		registerIslandBiome(185, "jungle_hills_islands", new BiomeJungle(false, (new Biome.BiomeProperties("Jungle Hills Island")).setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.95F).setRainfall(0.9F)));
		registerIslandBiome(186, "birch_forest_hills_islands", new BiomeForest(BiomeForest.Type.BIRCH, (new Biome.BiomeProperties("Birch Forest Hills Island")).setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.6F).setRainfall(0.6F)));
		registerIslandBiome(187, "taiga_cold_islands", new BiomeTaiga(BiomeTaiga.Type.NORMAL, (new Biome.BiomeProperties("Cold Taiga Island")).setBaseHeight(0.2F).setHeightVariation(0.2F).setTemperature(-0.5F).setRainfall(0.4F).setSnowEnabled()));
		registerIslandBiome(188, "taiga_cold_hills_islands", new BiomeTaiga(BiomeTaiga.Type.NORMAL, (new Biome.BiomeProperties("Cold Taiga Hills Island")).setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(-0.5F).setRainfall(0.4F).setSnowEnabled()));
		registerIslandBiome(189, "redwood_taiga_islands", new BiomeTaiga(BiomeTaiga.Type.MEGA, (new Biome.BiomeProperties("Mega Taiga Island")).setTemperature(0.3F).setRainfall(0.8F).setBaseHeight(0.2F).setHeightVariation(0.2F)));
		registerIslandBiome(190, "redwood_taiga_hills_islands", new BiomeTaiga(BiomeTaiga.Type.MEGA, (new Biome.BiomeProperties("Mega Taiga Hills Island")).setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.3F).setRainfall(0.8F)));
		registerIslandBiome(191, "extreme_hills_with_trees_islands", new BiomeHills(BiomeHills.Type.EXTRA_TREES, (new Biome.BiomeProperties("Extreme Hills+ Island")).setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(0.2F).setRainfall(0.3F)));
		registerIslandBiome(192, "savanna_islands", new BiomeSavanna((new Biome.BiomeProperties("Savanna Island")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(1.2F).setRainfall(0.0F).setRainDisabled()));
		registerIslandBiome(193, "savanna_rock_islands", new BiomeSavanna((new Biome.BiomeProperties("Savanna Plateau Island")).setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(1.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandBiome(194, "mesa_rock_islands", new BiomeMesa(false, true, (new Biome.BiomeProperties("Mesa Plateau F Island")).setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandBiome(195, "mesa_clear_rock_islands", new BiomeMesa(false, false, (new Biome.BiomeProperties("Mesa Plateau Island")).setBaseHeight(1.5F).setHeightVariation(0.025F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));		
		registerIslandBiome(196, "mutated_plains_islands", new BiomePlains(true, (new Biome.BiomeProperties("Sunflower Plains Island")).setBaseBiome("plains").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F)));
		registerIslandBiome(197, "mutated_desert_islands", new BiomeDesert((new Biome.BiomeProperties("Desert M Island")).setBaseBiome("desert").setBaseHeight(0.225F).setHeightVariation(0.25F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandBiome(198, "mutated_extreme_hills_islands", new BiomeHills(BiomeHills.Type.MUTATED, (new Biome.BiomeProperties("Extreme Hills M Island")).setBaseBiome("extreme_hills").setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(0.2F).setRainfall(0.3F)));
		registerIslandBiome(199, "mutated_forest_islands", new BiomeForest(BiomeForest.Type.FLOWER, (new Biome.BiomeProperties("Flower Forest Island")).setBaseBiome("forest").setHeightVariation(0.4F).setTemperature(0.7F).setRainfall(0.8F)));
		registerIslandBiome(200, "mutated_taiga_islands", new BiomeTaiga(BiomeTaiga.Type.NORMAL, (new Biome.BiomeProperties("Taiga M Island")).setBaseBiome("taiga").setBaseHeight(0.3F).setHeightVariation(0.4F).setTemperature(0.25F).setRainfall(0.8F)));
		registerIslandBiome(201, "mutated_swampland_islands", new BiomeSwampIsland((new Biome.BiomeProperties("Swampland M")).setBaseBiome("swampland").setBaseHeight(-0.1F).setHeightVariation(0.3F).setTemperature(0.8F).setRainfall(0.9F).setWaterColor(14745518)));
		registerIslandBiome(202, "mutated_ice_flats_islands", new BiomeSnow(true, (new Biome.BiomeProperties("Ice Plains Spikes Island")).setBaseBiome("ice_flats").setBaseHeight(0.425F).setHeightVariation(0.45000002F).setTemperature(0.0F).setRainfall(0.5F).setSnowEnabled()));
		registerIslandBiome(203, "mutated_jungle_islands", new BiomeJungle(false, (new Biome.BiomeProperties("Jungle M Island")).setBaseBiome("jungle").setBaseHeight(0.2F).setHeightVariation(0.4F).setTemperature(0.95F).setRainfall(0.9F)));
		registerIslandBiome(204, "mutated_jungle_edge_islands", new BiomeJungle(true, (new Biome.BiomeProperties("JungleEdge M Island")).setBaseBiome("jungle_edge").setBaseHeight(0.2F).setHeightVariation(0.4F).setTemperature(0.95F).setRainfall(0.8F)));
		registerIslandBiome(205, "mutated_birch_forest_islands", new BiomeForestMutated((new Biome.BiomeProperties("Birch Forest M Island")).setBaseBiome("birch_forest").setBaseHeight(0.2F).setHeightVariation(0.4F).setTemperature(0.6F).setRainfall(0.6F)));
		registerIslandBiome(206, "mutated_birch_forest_hills_islands", new BiomeForestMutated((new Biome.BiomeProperties("Birch Forest Hills M Island")).setBaseBiome("birch_forest_hills").setBaseHeight(0.55F).setHeightVariation(0.5F).setTemperature(0.6F).setRainfall(0.6F)));
		registerIslandBiome(207, "mutated_roofed_forest_islands", new BiomeForest(BiomeForest.Type.ROOFED, (new Biome.BiomeProperties("Roofed Forest M Island")).setBaseBiome("roofed_forest").setBaseHeight(0.2F).setHeightVariation(0.4F).setTemperature(0.7F).setRainfall(0.8F)));
		registerIslandBiome(208, "mutated_taiga_cold_islands", new BiomeTaiga(BiomeTaiga.Type.NORMAL, (new Biome.BiomeProperties("Cold Taiga M Island")).setBaseBiome("taiga_cold").setBaseHeight(0.3F).setHeightVariation(0.4F).setTemperature(-0.5F).setRainfall(0.4F).setSnowEnabled()));
		registerIslandBiome(209, "mutated_redwood_taiga_islands", new BiomeTaiga(BiomeTaiga.Type.MEGA_SPRUCE, (new Biome.BiomeProperties("Mega Spruce Taiga Island")).setBaseBiome("redwood_taiga").setBaseHeight(0.2F).setHeightVariation(0.2F).setTemperature(0.25F).setRainfall(0.8F)));
		registerIslandBiome(210, "mutated_redwood_taiga_hills_islands", new BiomeTaiga(BiomeTaiga.Type.MEGA_SPRUCE, (new Biome.BiomeProperties("Redwood Taiga Hills M Island")).setBaseBiome("redwood_taiga_hills").setBaseHeight(0.2F).setHeightVariation(0.2F).setTemperature(0.25F).setRainfall(0.8F)));
		registerIslandBiome(211, "mutated_extreme_hills_with_trees_islands", new BiomeHills(BiomeHills.Type.MUTATED, (new Biome.BiomeProperties("Extreme Hills+ M Island")).setBaseBiome("extreme_hills_with_trees").setBaseHeight(1.0F).setHeightVariation(0.5F).setTemperature(0.2F).setRainfall(0.3F)));
		registerIslandBiome(212, "mutated_savanna_islands", new BiomeSavannaMutated((new Biome.BiomeProperties("Savanna M Island")).setBaseBiome("savanna").setBaseHeight(0.3625F).setHeightVariation(1.225F).setTemperature(1.1F).setRainfall(0.0F).setRainDisabled()));
		registerIslandBiome(213, "mutated_savanna_rock_islands", new BiomeSavannaMutated((new Biome.BiomeProperties("Savanna Plateau M Island")).setBaseBiome("savanna_rock").setBaseHeight(1.05F).setHeightVariation(1.2125001F).setTemperature(1.0F).setRainfall(0.0F).setRainDisabled()));
		/**///registerIslandBiome(214, "mutated_mesa_islands", new BiomeMesa(true, false, (new Biome.BiomeProperties("Mesa (Bryce) Island")).setBaseBiome("mesa").setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandBiome(215, "mutated_mesa_rock_islands", new BiomeMesa(false, true, (new Biome.BiomeProperties("Mesa Plateau F M Island")).setBaseBiome("mesa_rock").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
		registerIslandBiome(216, "mutated_mesa_clear_rock_islands", new BiomeMesa(false, false, (new Biome.BiomeProperties("Mesa Plateau M Island")).setBaseBiome("mesa_clear_rock").setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled()));
	
		FMLLog.log(Level.INFO, "Registered all biomes");
		
		BiomeDictionary.addTypes(OceanBiomes.PLAINS_ISLANDS,                           PLAINS                                                  );
		BiomeDictionary.addTypes(OceanBiomes.DESERT_ISLANDS,                           HOT,      DRY,        SANDY                             );
		BiomeDictionary.addTypes(OceanBiomes.EXTREME_HILLS_ISLANDS,                    MOUNTAIN, HILLS                                         );
		BiomeDictionary.addTypes(OceanBiomes.MOUNTAIN_ISLANDS,                    MOUNTAIN, HILLS                                         );
		BiomeDictionary.addTypes(OceanBiomes.FOREST_ISLANDS,                           FOREST                                                  );
		BiomeDictionary.addTypes(OceanBiomes.TAIGA_ISLANDS,                            COLD,     CONIFEROUS, FOREST                            );
		BiomeDictionary.addTypes(OceanBiomes.SWAMPLAND_ISLANDS,                        WET,      SWAMP                                         );
		BiomeDictionary.addTypes(OceanBiomes.ICE_PLAINS_ISLANDS,                       COLD,     SNOWY,      WASTELAND                         );
		BiomeDictionary.addTypes(OceanBiomes.ICE_MOUNTAINS_ISLANDS,                    COLD,     SNOWY,      MOUNTAIN                          );
		BiomeDictionary.addTypes(OceanBiomes.MUSHROOM_ISLAND_ISLANDS,                  MUSHROOM, RARE                                          );
		BiomeDictionary.addTypes(OceanBiomes.DESERT_HILLS_ISLANDS,                     HOT,      DRY,        SANDY,    HILLS                   );
		BiomeDictionary.addTypes(OceanBiomes.FOREST_HILLS_ISLANDS,                     FOREST,   HILLS                                         );
		BiomeDictionary.addTypes(OceanBiomes.TAIGA_HILLS_ISLANDS,                      COLD,     CONIFEROUS, FOREST,   HILLS                   );
		BiomeDictionary.addTypes(OceanBiomes.EXTREME_HILLS_EDGE_ISLANDS,               MOUNTAIN                                                );
		BiomeDictionary.addTypes(OceanBiomes.JUNGLE_ISLANDS,                           HOT,      WET,        DENSE,    JUNGLE                  );
		BiomeDictionary.addTypes(OceanBiomes.JUNGLE_HILLS_ISLANDS,                     HOT,      WET,        DENSE,    JUNGLE,   HILLS         );
		BiomeDictionary.addTypes(OceanBiomes.BIRCH_FOREST_ISLANDS,                     FOREST                                                  );
		BiomeDictionary.addTypes(OceanBiomes.BIRCH_FOREST_HILLS_ISLANDS,               FOREST,   HILLS                                         );
		BiomeDictionary.addTypes(OceanBiomes.ROOFED_FOREST_ISLANDS,                    SPOOKY,   DENSE,      FOREST                            );
		BiomeDictionary.addTypes(OceanBiomes.COLD_TAIGA_ISLANDS,                       COLD,     CONIFEROUS, FOREST,   SNOWY                   );
		BiomeDictionary.addTypes(OceanBiomes.COLD_TAIGA_HILLS_ISLANDS,                 COLD,     CONIFEROUS, FOREST,   SNOWY,    HILLS         );
		BiomeDictionary.addTypes(OceanBiomes.REDWOOD_TAIGA_ISLANDS,                    COLD,     CONIFEROUS, FOREST                            );
		BiomeDictionary.addTypes(OceanBiomes.REDWOOD_TAIGA_HILLS_ISLANDS,              COLD,     CONIFEROUS, FOREST,   HILLS                   );
		BiomeDictionary.addTypes(OceanBiomes.EXTREME_HILLS_WITH_TREES_ISLANDS,         MOUNTAIN, FOREST,     SPARSE                            );
		BiomeDictionary.addTypes(OceanBiomes.SAVANNA_ISLANDS,                          HOT,      SAVANNA,    PLAINS,   SPARSE                  );
		BiomeDictionary.addTypes(OceanBiomes.SAVANNA_PLATEAU_ISLANDS,                  HOT,      SAVANNA,    PLAINS,   SPARSE,   RARE          );
		BiomeDictionary.addTypes(OceanBiomes.MESA_ISLANDS,                             MESA,     SANDY                                         );
		BiomeDictionary.addTypes(OceanBiomes.MESA_ROCK_ISLANDS,                        MESA,     SPARSE,     SANDY                             );
		BiomeDictionary.addTypes(OceanBiomes.MESA_CLEAR_ROCK_ISLANDS,                  MESA,     SANDY                                         );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_PLAINS_ISLANDS,                   PLAINS,   RARE                                          );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_DESERT_ISLANDS,                   HOT,      DRY,        SANDY,    RARE                    );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_EXTREME_HILLS_ISLANDS,            MOUNTAIN, SPARSE,     RARE                              );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_FOREST_ISLANDS,                   FOREST,   HILLS,      RARE                              );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_TAIGA_ISLANDS,                    COLD,     CONIFEROUS, FOREST,   MOUNTAIN, RARE          );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_SWAMPLAND_ISLANDS,                WET,      SWAMP,      HILLS,    RARE                    );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_ICE_FLATS_ISLANDS,                COLD,     SNOWY,      HILLS,    RARE                    );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_JUNGLE_ISLANDS,                   HOT,      WET,        DENSE,    JUNGLE,   MOUNTAIN, RARE);
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_JUNGLE_EDGE_ISLANDS,              HOT,      SPARSE,     JUNGLE,   HILLS,    RARE          );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_BIRCH_FOREST_ISLANDS,             FOREST,   DENSE,      HILLS,    RARE                    );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_BIRCH_FOREST_HILLS_ISLANDS,       FOREST,   DENSE,      MOUNTAIN, RARE                    );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_ROOFED_FOREST_ISLANDS,            SPOOKY,   DENSE,      FOREST,   MOUNTAIN, RARE          );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_TAIGA_COLD_ISLANDS,               COLD,     CONIFEROUS, FOREST,   SNOWY,    MOUNTAIN, RARE);
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_REDWOOD_TAIGA_ISLANDS,            DENSE,    FOREST,     RARE                              );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_REDWOOD_TAIGA_HILLS_ISLANDS,      DENSE,    FOREST,     HILLS,    RARE                    );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_EXTREME_HILLS_WITH_TREES_ISLANDS, MOUNTAIN, SPARSE,     RARE                              );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_SAVANNA_ISLANDS,                  HOT,      DRY,        SPARSE,   SAVANNA,  MOUNTAIN, RARE);
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_SAVANNA_ROCK_ISLANDS,             HOT,      DRY,        SPARSE,   SAVANNA,  HILLS,    RARE);
		//BiomeDictionary.addTypes(OceanBiomes.MUTATED_MESA_ISLANDS,                     HOT,      DRY,        SPARSE,   SAVANNA,  MOUNTAIN, RARE);
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_MESA_ROCK_ISLANDS,                HOT,      DRY,        SPARSE,   HILLS,    RARE          );
		BiomeDictionary.addTypes(OceanBiomes.MUTATED_MESA_CLEAR_ROCK_ISLANDS,          HOT,      DRY,        SPARSE,   SAVANNA,  MOUNTAIN, RARE);
		
	}

	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorOcean();
	}
	
	public static void registerIslandBiome(int id, String name, Biome biome, Biome oceanBiome) {
		registerBiome(id, name, biome);
		ISLAND_BIOMES_LIST.add(biome);
		OCEAN_TO_ISLAND_MAP.put(oceanBiome, biome);
	}
	
	public static void registerIslandBiome(int id, String name, Biome biome) {
		registerBiome(id, name, biome);
		ISLAND_BIOMES_LIST.add(biome);
	}
	
	public static void registerIslandOceanBiome(int id, String name, Biome biome) {
		registerBiome(id, name, biome);
		ISLAND_OCEAN_BIOMES_LIST.add(biome);
	}
}