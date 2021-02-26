// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelRocketTier2 extends EntityModel<Entity> {
	private final ModelRenderer Rocket;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;

	public ModelRocketTier2() {
		textureWidth = 512;
		textureHeight = 256;

		Rocket = new ModelRenderer(this);
		Rocket.setRotationPoint(0.0F, 23.0F, 0.0F);
		Rocket.setTextureOffset(273, 90).addBox(4.0F, -36.0F, -8.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(85, 46).addBox(3.0F, -36.0F, -8.1F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(86, 47).addBox(-4.0F, -36.0F, -8.1F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(87, 52).addBox(-3.0F, -36.0F, -8.1F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(89, 52).addBox(-3.0F, -30.0F, -8.1F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(279, 130).addBox(-7.0F, -36.0F, -8.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 80).addBox(-7.0F, -29.0F, -8.0F, 14.0F, 5.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 82).addBox(-7.0F, -41.0F, -8.0F, 14.0F, 5.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 82).addBox(-7.0F, -41.0F, 7.0F, 14.0F, 5.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(274, 84).addBox(-7.0F, -46.0F, -8.0F, 14.0F, 5.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 82).addBox(-7.0F, -46.0F, 7.0F, 14.0F, 5.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(274, 85).addBox(-7.0F, -51.0F, -8.0F, 14.0F, 5.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 80).addBox(-7.0F, -51.0F, 7.0F, 14.0F, 5.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(276, 135).addBox(-7.0F, -24.0F, -8.0F, 14.0F, 19.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(136, 136).addBox(-2.0F, -14.0F, -12.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(136, 136).addBox(-12.0F, -14.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(136, 136).addBox(-2.0F, -14.0F, 8.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(136, 136).addBox(8.0F, -14.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(73, 156).addBox(-2.0F, -15.0F, -12.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(73, 156).addBox(-12.0F, -15.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(73, 156).addBox(-2.0F, -15.0F, 8.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(73, 156).addBox(8.0F, -15.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(73, 134).addBox(-2.0F, -16.0F, -12.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(73, 134).addBox(-12.0F, -16.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(73, 134).addBox(-2.0F, -16.0F, 8.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(73, 134).addBox(8.0F, -16.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(-0.5F, -9.0F, -12.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(-12.1F, -9.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(-0.5F, -9.0F, 11.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(11.1F, -9.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(-2.1F, -9.0F, -10.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(-10.5F, -9.0F, 1.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(1.1F, -9.0F, 9.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(9.5F, -9.0F, -2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(1.1F, -9.0F, -10.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(-10.5F, -9.0F, -2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(-2.1F, -9.0F, 9.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(9.5F, -9.0F, 1.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(57, 137).addBox(-0.5F, -9.0F, -12.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(279, 120).addBox(-7.0F, -36.0F, 7.0F, 14.0F, 31.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(276, 107).addBox(-8.0F, -36.0F, -7.0F, 1.0F, 31.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 68).addBox(7.0F, -39.0F, -7.0F, 1.0F, 3.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(274, 81).addBox(-8.0F, -39.0F, -7.0F, 1.0F, 3.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 68).addBox(7.0F, -42.0F, -7.0F, 1.0F, 3.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(274, 80).addBox(-8.0F, -42.0F, -7.0F, 1.0F, 3.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 68).addBox(7.0F, -45.0F, -7.0F, 1.0F, 3.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 76).addBox(-8.0F, -45.0F, -7.0F, 1.0F, 3.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 68).addBox(7.0F, -48.0F, -7.0F, 1.0F, 3.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 68).addBox(-8.0F, -48.0F, -7.0F, 1.0F, 3.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 68).addBox(7.0F, -51.0F, -7.0F, 1.0F, 3.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(275, 68).addBox(-8.0F, -51.0F, -7.0F, 1.0F, 3.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(307, 78).addBox(-8.0F, -37.0F, -8.0F, 1.0F, 32.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(307, 78).addBox(-8.0F, -37.0F, 7.0F, 1.0F, 32.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(37, 23).addBox(-7.0F, -52.0F, 7.0F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(37, 23).addBox(-7.0F, -52.0F, -8.0F, 14.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(29, 17).addBox(-8.0F, -52.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(29, 17).addBox(7.0F, -52.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(307, 78).addBox(7.0F, -37.0F, 7.0F, 1.0F, 32.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(307, 78).addBox(7.0F, -52.0F, 7.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(307, 78).addBox(-8.0F, -52.0F, 7.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(307, 78).addBox(-8.0F, -52.0F, -8.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(307, 78).addBox(7.0F, -52.0F, -8.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(307, 78).addBox(7.0F, -37.0F, -8.0F, 1.0F, 32.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(276, 110).addBox(7.0F, -36.0F, -7.0F, 1.0F, 31.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(33, 87).addBox(4.0F, -53.0F, -7.0F, 2.0F, 1.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(33, 87).addBox(6.0F, -53.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
		Rocket.setTextureOffset(33, 87).addBox(-7.0F, -53.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-7.0F, -53.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(6.0F, -53.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(5.0F, -54.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(5.0F, -55.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(4.0F, -57.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(4.0F, -56.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(4.0F, -57.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(4.0F, -56.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-5.0F, -57.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-4.0F, -59.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-3.0F, -61.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-3.0F, -60.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(2.0F, -61.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(2.0F, -60.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-3.0F, -61.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-2.0F, -62.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-2.0F, -63.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-2.0F, -62.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-2.0F, -63.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(1.0F, -62.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(1.0F, -63.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(1.0F, -62.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(1.0F, -63.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-3.0F, -60.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(2.0F, -61.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(2.0F, -60.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-4.0F, -58.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-4.0F, -59.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-4.0F, -58.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(3.0F, -59.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(3.0F, -58.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(3.0F, -59.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(3.0F, -58.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-5.0F, -56.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-5.0F, -57.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-5.0F, -56.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-6.0F, -54.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-6.0F, -55.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(5.0F, -54.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(5.0F, -55.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-6.0F, -54.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-6.0F, -55.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(-7.0F, -53.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(249, 94).addBox(6.0F, -53.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(31, 17).addBox(4.0F, -5.0F, -8.0F, 4.0F, 1.0F, 16.0F, 0.0F, false);
		Rocket.setTextureOffset(31, 17).addBox(3.0F, -52.0F, -7.0F, 4.0F, 1.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(64, 5).addBox(-1.0F, -80.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Rocket.setTextureOffset(500, 146).addBox(-1.0F, -78.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
		Rocket.setTextureOffset(64, 102).addBox(-1.0F, -62.0F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(64, 102).addBox(-1.0F, -63.0F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(64, 102).addBox(-2.0F, -62.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Rocket.setTextureOffset(64, 102).addBox(-2.0F, -63.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Rocket.setTextureOffset(64, 102).addBox(1.0F, -62.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Rocket.setTextureOffset(64, 102).addBox(1.0F, -63.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 110).addBox(-3.0F, -61.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 110).addBox(-3.0F, -60.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 110).addBox(-2.0F, -61.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 110).addBox(-2.0F, -60.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 110).addBox(-2.0F, -61.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 110).addBox(-2.0F, -60.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 88).addBox(-3.0F, -59.0F, -4.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 88).addBox(-3.0F, -58.0F, -4.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 88).addBox(3.0F, -59.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 88).addBox(3.0F, -58.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 88).addBox(-4.0F, -59.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Rocket.setTextureOffset(88, 88).addBox(-4.0F, -58.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Rocket.setTextureOffset(75, 97).addBox(-4.0F, -57.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		Rocket.setTextureOffset(75, 97).addBox(-4.0F, -56.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		Rocket.setTextureOffset(75, 97).addBox(-5.0F, -57.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		Rocket.setTextureOffset(75, 97).addBox(-5.0F, -56.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		Rocket.setTextureOffset(75, 97).addBox(4.0F, -57.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		Rocket.setTextureOffset(75, 97).addBox(4.0F, -56.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		Rocket.setTextureOffset(65, 106).addBox(-5.0F, -54.0F, -6.0F, 10.0F, 1.0F, 12.0F, 0.0F, false);
		Rocket.setTextureOffset(65, 106).addBox(-5.0F, -55.0F, -6.0F, 10.0F, 1.0F, 12.0F, 0.0F, false);
		Rocket.setTextureOffset(65, 106).addBox(-6.0F, -54.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		Rocket.setTextureOffset(65, 106).addBox(-6.0F, -55.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		Rocket.setTextureOffset(65, 106).addBox(5.0F, -54.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		Rocket.setTextureOffset(65, 106).addBox(5.0F, -55.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		Rocket.setTextureOffset(66, 94).addBox(-6.0F, -53.0F, -7.0F, 10.0F, 1.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(416, 22).addBox(-7.0F, -5.0F, -6.0F, 11.0F, 1.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(30, 14).addBox(-7.0F, -52.0F, -7.0F, 10.0F, 1.0F, 14.0F, 0.0F, false);
		Rocket.setTextureOffset(43, 17).addBox(-7.0F, -5.0F, -8.0F, 11.0F, 1.0F, 2.0F, 0.0F, false);
		Rocket.setTextureOffset(27, 15).addBox(-8.0F, -5.0F, -8.0F, 1.0F, 1.0F, 16.0F, 0.0F, false);
		Rocket.setTextureOffset(33, 23).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		Rocket.setTextureOffset(30, 23).addBox(-3.0F, -3.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Rocket.setTextureOffset(14, 2).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 0.0F, 6.0F, 0.0F, false);
		Rocket.setTextureOffset(33, 29).addBox(-4.0F, -2.0F, 3.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(37, 26).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(45, 20).addBox(3.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Rocket.setTextureOffset(37, 20).addBox(-4.0F, -2.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Rocket.setTextureOffset(34, 17).addBox(2.0F, -3.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Rocket.setTextureOffset(39, 26).addBox(-2.0F, -3.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(40, 11).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(34, 30).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(32, 16).addBox(-5.0F, -1.0F, 4.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		Rocket.setTextureOffset(34, 23).addBox(4.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		Rocket.setTextureOffset(34, 17).addBox(-5.0F, -1.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(8.0F, 0.0F, 3.0F);
		Rocket.addChild(bone);
		setRotationAngle(bone, 0.0F, 0.8727F, 0.0F);
		bone.setTextureOffset(43, 17).addBox(7.0F, -11.0F, -8.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(43, 17).addBox(10.0F, -9.0F, -8.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(43, 17).addBox(9.0F, -10.0F, -8.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(43, 17).addBox(11.0F, -7.0F, -8.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(43, 17).addBox(12.0F, -7.0F, -8.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(43, 17).addBox(13.0F, -11.0F, -8.0F, 1.0F, 13.0F, 2.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(8.0F, 0.0F, 3.0F);
		Rocket.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.8727F, 0.0F);
		bone2.setTextureOffset(43, 17).addBox(-14.8917F, -11.0F, -9.9549F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-4.8F, -11.0F, 2.1117F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-2.9F, -11.0F, -19.8502F, 2.0F, 6.0F, 2.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-16.8917F, -9.0F, -9.9549F, 1.0F, 6.0F, 2.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-4.8F, -9.0F, 5.1117F, 2.0F, 6.0F, 1.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-2.9F, -9.0F, -21.8502F, 2.0F, 6.0F, 1.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-15.8917F, -10.0F, -9.9549F, 1.0F, 6.0F, 2.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-4.8F, -10.0F, 4.1117F, 2.0F, 6.0F, 1.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-2.9F, -10.0F, -20.8502F, 2.0F, 6.0F, 1.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-17.8917F, -7.0F, -9.9549F, 1.0F, 6.0F, 2.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-4.8F, -7.0F, 6.1117F, 2.0F, 6.0F, 1.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-2.9F, -7.0F, -22.8502F, 2.0F, 6.0F, 1.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-18.8917F, -7.0F, -9.9549F, 1.0F, 7.0F, 2.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-4.8F, -7.0F, 7.1117F, 2.0F, 7.0F, 1.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-2.9F, -7.0F, -23.8502F, 2.0F, 7.0F, 1.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-19.8917F, -11.0F, -9.9549F, 1.0F, 13.0F, 2.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-4.8F, -11.0F, 8.1117F, 2.0F, 13.0F, 1.0F, 0.0F, true);
		bone2.setTextureOffset(43, 17).addBox(-2.9F, -11.0F, -24.8502F, 2.0F, 13.0F, 1.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Rocket.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}