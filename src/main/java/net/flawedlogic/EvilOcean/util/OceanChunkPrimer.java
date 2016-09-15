package net.flawedlogic.EvilOcean.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.ChunkPrimer;

public class OceanChunkPrimer extends ChunkPrimer {
	private final char[] data = new char[65536];
    private static final IBlockState DEFAULT_STATE = Blocks.AIR.getDefaultState();

    @SuppressWarnings("deprecation")
	@Override
    public IBlockState getBlockState(int x, int y, int z)
    {
        IBlockState iblockstate = (IBlockState)Block.BLOCK_STATE_IDS.getByValue(this.data[getBlockIndex(x, y, z)]);
        return iblockstate == null ? DEFAULT_STATE : iblockstate;
    }

    @Override
    public void setBlockState(int x, int y, int z, IBlockState state)
    {
        this.data[getBlockIndex(x, y, z)] = (char)Block.BLOCK_STATE_IDS.get(state);
    }
    
	@SuppressWarnings("deprecation")
	public void setBlockState(int index, IBlockState state) {
		this.data[index] = (char)Block.BLOCK_STATE_IDS.get(state);
	}

    private static int getBlockIndex(int x, int y, int z)
    {
        return x << 12 | z << 8 | y;
    }

	@SuppressWarnings("deprecation")
	@Override
    public int findGroundBlockIdx(int x, int z)
    {
        int i = (x << 12 | z << 8) + 256 - 1;

        for (int j = 255; j >= 0; --j)
        {
            IBlockState iblockstate = (IBlockState)Block.BLOCK_STATE_IDS.getByValue(this.data[i + j]);

            if (iblockstate != null && iblockstate != DEFAULT_STATE)
            {
                return j;
            }
        }

        return 0;
    }
}
