package com.mrbysco.expressivegolems.mixin;

import com.mrbysco.expressivegolems.ExpressiveGolems;
import com.mrbysco.expressivegolems.GolemFace;
import com.mrbysco.expressivegolems.client.ClientHandler;
import com.mrbysco.expressivegolems.client.SnowGolemFaceLayer;
import net.minecraft.client.model.animal.golem.SnowGolemModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SnowGolemRenderer;
import net.minecraft.client.renderer.entity.state.SnowGolemRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SnowGolemRenderer.class)
public abstract class SnowGolemRendererMixin extends MobRenderer<SnowGolem, SnowGolemRenderState, SnowGolemModel> {
	@Unique
	private static final Identifier BLANK_TEXTURE = ExpressiveGolems.modLoc("textures/entity/snow_golem/blank.png");

	public SnowGolemRendererMixin(EntityRendererProvider.Context context, SnowGolemModel model, float shadow) {
		super(context, model, shadow);
	}

	@Inject(method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V",
			at = @At("TAIL"))
	private void ExpressiveGolems$init(EntityRendererProvider.Context context, CallbackInfo ci) {
		this.addLayer(new SnowGolemFaceLayer(this));

	}

	@Inject(method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/SnowGolemRenderState;)Lnet/minecraft/resources/Identifier;",
			at = @At("HEAD"), cancellable = true)
	private void ExpressiveGolems$getTexture(SnowGolemRenderState renderState, CallbackInfoReturnable<Identifier> cir) {
		GolemFace face = renderState.getRenderData(ClientHandler.GOLEM_FACE);
		if (face != null && face != GolemFace.DEFAULT)
			cir.setReturnValue(BLANK_TEXTURE);
	}
}
