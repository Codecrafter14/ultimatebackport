
package net.mcreator.nether.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.nether.ElementsNetherMod;

@ElementsNetherMod.ModElement.Tag
public class EntityStrider extends ElementsNetherMod.ModElement {
	public static final int ENTITYID = 7;
	public static final int ENTITYID_RANGED = 8;
	public EntityStrider(ElementsNetherMod instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("nether", "strider"), ENTITYID)
				.name("strider").tracker(64, 3, true).egg(-13434829, -16777114).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("nether:basalt_delta")),
				Biome.REGISTRY.getObject(new ResourceLocation("nether:crimsonforest")),
				Biome.REGISTRY.getObject(new ResourceLocation("nether:nether_biome")),};
		EntityRegistry.addSpawn(EntityCustom.class, 20, 4, 4, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelstrider(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nether:textures/strider_suffocated.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 0;
			this.isImmuneToFire = true;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAILeapAtTarget(this, (float) 0.5));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public boolean processInteract(EntityPlayer entity, EnumHand hand) {
			super.processInteract(entity, hand);
			entity.startRiding(this);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			ItemStack itemstack = entity.getHeldItem(hand);
			return true;
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}

		@Override
		public void travel(float ti, float tj, float tk) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
				this.renderYawOffset = entity.rotationYaw;
				this.rotationYawHead = entity.rotationYaw;
				this.stepHeight = 1.0F;
				if (entity instanceof EntityLivingBase) {
					this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
					float forward = 0;
					float strafe = ((EntityLivingBase) entity).moveStrafing;
					super.travel(strafe, 0, forward);
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.posX - this.prevPosX;
				double d0 = this.posZ - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
				return;
			}
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(ti, tj, tk);
		}
	}

	// Made with Blockbench 3.8.2
	// Exported for Minecraft version 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelstrider extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer right_bristles_1;
		private final ModelRenderer left_bristles_1;
		private final ModelRenderer right_bristles_2;
		private final ModelRenderer left_bristles_2;
		private final ModelRenderer right_bristles_3;
		private final ModelRenderer left_bristles_3;
		private final ModelRenderer right_leg;
		private final ModelRenderer left_leg;
		public Modelstrider() {
			textureWidth = 64;
			textureHeight = 128;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 7.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 0, 0, -8.0F, -14.0F, -8.0F, 16, 14, 16, 0.0F, false));
			right_bristles_1 = new ModelRenderer(this);
			right_bristles_1.setRotationPoint(-8.0F, -13.0F, 0.0F);
			body.addChild(right_bristles_1);
			setRotationAngle(right_bristles_1, 0.0F, 0.0F, -1.0472F);
			right_bristles_1.cubeList.add(new ModelBox(right_bristles_1, 4, 33, -12.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, true));
			left_bristles_1 = new ModelRenderer(this);
			left_bristles_1.setRotationPoint(8.0F, -13.0F, 0.0F);
			body.addChild(left_bristles_1);
			setRotationAngle(left_bristles_1, 0.0F, 0.0F, 1.0472F);
			left_bristles_1.cubeList.add(new ModelBox(left_bristles_1, 4, 33, 0.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, false));
			right_bristles_2 = new ModelRenderer(this);
			right_bristles_2.setRotationPoint(-8.0F, -9.0F, 0.0F);
			body.addChild(right_bristles_2);
			setRotationAngle(right_bristles_2, 0.0F, 0.0F, -1.0472F);
			right_bristles_2.cubeList.add(new ModelBox(right_bristles_2, 4, 49, -12.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, true));
			left_bristles_2 = new ModelRenderer(this);
			left_bristles_2.setRotationPoint(8.0F, -9.0F, 0.0F);
			body.addChild(left_bristles_2);
			setRotationAngle(left_bristles_2, 0.0F, 0.0F, 1.0472F);
			left_bristles_2.cubeList.add(new ModelBox(left_bristles_2, 4, 49, 0.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, false));
			right_bristles_3 = new ModelRenderer(this);
			right_bristles_3.setRotationPoint(-8.0F, -4.0F, 0.0F);
			body.addChild(right_bristles_3);
			setRotationAngle(right_bristles_3, 0.0F, 0.0F, -1.0472F);
			right_bristles_3.cubeList.add(new ModelBox(right_bristles_3, 4, 65, -12.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, true));
			left_bristles_3 = new ModelRenderer(this);
			left_bristles_3.setRotationPoint(8.0F, -4.0F, 0.0F);
			body.addChild(left_bristles_3);
			setRotationAngle(left_bristles_3, 0.0F, 0.0F, 1.0472F);
			left_bristles_3.cubeList.add(new ModelBox(left_bristles_3, 4, 65, 0.0F, 0.0F, -8.0F, 12, 0, 16, 0.0F, false));
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(-4.0F, 7.0F, 0.0F);
			right_leg.cubeList.add(new ModelBox(right_leg, 0, 32, -2.0F, 0.0F, -2.0F, 4, 17, 4, 0.0F, false));
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(4.0F, 7.0F, 0.0F);
			left_leg.cubeList.add(new ModelBox(left_leg, 0, 32, -2.0F, 0.0F, -2.0F, 4, 17, 4, 0.0F, true));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			right_leg.render(f5);
			left_leg.render(f5);
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
}
