package net.flawedlogic.EvilOcean.generators;

import net.minecraft.world.World;
import net.minecraft.init.Blocks;

public class RaftPlatform implements IPlatformGenerator {
	
	@Override
	public void generate(World world, int x, int y, int z)
	{
		if(world.provider.dimensionId == 0) {
			buildRaft(world, x, y, z);
		}
	}
	
	private void buildRaft(World world, int x, int y, int z)
	{
		world.setBlock(x, y - 2, z, Blocks.wooden_slab);
		world.setBlock(x + 1, y - 2, z, Blocks.wooden_slab);
		world.setBlock(x - 1, y - 2, z, Blocks.wooden_slab);
		
		world.setBlock(x, y - 2, z + 1, Blocks.wooden_slab);
		world.setBlock(x + 1, y - 2, z + 1, Blocks.wooden_slab);
		world.setBlock(x - 1, y - 2, z + 1, Blocks.wooden_slab);
		
		world.setBlock(x + 2, y - 2, z, Blocks.planks);
		world.setBlock(x - 2, y - 2, z, Blocks.planks);
		
		world.setBlock(x + 2, y - 2, z - 1, Blocks.planks);
		world.setBlock(x - 2, y - 2, z - 1, Blocks.planks);
		world.setBlock(x - 1, y - 2, z - 1, Blocks.planks);
		world.setBlock(x + 1, y - 2, z - 1, Blocks.planks);
		world.setBlock(x, y - 2, z - 1, Blocks.planks);
		
		
		world.setBlock(x + 2, y - 2, z + 1, Blocks.planks);
		world.setBlock(x - 2, y - 2, z + 1, Blocks.planks);
		
		
		world.setBlock(x + 2, y - 2, z + 2, Blocks.planks);
		world.setBlock(x - 2, y - 2, z + 2, Blocks.planks);
		world.setBlock(x - 1, y - 2, z + 2, Blocks.planks);
		world.setBlock(x + 1, y - 2, z + 2, Blocks.planks);
		world.setBlock(x, y - 2, z + 2, Blocks.planks);
		
		
	}
}