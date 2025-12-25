package com.mrbysco.expressivegolems;

import com.mojang.logging.LogUtils;
import com.mrbysco.expressivegolems.registry.ExpressiveAttachments;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ExpressiveGolems.MOD_ID)
public class ExpressiveGolems {
	public static final String MOD_ID = "expressive_golems";
	private static final Logger LOGGER = LogUtils.getLogger();

	public ExpressiveGolems(IEventBus eventBus) {
		ExpressiveAttachments.register(eventBus);
	}

	public static ResourceLocation modLoc(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
