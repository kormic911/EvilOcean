package net.flawedlogic.EvilOcean.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.HasResult;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.SpecialSpawn;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class EventWaterDrown {

	/*
	@SubscribeEvent
	public boolean onLivingAttackEvent(LivingAttackEvent event) {
		if ((event.getEntityLiving() instanceof EntityPlayerMP) && (event.getSource() == DamageSource.drown)  && !event.getEntityLiving().worldObj.isRemote) {
			FMLLog.info("onLivingAttackEvent");
			event.getEntityLiving().setHealth(0.5F);
			return true;
		}
		return false;
	}
	*/
	
	@SubscribeEvent
	public void onLivingHurtEvent(LivingHurtEvent event) {
		if ((event.getEntityLiving() instanceof EntityPlayerMP) && (event.getSource() == DamageSource.drown)  && !event.getEntityLiving().worldObj.isRemote) {
			//FMLLog.info("onLivingHurtEvent");
			event.getEntityLiving().setHealth(0.5F);
		}		
	}
}
