package net.flawedlogic.EvilOcean.events;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event.HasResult;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Cancelable
@HasResult
public class EventWaterDrown {
	@SubscribeEvent
	public void onLivingHurtEvent(LivingHurtEvent event) {
		if ((event.entityLiving instanceof EntityPlayerMP) && (event.source == DamageSource.drown)  && !event.entityLiving.worldObj.isRemote) {
			event.entityLiving.setHealth(0.5F);
		}		
	}
}
