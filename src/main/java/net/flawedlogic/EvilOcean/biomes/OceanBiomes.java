package net.flawedlogic.EvilOcean.biomes;

import java.util.logging.Logger;

import org.apache.logging.log4j.Level;

import net.minecraft.init.Bootstrap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.FMLLog;

public abstract class OceanBiomes {
    public static final Biome DESERT_ISLANDS;
    public static final Biome FOREST_ISLANDS;
    public static final Biome MOUNTAIN_ISLANDS;
    public static final Biome JUNGLE_ISLANDS;
    public static final Biome TAIGA_ISLANDS;
    public static final Biome BIRCH_FOREST_ISLANDS;
    public static final Biome ROOFED_FOREST_ISLANDS;
    public static final Biome MESA_ISLANDS;

    public static final Biome OCEAN;
    public static final Biome DEEP_OCEAN;
    public static final Biome DESERT_OCEAN;
    public static final Biome MOUNTAIN_OCEAN;
    public static final Biome FOREST_OCEAN;
    public static final Biome TAIGA_OCEAN;
    public static final Biome JUNGLE_OCEAN;
    public static final Biome BIRCH_FOREST_OCEAN;
    public static final Biome ROOFED_FOREST_OCEAN;
    public static final Biome MESA_OCEAN;
    public static final Biome MEGA_TAIGA_OCEAN;

    private static Biome getRegisteredBiome(String id) {
        FMLLog.log(Level.INFO, "getRegisteredBiome: " + id);
        Biome biome = (Biome) Biome.REGISTRY.getObject(new ResourceLocation(id));

        if ( biome == null ) {
            throw new IllegalStateException("Invalid Biome requested: " + id);
        }
        else {
            return biome;
        }
    }

    static {
        if ( !Bootstrap.isRegistered() ) {
            throw new RuntimeException("Accessed Biomes before Bootstrap!");
        }
        else {
            DESERT_ISLANDS = getRegisteredBiome("desert_islands");
            FOREST_ISLANDS = getRegisteredBiome("forest_islands");
            MOUNTAIN_ISLANDS = getRegisteredBiome("mountain_islands");
            JUNGLE_ISLANDS = getRegisteredBiome("jungle_islands");
            TAIGA_ISLANDS = getRegisteredBiome("taiga_islands");
            BIRCH_FOREST_ISLANDS = getRegisteredBiome("birch_forest_islands");
            ROOFED_FOREST_ISLANDS = getRegisteredBiome("roofed_forest_islands");
            MESA_ISLANDS = getRegisteredBiome("mesa_islands");

            OCEAN = getRegisteredBiome("eo_ocean");
            DEEP_OCEAN = getRegisteredBiome("eo_deep_ocean");
            DESERT_OCEAN = getRegisteredBiome("desert_ocean");
            MOUNTAIN_OCEAN = getRegisteredBiome("mountain_ocean");
            FOREST_OCEAN = getRegisteredBiome("forest_ocean");
            TAIGA_OCEAN = getRegisteredBiome("taiga_ocean");
            JUNGLE_OCEAN = getRegisteredBiome("jungle_ocean");
            BIRCH_FOREST_OCEAN = getRegisteredBiome("birch_forest_ocean");
            ROOFED_FOREST_OCEAN = getRegisteredBiome("roofed_forest_ocean");
            MESA_OCEAN = getRegisteredBiome("mesa_ocean");
            MEGA_TAIGA_OCEAN = getRegisteredBiome("mega_taiga_ocean");
        }
    }
}
