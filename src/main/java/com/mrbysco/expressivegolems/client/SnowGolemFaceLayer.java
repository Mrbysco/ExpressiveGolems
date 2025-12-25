package com.mrbysco.expressivegolems.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mrbysco.expressivegolems.GolemFace;
import net.minecraft.client.model.animal.golem.SnowGolemModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.SnowGolemRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;

public class SnowGolemFaceLayer extends RenderLayer<SnowGolemRenderState, SnowGolemModel> {
	private GolemFace cachedFace = GolemFace.DEFAULT;
	private RenderType FACE_RENDER_TYPE = RenderTypes.eyes(GolemFace.DEFAULT.getTextureLocation());

	public SnowGolemFaceLayer(RenderLayerParent<SnowGolemRenderState, SnowGolemModel> renderer) {
		super(renderer);
	}

	public void submit(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight,
	                   SnowGolemRenderState renderState, float yRot, float xRot) {
		if (!renderState.isInvisible || renderState.appearsGlowing()) {
			GolemFace face = renderState.getRenderData(ClientHandler.GOLEM_FACE);
			if (face != null && face != GolemFace.DEFAULT) {
				if (face != this.cachedFace) {
					this.cachedFace = face;
					this.FACE_RENDER_TYPE = RenderTypes.eyes(cachedFace.getTextureLocation());
				}

				if (this.FACE_RENDER_TYPE == null) {
					this.FACE_RENDER_TYPE = RenderTypes.eyes(cachedFace.getTextureLocation());
				}

				nodeCollector.order(1)
						.submitModel(
								this.getParentModel(), renderState, poseStack, FACE_RENDER_TYPE,
								packedLight, OverlayTexture.NO_OVERLAY, -1, null,
								renderState.outlineColor, null
						);
			}
		}
	}
}
