package com.mrbysco.expressivegolems;

import com.mojang.logging.LogUtils;
import com.mrbysco.expressivegolems.registry.ExpressiveAttachments;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ExpressiveGolems.MOD_ID)
public class ExpressiveGolems {
	public static final String MOD_ID = "expressive_golems";
	private static final Logger LOGGER = LogUtils.getLogger();

	public ExpressiveGolems(IEventBus eventBus, Dist dist, ModContainer container) {
		ExpressiveAttachments.register(eventBus);
	}

	public static Identifier modLoc(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
