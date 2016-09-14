package net.flawedlogic.EvilOcean.biomes;

import net.flawedlogic.EvilOcean.generators.WorldGenTreasure;
import net.flawedlogic.EvilOcean.generators.WorldGenWaterlilyOcean;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class BiomeDecoratorOcean extends BiomeDecorator {

	public BiomeDecoratorOcean() {
		this.waterlilyGen = new WorldGenWaterlilyOcean();
	}

	protected void genDecorations(BiomeGenBase biomes) {
		super.genDecorations(biomes);

		if (this.randomGenerator.nextInt(8) == 0) {
			int x = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int y = 100;
			int z = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			new WorldGenTreasure().generate(this.currentWorld, this.randomGenerator, x, y, z);
		}

		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
	}
}