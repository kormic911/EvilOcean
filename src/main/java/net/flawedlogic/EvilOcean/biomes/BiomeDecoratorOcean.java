package net.flawedlogic.EvilOcean.biomes;

import java.util.Random;

import net.flawedlogic.EvilOcean.generators.WorldGenTreasure;
import net.flawedlogic.EvilOcean.generators.WorldGenWaterlilyOcean;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class BiomeDecoratorOcean extends BiomeDecorator {

	public BiomeDecoratorOcean() {
		this.waterlilyGen = new WorldGenWaterlilyOcean();
	}

	@Override
	protected void genDecorations(Biome biome, World worldIn, Random random) {
		super.genDecorations(biome, worldIn, random);

		if (random.nextInt(8) == 0) {
			int x = this.chunkPos.getX() + random.nextInt(16) + 8;
			int y = 100;
			int z = this.chunkPos.getZ() + random.nextInt(16) + 8;
			new WorldGenTreasure().generate(worldIn, random, x, y, z);
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(worldIn, random, this.chunkPos));
	}
}