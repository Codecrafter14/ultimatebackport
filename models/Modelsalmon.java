// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelsalmon extends EntityModel<Entity> {
	private final ModelRenderer body_front;
	private final ModelRenderer body_back;
	private final ModelRenderer dorsal_back;
	private final ModelRenderer tailfin;
	private final ModelRenderer dorsal_front;
	private final ModelRenderer head;
	private final ModelRenderer leftFin;
	private final ModelRenderer rightFin;

	public Modelsalmon() {
		textureWidth = 32;
		textureHeight = 32;

		body_front = new ModelRenderer(this);
		body_front.setRotationPoint(0.0F, 24.0F, -4.0F);
		body_front.setTextureOffset(0, 0).addBox(-1.5F, -8.5F, 0.0F, 3.0F, 5.0F, 8.0F, 0.0F, false);

		body_back = new ModelRenderer(this);
		body_back.setRotationPoint(0.0F, 0.0F, 8.0F);
		body_front.addChild(body_back);
		body_back.setTextureOffset(0, 13).addBox(-1.5F, -8.5F, 0.0F, 3.0F, 5.0F, 8.0F, 0.0F, false);

		dorsal_back = new ModelRenderer(this);
		dorsal_back.setRotationPoint(0.0F, -5.0F, 0.0F);
		body_back.addChild(dorsal_back);
		dorsal_back.setTextureOffset(2, 3).addBox(0.0F, -5.5F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, false);

		tailfin = new ModelRenderer(this);
		tailfin.setRotationPoint(0.0F, 0.0F, 8.0F);
		body_back.addChild(tailfin);
		tailfin.setTextureOffset(20, 10).addBox(0.0F, -8.5F, 0.0F, 0.0F, 5.0F, 6.0F, 0.0F, false);

		dorsal_front = new ModelRenderer(this);
		dorsal_front.setRotationPoint(0.0F, -5.0F, 6.0F);
		body_front.addChild(dorsal_front);
		dorsal_front.setTextureOffset(4, 2).addBox(0.0F, -5.5F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -3.0F, 0.0F);
		body_front.addChild(head);
		head.setTextureOffset(22, 0).addBox(-1.0F, -5.5F, -3.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		leftFin = new ModelRenderer(this);
		leftFin.setRotationPoint(1.5F, -1.0F, 0.0F);
		body_front.addChild(leftFin);
		setRotationAngle(leftFin, 0.0F, 0.0F, 0.6109F);
		leftFin.setTextureOffset(2, 0).addBox(-2.0075F, -2.867F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);

		rightFin = new ModelRenderer(this);
		rightFin.setRotationPoint(-1.5F, -1.0F, 0.0F);
		body_front.addChild(rightFin);
		setRotationAngle(rightFin, 0.0F, 0.0F, -0.6109F);
		rightFin.setTextureOffset(-2, 0).addBox(0.0074F, -2.867F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body_front.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}