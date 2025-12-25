package com.mrbysco.expressivegolems.client;

import com.mrbysco.expressivegolems.ExpressiveGolems;
import com.mrbysco.expressivegolems.GolemFace;
import com.mrbysco.expressivegolems.registry.ExpressiveAttachments;
import net.minecraft.client.renderer.entity.SnowGolemRenderer;
import net.minecraft.util.context.ContextKey;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.renderstate.RegisterRenderStateModifiersEvent;

@EventBusSubscriber(Dist.CLIENT)
public class ClientHandler {
	public static final ContextKey<GolemFace> GOLEM_FACE = new ContextKey<>(ExpressiveGolems.modLoc("golem_face"));

	@SubscribeEvent
	public static void registerCustomRenderData(RegisterRenderStateModifiersEvent event) {
		event.registerEntityModifier(SnowGolemRenderer.class, (snowGolem, renderState) -> {
			if (snowGolem.hasData(ExpressiveAttachments.FACE)) {
				GolemFace face = snowGolem.getData(ExpressiveAttachments.FACE);
				renderState.setRenderData(GOLEM_FACE, face);
			} else {
				renderState.setRenderData(GOLEM_FACE, GolemFace.DEFAULT);
			}
		});
	}
}
