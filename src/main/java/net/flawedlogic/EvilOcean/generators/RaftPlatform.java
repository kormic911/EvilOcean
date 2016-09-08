package net.flawedlogic.EvilOcean.generators;

import net.minecraft.world.World;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;

public class RaftPlatform implements IPlatformGenerator {
	
	@Override
	public void generate(World world, int x, int y, int z)
	{
		if(world.provider.getDimensionId() == 0) {
			buildRaft(world, x, y, z);
		}
	}
	
	private void buildRaft(World world, int x, int y, int z)
	{
		world.setBlockState(new BlockPos(x, y - 2, z), Blocks.wooden_slab.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y - 2, z), Blocks.wooden_slab.getDefaultState());
		world.setBlockState(new BlockPos(x - 1, y - 2, z), Blocks.wooden_slab.getDefaultState());
		
		world.setBlockState(new BlockPos(x, y - 2, z + 1), Blocks.wooden_slab.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y - 2, z + 1), Blocks.wooden_slab.getDefaultState());
		world.setBlockState(new BlockPos(x - 1, y - 2, z + 1), Blocks.wooden_slab.getDefaultState());
		
		world.setBlockState(new BlockPos(x + 2, y - 2, z), Blocks.planks.getDefaultState());
		world.setBlockState(new BlockPos(x - 2, y - 2, z), Blocks.planks.getDefaultState());
		
		world.setBlockState(new BlockPos(x + 2, y - 2, z - 1), Blocks.planks.getDefaultState());
		world.setBlockState(new BlockPos(x - 2, y - 2, z - 1), Blocks.planks.getDefaultState());
		world.setBlockState(new BlockPos(x - 1, y - 2, z - 1), Blocks.planks.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y - 2, z - 1), Blocks.planks.getDefaultState());
		world.setBlockState(new BlockPos(x, y - 2, z - 1), Blocks.planks.getDefaultState());
		
		
		world.setBlockState(new BlockPos(x + 2, y - 2, z + 1), Blocks.planks.getDefaultState());
		world.setBlockState(new BlockPos(x - 2, y - 2, z + 1), Blocks.planks.getDefaultState());
		
		
		world.setBlockState(new BlockPos(x + 2, y - 2, z + 2), Blocks.planks.getDefaultState());
		world.setBlockState(new BlockPos(x - 2, y - 2, z + 2), Blocks.planks.getDefaultState());
		world.setBlockState(new BlockPos(x - 1, y - 2, z + 2), Blocks.planks.getDefaultState());
		world.setBlockState(new BlockPos(x + 1, y - 2, z + 2), Blocks.planks.getDefaultState());
		world.setBlockState(new BlockPos(x, y - 2, z + 2), Blocks.planks.getDefaultState());
		
		
	}
}