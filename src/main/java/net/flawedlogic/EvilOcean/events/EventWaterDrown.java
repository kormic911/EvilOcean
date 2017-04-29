package net.flawedlogic.EvilOcean.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.HasResult;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
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
		if ((event.getEntityLiving() instanceof EntityPlayerMP) && (event.getSource() == DamageSource.DROWN)  && !event.getEntityLiving().world.isRemote) {
			event.getEntityLiving().setHealth(0.5F);
		}		
	}
}