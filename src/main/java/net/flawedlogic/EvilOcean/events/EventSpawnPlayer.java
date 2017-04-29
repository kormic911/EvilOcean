package net.flawedlogic.EvilOcean.events;

import net.flawedlogic.EvilOcean.EvilOcean;
import net.flawedlogic.EvilOcean.generators.IPlatformGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class EventSpawnPlayer {

	private static final String TAG_MADE_RAFT = "EvilOcean-MadeRaft";
	private static final String TAG_HAS_OWN_RAFT = "EvilOcean-HasOwnRaft";
	private static final String TAG_RAFT_X = "EvilOcean-RaftX";
	private static final String TAG_RAFT_Y = "EvilOcean-RaftY";
	private static final String TAG_RAFT_Z = "EvilOcean-RaftZ";

	@SubscribeEvent
	public void onPlayerLoggedInEvent(PlayerLoggedInEvent event) {
		if((event.player instanceof EntityPlayerMP) && !event.player.worldObj.isRemote) {
			EntityPlayerMP player = (EntityPlayerMP) event.player;
			NBTTagCompound data = player.getEntityData();
			if(!data.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
				data.setTag(EntityPlayer.PERSISTED_NBT_TAG, new NBTTagCompound());
			}
			
			NBTTagCompound persist = data.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
			if(player.ticksExisted < 3 && !persist.getBoolean(TAG_MADE_RAFT) && event.player.worldObj.provider.getDimension() == 0) {
				FMLLog.info("[EvilOcean] Adjusting player spawn");
				adjustPlayerSpawn(player);
				persist.setBoolean(TAG_MADE_RAFT, true);
			}
		}
	}

	private void adjustPlayerSpawn(EntityPlayerMP player) {
		int minDist = 100;
		int maxrange = EvilOcean.instance.spawnSpreadDistance;
		BlockPos pos;
		
		if(player != null) {
			BlockPos spawn = player.worldObj.getSpawnPoint();
			if(EvilOcean.instance.enableSpawnSpread) {
				int x, z;
	
				do {
					x = player.worldObj.rand.nextInt(maxrange) - maxrange / 2 + spawn.getX();
					z = player.worldObj.rand.nextInt(maxrange) - maxrange / 2 + spawn.getZ();
				} while((float) Math.hypot(x - spawn.getX(), z - spawn.getZ()) < minDist);
				
				pos = new BlockPos(x, spawn.getY(), z);
			} else {
				pos = spawn;
			}

			NBTTagCompound data = player.getEntityData();
			if(!data.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
				data.setTag(EntityPlayer.PERSISTED_NBT_TAG, new NBTTagCompound());
			}
			NBTTagCompound persist = data.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
			FMLLog.info("[EvilOcean] Moving player spawn to %s", pos.toString());
			final boolean test = false;
			
			if(test || !persist.getBoolean(TAG_HAS_OWN_RAFT)) {
				this.buildSpawn(player.worldObj, pos.getX(), pos.getY(), pos.getZ());

				if(player instanceof EntityPlayerMP) {
					EntityPlayerMP pmp = (EntityPlayerMP) player;
					pmp.setSpawnPoint(pos, true);
					pmp.setPositionAndUpdate(pos.getX() + 0.5, pos.getY() + 1.6, pos.getZ() + 0.5);
					pmp.setSpawnChunk(pos, true, player.worldObj.provider.getDimension());
				}

				persist.setBoolean(TAG_HAS_OWN_RAFT, true);
				persist.setDouble(TAG_RAFT_X, player.posX);
				persist.setDouble(TAG_RAFT_Y, player.posY);
				persist.setDouble(TAG_RAFT_Z, player.posZ);
			} else {
				double posX = persist.getDouble(TAG_RAFT_X);
				double posY = persist.getDouble(TAG_RAFT_Y);
				double posZ = persist.getDouble(TAG_RAFT_Z);

				if(player instanceof EntityPlayerMP) {
					EntityPlayerMP pmp = (EntityPlayerMP) player;
					pmp.setSpawnPoint(new BlockPos(posX, posY, posZ), true);
					pmp.setPositionAndUpdate(posX, posY, posZ);
				}
			}
		}
	}
	
    private void buildSpawn(World world, int x, int y, int z)
    {
        FMLLog.info("[EvilOcean] Building spawn platform at: %d, %d, %d", x, y, z);
        IPlatformGenerator platform = EvilOcean.instance.getPlatformType(world);
        platform.generate(world, x, y, z);
    }
}
