
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.mcreator.nether.procedure.ProcedureHoglinOnEntityTickUpdate;
import net.mcreator.nether.ElementsNetherMod;

import java.util.Map;
import java.util.HashMap;

@ElementsNetherMod.ModElement.Tag
public class EntityHoglin extends ElementsNetherMod.ModElement {
	public static final int ENTITYID = 11;
	public static final int ENTITYID_RANGED = 12;
	public EntityHoglin(ElementsNetherMod instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("nether", "hoglin"), ENTITYID)
				.name("hoglin").tracker(64, 3, true).egg(-26215, -16777216).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("nether:crimsonforest")),};
		EntityRegistry.addSpawn(EntityCustom.class, 20, 4, 4, EnumCreatureType.MONSTER, spawnBiomes);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelhoglin(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("nether:textures/hoglin.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(1.4f, 1.4f);
			experienceValue = 2;
			this.isImmuneToFire = true;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, false));
			this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(3, new EntityAIWander(this, 0.8));
			this.tasks.addTask(4, new EntityAILookIdle(this));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, false));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityPiglinNormal.EntityCustom.class, false, false));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Items.PORKCHOP, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("nether:mob.hoglin.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("nether:mob.hoglin.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("nether:mob.hoglin.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void onEntityUpdate() {
			super.onEntityUpdate();
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureHoglinOnEntityTickUpdate.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8D);
		}
	}

	// Made with Blockbench 3.8.2
	// Exported for Minecraft version 1.12
	// Paste this class into your mod and generate all required imports
	public static class Modelhoglin extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer right_ear;
		private final ModelRenderer left_ear;
		private final ModelRenderer leg_back_right;
		private final ModelRenderer leg_back_left;
		private final ModelRenderer leg_front_right;
		private final ModelRenderer leg_front_left;
		public Modelhoglin() {
			textureWidth = 128;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 5.0F, -3.0F);
			body.cubeList.add(new ModelBox(body, 1, 1, -8.0F, -6.0F, -4.0F, 16, 14, 26, 0.02F, false));
			body.cubeList.add(new ModelBox(body, 90, 33, 0.0F, -13.0F, -7.0F, 0, 10, 19, 0.02F, false));
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -3.0F, -2.0F);
			body.addChild(head);
			setRotationAngle(head, 0.8727F, 0.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 61, 1, -7.0F, -5.0F, -19.0F, 14, 6, 19, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 1, 13, -8.0F, -11.0F, -14.0F, 2, 11, 2, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 1, 13, 6.0F, -11.0F, -14.0F, 2, 11, 2, 0.0F, false));
			right_ear = new ModelRenderer(this);
			right_ear.setRotationPoint(-7.0F, -5.0F, -2.0F);
			head.addChild(right_ear);
			setRotationAngle(right_ear, 0.0F, 0.0F, -0.8727F);
			right_ear.cubeList.add(new ModelBox(right_ear, 1, 1, -6.0F, 0.0F, -3.0F, 6, 1, 4, 0.0F, false));
			left_ear = new ModelRenderer(this);
			left_ear.setRotationPoint(7.0F, -5.0F, -2.0F);
			head.addChild(left_ear);
			setRotationAngle(left_ear, 0.0F, 0.0F, 0.8727F);
			left_ear.cubeList.add(new ModelBox(left_ear, 1, 6, 0.0F, 0.0F, -3.0F, 6, 1, 4, 0.0F, false));
			leg_back_right = new ModelRenderer(this);
			leg_back_right.setRotationPoint(6.0F, 16.0F, 17.0F);
			leg_back_right.cubeList.add(new ModelBox(leg_back_right, 21, 45, -14.0F, -3.0F, -4.0F, 5, 11, 5, 0.0F, false));
			leg_back_left = new ModelRenderer(this);
			leg_back_left.setRotationPoint(-6.0F, 16.0F, 17.0F);
			leg_back_left.cubeList.add(new ModelBox(leg_back_left, 0, 45, 9.0F, -3.0F, -4.0F, 5, 11, 5, 0.0F, false));
			leg_front_right = new ModelRenderer(this);
			leg_front_right.setRotationPoint(-6.0F, 12.0F, -3.0F);
			leg_front_right.cubeList.add(new ModelBox(leg_front_right, 66, 42, -2.0F, -2.0F, -3.0F, 6, 14, 6, 0.0F, false));
			leg_front_left = new ModelRenderer(this);
			leg_front_left.setRotationPoint(6.0F, 12.0F, -3.0F);
			leg_front_left.cubeList.add(new ModelBox(leg_front_left, 41, 42, -4.0F, -2.0F, -3.0F, 6, 14, 6, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			leg_back_right.render(f5);
			leg_back_left.render(f5);
			leg_front_right.render(f5);
			leg_front_left.render(f5);
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
