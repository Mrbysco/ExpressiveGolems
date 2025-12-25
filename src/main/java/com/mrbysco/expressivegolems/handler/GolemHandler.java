package com.mrbysco.expressivegolems.handler;

import com.mrbysco.expressivegolems.GolemFace;
import com.mrbysco.expressivegolems.registry.ExpressiveAttachments;
import net.minecraft.world.entity.animal.SnowGolem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityEvent;

@EventBusSubscriber
public class GolemHandler {

	@SubscribeEvent
	public static void onGolemSpawn(EntityEvent.EntityConstructing event) {
		if (event.getEntity() instanceof SnowGolem snowGolem) {
			snowGolem.setData(ExpressiveAttachments.FACE, GolemFace.getRandomFace());
			snowGolem.syncData(ExpressiveAttachments.FACE);
		}
	}
}
