package net.flawedlogic.EvilOcean.biomes;

import java.util.Iterator;
import java.util.logging.Logger;

import org.apache.logging.log4j.Level;

import net.minecraft.init.Biomes;
import net.minecraft.init.Bootstrap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.FMLLog;

public abstract class OceanBiomes
{

    public static final Biome PLAINS_ISLANDS;
    public static final Biome DESERT_ISLANDS;
    public static final Biome EXTREME_HILLS_ISLANDS;
    public static final Biome FOREST_ISLANDS;
    public static final Biome TAIGA_ISLANDS;
    public static final Biome SWAMPLAND_ISLANDS;
    public static final Biome ICE_PLAINS_ISLANDS;
    public static final Biome ICE_MOUNTAINS_ISLANDS;
    public static final Biome MUSHROOM_ISLAND_ISLANDS;
    public static final Biome DESERT_HILLS_ISLANDS;
    public static final Biome FOREST_HILLS_ISLANDS;
    public static final Biome TAIGA_HILLS_ISLANDS;
    public static final Biome EXTREME_HILLS_EDGE_ISLANDS;
    public static final Biome JUNGLE_ISLANDS;
    public static final Biome JUNGLE_HILLS_ISLANDS;
    public static final Biome BIRCH_FOREST_ISLANDS;
    public static final Biome BIRCH_FOREST_HILLS_ISLANDS;
    public static final Biome ROOFED_FOREST_ISLANDS;
    public static final Biome COLD_TAIGA_ISLANDS;
    public static final Biome COLD_TAIGA_HILLS_ISLANDS;
    public static final Biome REDWOOD_TAIGA_ISLANDS;
    public static final Biome REDWOOD_TAIGA_HILLS_ISLANDS;
    public static final Biome EXTREME_HILLS_WITH_TREES_ISLANDS;
    public static final Biome SAVANNA_ISLANDS;
    public static final Biome SAVANNA_PLATEAU_ISLANDS;
    public static final Biome MESA_ISLANDS;
    public static final Biome MESA_ROCK_ISLANDS;
    public static final Biome MESA_CLEAR_ROCK_ISLANDS;
    /*
    public static final Biome MUTATED_PLAINS_ISLANDS;
    public static final Biome MUTATED_DESERT_ISLANDS;
    public static final Biome MUTATED_EXTREME_HILLS_ISLANDS;
    public static final Biome MUTATED_FOREST_ISLANDS;
    public static final Biome MUTATED_TAIGA_ISLANDS;
    public static final Biome MUTATED_SWAMPLAND_ISLANDS;
    public static final Biome MUTATED_ICE_FLATS_ISLANDS;
    public static final Biome MUTATED_JUNGLE_ISLANDS;
    public static final Biome MUTATED_JUNGLE_EDGE_ISLANDS;
    public static final Biome MUTATED_BIRCH_FOREST_ISLANDS;
    public static final Biome MUTATED_BIRCH_FOREST_HILLS_ISLANDS;
    public static final Biome MUTATED_ROOFED_FOREST_ISLANDS;
    public static final Biome MUTATED_TAIGA_COLD_ISLANDS;
    public static final Biome MUTATED_REDWOOD_TAIGA_ISLANDS;
    public static final Biome MUTATED_REDWOOD_TAIGA_HILLS_ISLANDS;
    public static final Biome MUTATED_EXTREME_HILLS_WITH_TREES_ISLANDS;
    public static final Biome MUTATED_SAVANNA_ISLANDS;
    public static final Biome MUTATED_SAVANNA_ROCK_ISLANDS;
    //public static final Biome MUTATED_MESA_ISLANDS;
    public static final Biome MUTATED_MESA_ROCK_ISLANDS;
    public static final Biome MUTATED_MESA_CLEAR_ROCK_ISLANDS;
    */
    public static final Biome MOUNTAIN_ISLANDS;
    
    
    
    public static final Biome OCEAN;
    public static final Biome DEEP_OCEAN;
    public static final Biome PLAINS_OCEAN;
    public static final Biome DESERT_OCEAN;
    public static final Biome EXTREME_HILLS_OCEAN;
    public static final Biome FOREST_OCEAN;
    public static final Biome TAIGA_OCEAN;
    public static final Biome SWAMPLAND_OCEAN;
    public static final Biome ICE_PLAINS_OCEAN;
    public static final Biome ICE_MOUNTAINS_OCEAN;
    public static final Biome MUSHROOM_ISLAND_OCEAN;
    public static final Biome DESERT_HILLS_OCEAN;
    public static final Biome FOREST_HILLS_OCEAN;
    public static final Biome TAIGA_HILLS_OCEAN;
    public static final Biome EXTREME_HILLS_EDGE_OCEAN;
    public static final Biome JUNGLE_OCEAN;
    public static final Biome JUNGLE_HILLS_OCEAN;
    public static final Biome BIRCH_FOREST_OCEAN;
    public static final Biome BIRCH_FOREST_HILLS_OCEAN;
    public static final Biome ROOFED_FOREST_OCEAN;
    public static final Biome COLD_TAIGA_OCEAN;
    public static final Biome COLD_TAIGA_HILLS_OCEAN;
    public static final Biome REDWOOD_TAIGA_OCEAN;
    public static final Biome REDWOOD_TAIGA_HILLS_OCEAN;
    public static final Biome EXTREME_HILLS_WITH_TREES_OCEAN;
    public static final Biome SAVANNA_OCEAN;
    public static final Biome SAVANNA_PLATEAU_OCEAN;
    public static final Biome MESA_OCEAN;
    public static final Biome MESA_ROCK_OCEAN;
    public static final Biome MESA_CLEAR_ROCK_OCEAN;
    /*
    public static final Biome MUTATED_PLAINS_OCEAN;
    public static final Biome MUTATED_DESERT_OCEAN;
    public static final Biome MUTATED_EXTREME_HILLS_OCEAN;
    public static final Biome MUTATED_FOREST_OCEAN;
    public static final Biome MUTATED_TAIGA_OCEAN;
    public static final Biome MUTATED_SWAMPLAND_OCEAN;
    public static final Biome MUTATED_ICE_FLATS_OCEAN;
    public static final Biome MUTATED_JUNGLE_OCEAN;
    public static final Biome MUTATED_JUNGLE_EDGE_OCEAN;
    public static final Biome MUTATED_BIRCH_FOREST_OCEAN;
    public static final Biome MUTATED_BIRCH_FOREST_HILLS_OCEAN;
    public static final Biome MUTATED_ROOFED_FOREST_OCEAN;
    public static final Biome MUTATED_TAIGA_COLD_OCEAN;
    public static final Biome MUTATED_REDWOOD_TAIGA_OCEAN;
    public static final Biome MUTATED_REDWOOD_TAIGA_HILLS_OCEAN;
    public static final Biome MUTATED_EXTREME_HILLS_WITH_TREES_OCEAN;
    public static final Biome MUTATED_SAVANNA_OCEAN;
    public static final Biome MUTATED_SAVANNA_ROCK_OCEAN;
    //public static final Biome MUTATED_MESA_OCEAN;
    public static final Biome MUTATED_MESA_ROCK_OCEAN;
    public static final Biome MUTATED_MESA_CLEAR_ROCK_OCEAN;
    */
    public static final Biome MOUNTAIN_OCEAN;


    private static Biome getRegisteredBiome(String id)
    {
    	FMLLog.log(Level.INFO, "getRegisteredBiome: " + id);
        Biome biome = (Biome)Biome.REGISTRY.getObject(new ResourceLocation(id));

        if (biome == null)
        {
            throw new IllegalStateException("Invalid Biome requested: " + id);
        }
        else
        {
            return biome;
        }
    }

    static
    {
        if (!Bootstrap.isRegistered())
        {
            throw new RuntimeException("Accessed Biomes before Bootstrap!");
        }
        else
        {  
            PLAINS_ISLANDS = getRegisteredBiome("plains_islands");
            DESERT_ISLANDS = getRegisteredBiome("desert_islands");
            EXTREME_HILLS_ISLANDS = getRegisteredBiome("extreme_hills_islands");
            MOUNTAIN_ISLANDS = getRegisteredBiome("extreme_hills_islands");
            FOREST_ISLANDS = getRegisteredBiome("forest_islands");
            TAIGA_ISLANDS = getRegisteredBiome("taiga_islands");
            SWAMPLAND_ISLANDS = getRegisteredBiome("swampland_islands");
            ICE_PLAINS_ISLANDS = getRegisteredBiome("ice_flats_islands");
            ICE_MOUNTAINS_ISLANDS = getRegisteredBiome("ice_mountains_islands");
            MUSHROOM_ISLAND_ISLANDS = getRegisteredBiome("mushroom_island_islands");
            DESERT_HILLS_ISLANDS = getRegisteredBiome("desert_hills_islands");
            FOREST_HILLS_ISLANDS = getRegisteredBiome("forest_hills_islands");
            TAIGA_HILLS_ISLANDS = getRegisteredBiome("taiga_hills_islands");
            EXTREME_HILLS_EDGE_ISLANDS = getRegisteredBiome("smaller_extreme_hills_islands");
            JUNGLE_ISLANDS = getRegisteredBiome("jungle_islands");
            JUNGLE_HILLS_ISLANDS = getRegisteredBiome("jungle_hills_islands");
            BIRCH_FOREST_ISLANDS = getRegisteredBiome("birch_forest_islands");
            BIRCH_FOREST_HILLS_ISLANDS = getRegisteredBiome("birch_forest_hills_islands");
            ROOFED_FOREST_ISLANDS = getRegisteredBiome("roofed_forest_islands");
            COLD_TAIGA_ISLANDS = getRegisteredBiome("taiga_cold_islands");
            COLD_TAIGA_HILLS_ISLANDS = getRegisteredBiome("taiga_cold_hills_islands");
            REDWOOD_TAIGA_ISLANDS = getRegisteredBiome("redwood_taiga_islands");
            REDWOOD_TAIGA_HILLS_ISLANDS = getRegisteredBiome("redwood_taiga_hills_islands");
            EXTREME_HILLS_WITH_TREES_ISLANDS = getRegisteredBiome("extreme_hills_with_trees_islands");
            SAVANNA_ISLANDS = getRegisteredBiome("savanna_islands");
            SAVANNA_PLATEAU_ISLANDS = getRegisteredBiome("savanna_rock_islands");
            MESA_ISLANDS = getRegisteredBiome("mesa_islands");
            MESA_ROCK_ISLANDS = getRegisteredBiome("mesa_rock_islands");
            MESA_CLEAR_ROCK_ISLANDS = getRegisteredBiome("mesa_clear_rock_islands");
            /*
            MUTATED_PLAINS_ISLANDS = getRegisteredBiome("mutated_plains_islands");
            MUTATED_DESERT_ISLANDS = getRegisteredBiome("mutated_desert_islands");
            MUTATED_EXTREME_HILLS_ISLANDS = getRegisteredBiome("mutated_extreme_hills_islands");
            MUTATED_FOREST_ISLANDS = getRegisteredBiome("mutated_forest_islands");
            MUTATED_TAIGA_ISLANDS = getRegisteredBiome("mutated_taiga_islands");
            MUTATED_SWAMPLAND_ISLANDS = getRegisteredBiome("mutated_swampland_islands");
            MUTATED_ICE_FLATS_ISLANDS = getRegisteredBiome("mutated_ice_flats_islands");
            MUTATED_JUNGLE_ISLANDS = getRegisteredBiome("mutated_jungle_islands");
            MUTATED_JUNGLE_EDGE_ISLANDS = getRegisteredBiome("mutated_jungle_edge_islands");
            MUTATED_BIRCH_FOREST_ISLANDS = getRegisteredBiome("mutated_birch_forest_islands");
            MUTATED_BIRCH_FOREST_HILLS_ISLANDS = getRegisteredBiome("mutated_birch_forest_hills_islands");
            MUTATED_ROOFED_FOREST_ISLANDS = getRegisteredBiome("mutated_roofed_forest_islands");
            MUTATED_TAIGA_COLD_ISLANDS = getRegisteredBiome("mutated_taiga_cold_islands");
            MUTATED_REDWOOD_TAIGA_ISLANDS = getRegisteredBiome("mutated_redwood_taiga_islands");
            MUTATED_REDWOOD_TAIGA_HILLS_ISLANDS = getRegisteredBiome("mutated_redwood_taiga_hills_islands");
            MUTATED_EXTREME_HILLS_WITH_TREES_ISLANDS = getRegisteredBiome("mutated_extreme_hills_with_trees_islands");
            MUTATED_SAVANNA_ISLANDS = getRegisteredBiome("mutated_savanna_islands");
            MUTATED_SAVANNA_ROCK_ISLANDS = getRegisteredBiome("mutated_savanna_rock_islands");
            //MUTATED_MESA_ISLANDS = getRegisteredBiome("mutated_mesa_islands");
            MUTATED_MESA_ROCK_ISLANDS = getRegisteredBiome("mutated_mesa_rock_islands");
            MUTATED_MESA_CLEAR_ROCK_ISLANDS = getRegisteredBiome("mutated_mesa_clear_rock_islands");
            */
            
            MOUNTAIN_OCEAN = getRegisteredBiome("extreme_hills_ocean");
            OCEAN = getRegisteredBiome("ocean");
            PLAINS_OCEAN = getRegisteredBiome("plains_ocean");
            DESERT_OCEAN = getRegisteredBiome("desert_ocean");
            EXTREME_HILLS_OCEAN = getRegisteredBiome("extreme_hills_ocean");
            FOREST_OCEAN = getRegisteredBiome("forest_ocean");
            TAIGA_OCEAN = getRegisteredBiome("taiga_ocean");
            SWAMPLAND_OCEAN = getRegisteredBiome("swampland_ocean");
            ICE_PLAINS_OCEAN = getRegisteredBiome("ice_flats_ocean");
            ICE_MOUNTAINS_OCEAN = getRegisteredBiome("ice_mountains_ocean");
            MUSHROOM_ISLAND_OCEAN = getRegisteredBiome("mushroom_island_ocean");
            DESERT_HILLS_OCEAN = getRegisteredBiome("desert_hills_ocean");
            FOREST_HILLS_OCEAN = getRegisteredBiome("forest_hills_ocean");
            TAIGA_HILLS_OCEAN = getRegisteredBiome("taiga_hills_ocean");
            EXTREME_HILLS_EDGE_OCEAN = getRegisteredBiome("smaller_extreme_hills_ocean");
            JUNGLE_OCEAN = getRegisteredBiome("jungle_ocean");
            JUNGLE_HILLS_OCEAN = getRegisteredBiome("jungle_hills_ocean");
            DEEP_OCEAN = getRegisteredBiome("deep_ocean");
            BIRCH_FOREST_OCEAN = getRegisteredBiome("birch_forest_ocean");
            BIRCH_FOREST_HILLS_OCEAN = getRegisteredBiome("birch_forest_hills_ocean");
            ROOFED_FOREST_OCEAN = getRegisteredBiome("roofed_forest_ocean");
            COLD_TAIGA_OCEAN = getRegisteredBiome("taiga_cold_ocean");
            COLD_TAIGA_HILLS_OCEAN = getRegisteredBiome("taiga_cold_hills_ocean");
            REDWOOD_TAIGA_OCEAN = getRegisteredBiome("redwood_taiga_ocean");
            REDWOOD_TAIGA_HILLS_OCEAN = getRegisteredBiome("redwood_taiga_hills_ocean");
            EXTREME_HILLS_WITH_TREES_OCEAN = getRegisteredBiome("extreme_hills_with_trees_ocean");
            SAVANNA_OCEAN = getRegisteredBiome("savanna_ocean");
            SAVANNA_PLATEAU_OCEAN = getRegisteredBiome("savanna_rock_ocean");
            MESA_OCEAN = getRegisteredBiome("mesa_ocean");
            MESA_ROCK_OCEAN = getRegisteredBiome("mesa_rock_ocean");
            MESA_CLEAR_ROCK_OCEAN = getRegisteredBiome("mesa_clear_rock_ocean");
            /*
            MUTATED_PLAINS_OCEAN = getRegisteredBiome("mutated_plains_ocean");
            MUTATED_DESERT_OCEAN = getRegisteredBiome("mutated_desert_ocean");
            MUTATED_EXTREME_HILLS_OCEAN = getRegisteredBiome("mutated_extreme_hills_ocean");
            MUTATED_FOREST_OCEAN = getRegisteredBiome("mutated_forest_ocean");
            MUTATED_TAIGA_OCEAN = getRegisteredBiome("mutated_taiga_ocean");
            MUTATED_SWAMPLAND_OCEAN = getRegisteredBiome("mutated_swampland_ocean");
            MUTATED_ICE_FLATS_OCEAN = getRegisteredBiome("mutated_ice_flats_ocean");
            MUTATED_JUNGLE_OCEAN = getRegisteredBiome("mutated_jungle_ocean");
            MUTATED_JUNGLE_EDGE_OCEAN = getRegisteredBiome("mutated_jungle_edge_ocean");
            MUTATED_BIRCH_FOREST_OCEAN = getRegisteredBiome("mutated_birch_forest_ocean");
            MUTATED_BIRCH_FOREST_HILLS_OCEAN = getRegisteredBiome("mutated_birch_forest_hills_ocean");
            MUTATED_ROOFED_FOREST_OCEAN = getRegisteredBiome("mutated_roofed_forest_ocean");
            MUTATED_TAIGA_COLD_OCEAN = getRegisteredBiome("mutated_taiga_cold_ocean");
            MUTATED_REDWOOD_TAIGA_OCEAN = getRegisteredBiome("mutated_redwood_taiga_ocean");
            MUTATED_REDWOOD_TAIGA_HILLS_OCEAN = getRegisteredBiome("mutated_redwood_taiga_hills_ocean");
            MUTATED_EXTREME_HILLS_WITH_TREES_OCEAN = getRegisteredBiome("mutated_extreme_hills_with_trees_ocean");
            MUTATED_SAVANNA_OCEAN = getRegisteredBiome("mutated_savanna_ocean");
            MUTATED_SAVANNA_ROCK_OCEAN = getRegisteredBiome("mutated_savanna_rock_ocean");
            //MUTATED_MESA_OCEAN = getRegisteredBiome("mutated_mesa_ocean");
            MUTATED_MESA_ROCK_OCEAN = getRegisteredBiome("mutated_mesa_rock_ocean");
            MUTATED_MESA_CLEAR_ROCK_OCEAN = getRegisteredBiome("mutated_mesa_clear_rock_ocean");
            */
            
            Iterator<Biome> islandOceanIter = OceanBiome.ISLAND_OCEAN_BIOMES_LIST.iterator();
            while(islandOceanIter.hasNext()) {
            	Biome oceanBiome = islandOceanIter.next();
            	if(oceanBiome.equals(Biomes.OCEAN) || oceanBiome.equals(Biomes.DEEP_OCEAN)) {
            		OceanBiome.OCEAN_TO_ISLAND_MAP.put(oceanBiome, oceanBiome);
            	} else {
            		Biome islandBiome = Biome.getBiomeForId(Biome.getIdForBiome(oceanBiome)+128);
            		OceanBiome.OCEAN_TO_ISLAND_MAP.put(oceanBiome, islandBiome);
            	}
            }
        }
    }
}
