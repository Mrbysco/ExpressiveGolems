package com.mrbysco.expressivegolems.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mrbysco.expressivegolems.GolemFace;
import com.mrbysco.expressivegolems.registry.ExpressiveAttachments;
import net.minecraft.client.model.SnowGolemModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.animal.SnowGolem;

public class SnowGolemFaceLayer extends RenderLayer<SnowGolem, SnowGolemModel<SnowGolem>> {
	private GolemFace cachedFace = GolemFace.DEFAULT;
	private RenderType FACE_RENDER_TYPE = RenderType.entityCutout(GolemFace.DEFAULT.getTextureLocation());

	public SnowGolemFaceLayer(RenderLayerParent<SnowGolem, SnowGolemModel<SnowGolem>> renderer) {
		super(renderer);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, SnowGolem snowGolem,
	                   float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks,
	                   float netHeadYaw, float headPitch) {
		GolemFace face = snowGolem.getData(ExpressiveAttachments.FACE);
		if (face != null && face != GolemFace.DEFAULT) {
			if (face != this.cachedFace) {
				this.cachedFace = face;
				this.FACE_RENDER_TYPE = RenderType.entityCutout(cachedFace.getTextureLocation());
			}

			if (this.FACE_RENDER_TYPE == null) {
				this.FACE_RENDER_TYPE = RenderType.entityCutout(cachedFace.getTextureLocation());
			}

			VertexConsumer vertexconsumer = buffer.getBuffer(FACE_RENDER_TYPE);
			this.getParentModel().renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);
		}
	}
}
