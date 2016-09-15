package net.flawedlogic.EvilOcean.biomes;

public class BiomeGenOceanLilypads extends OceanBiome {
	public BiomeGenOceanLilypads(BiomeProperties biomeProperties) {
		super(biomeProperties);
		this.theBiomeDecorator.waterlilyPerChunk = 1;
	}
}