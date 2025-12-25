package com.mrbysco.expressivegolems.registry;

import com.mrbysco.expressivegolems.ExpressiveGolems;
import com.mrbysco.expressivegolems.GolemFace;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

@EventBusSubscriber
public class ExpressiveAttachments {
	private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, ExpressiveGolems.MOD_ID);

	public static final Supplier<AttachmentType<GolemFace>> FACE = ATTACHMENT_TYPES.register("face", () ->
			AttachmentType.builder(() -> GolemFace.DEFAULT).serialize(GolemFace.CODEC.fieldOf("id")).build());

	public static void register(IEventBus eventBus) {
		ATTACHMENT_TYPES.register(eventBus);
	}

}
