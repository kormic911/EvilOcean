package net.flawedlogic.EvilOcean.generators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTreasure extends WorldGenerator {
	private int maxChestDist = 2;

	public boolean generate(World world, Random random, BlockPos pos) {
		return this.generate(world, random, pos.getX(), pos.getY(), pos.getZ());
	}
	
	public boolean generate(World world, Random par2Random, int xCoord, int yCoord, int zCoord) {
		int x = xCoord + par2Random.nextInt(8) - par2Random.nextInt(8);
		int y = yCoord;
		int z = zCoord + par2Random.nextInt(8) - par2Random.nextInt(8);

		for (; y > 50; --y) {
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			if ((hasNoAirAround(world, x, y, z)) && (world.isAirBlock(new BlockPos(x, y + 1, z))) && (((block == Blocks.grass) || (block == Blocks.sand)))) {
				world.setBlockState(new BlockPos(x, y, z), getBlock(block).getDefaultState());
				createChest(world, x, y, z, par2Random);
				return true;
			}
			if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.water) {
				return false;
			}
		}
		return false;
	}

	private boolean hasNoAirAround(World world, int x, int y, int z) {
		for (int x1 = x - 1; x1 <= x + 1; ++x1) {
			if (world.isAirBlock(new BlockPos(x1, y, z))) {
				return false;
			}
		}
		for (int z1 = z - 1; z1 <= z + 1; ++z1) {
			if (world.isAirBlock(new BlockPos(x, y, z1))) {
				return false;
			}
		}
		return true;
	}

	private Block getBlock(Block block) {
		if (block == Blocks.grass)
			return Blocks.grass;
		if (block == Blocks.sand) {
			return Blocks.sand;
		}
		return Blocks.cobblestone;
	}

	private boolean createChest(World world, int signX, int signY, int signZ, Random random) {
		int x = signX + random.nextInt(this.maxChestDist) - random.nextInt(this.maxChestDist);
		int y = signY - random.nextInt(10);
		int z = signZ + random.nextInt(this.maxChestDist) - random.nextInt(this.maxChestDist);

		for (int i = 0; i < 10; ++i) {
			if ((world.getBlockState(new BlockPos(x, y, z)).getBlock().isNormalCube()) && (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock().isNormalCube()) && (world.getBlockState(new BlockPos(x - 1, y, z)).getBlock().isNormalCube()) && (world.getBlockState(new BlockPos(x + 1, y, z)).getBlock().isNormalCube()) && (world.getBlockState(new BlockPos(x, y, z - 1)).getBlock().isNormalCube()) && (world.getBlockState(new BlockPos(x, y, z + 1)).getBlock().isNormalCube())) {
				world.setBlockState(new BlockPos(x, y, z), Blocks.chest.getDefaultState());
				TileEntityChest tileentitychest = (TileEntityChest) world.getTileEntity(new BlockPos(x, y, z));

				if (tileentitychest == null) {
					break;
				}

				for (int a = 0; a < 5; ++a) {
					ItemStack itemstack = getLoot(random);

					if (itemstack == null)
						continue;
					tileentitychest.setInventorySlotContents(random.nextInt(tileentitychest.getSizeInventory()), itemstack);
				}

				return true;
			}
			if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.water) {
				x = signX + random.nextInt(this.maxChestDist) - random.nextInt(this.maxChestDist);
				y = signY;
				z = signZ + random.nextInt(this.maxChestDist) - random.nextInt(this.maxChestDist);
			} else {
				y -= 3;
			}
		}
		return false;
	}

	private ItemStack getLoot(Random rand) {
		int i = rand.nextInt(4);

		switch (i) {
		case 0:
			return new ItemStack(Items.gold_nugget, rand.nextInt(4) + 1);
		case 1:
			return new ItemStack(Items.melon_seeds, rand.nextInt(4) + 1);
		case 2:
			return new ItemStack(Items.gold_ingot, rand.nextInt(2) + 1);
		case 3:
			return new ItemStack(Items.golden_apple, 1);
		}
		return null;
	}
}