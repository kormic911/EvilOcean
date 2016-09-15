package net.flawedlogic.EvilOcean.generators;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWaterlilyOcean extends WorldGenerator {
	public boolean generate(World par1World, Random par2Random, BlockPos pos) {
		return this.generate(par1World, par2Random, pos.getX(), pos.getY(), pos.getZ());
	}
	
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
		for (int var6 = 0; var6 < 2; ++var6) {
			int var7 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
			int var8 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
			int var9 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

			if ((!(par1World.isBlockLoaded(new BlockPos(var7, var8, var9)))) || (!(Blocks.WATERLILY.canPlaceBlockAt(par1World, new BlockPos(var7, var8, var9))))) {
				continue;
			}
			par1World.updateComparatorOutputLevel(new BlockPos(var7, var8, var9), Blocks.WATERLILY);
			//par1World.func_147453_f(var7, var8, var9, Blocks.waterlily);
		}

		return true;
	}
}