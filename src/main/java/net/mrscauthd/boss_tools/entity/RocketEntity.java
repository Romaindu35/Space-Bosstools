
package net.mrscauthd.boss_tools.entity;

import net.mrscauthd.boss_tools.procedures.RocketOnEntityTickUpdateProcedure;
import net.mrscauthd.boss_tools.procedures.RocketEntityIsHurt1Procedure;
import net.mrscauthd.boss_tools.gui.RocketTier1GUIFuelGui;
import net.mrscauthd.boss_tools.BossToolsModElements;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.wrapper.EntityHandsInvWrapper;
import net.minecraftforge.items.wrapper.EntityArmorInvWrapper;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ActionResultType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;
import javax.annotation.Nonnull;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@BossToolsModElements.ModElement.Tag
public class RocketEntity extends BossToolsModElements.ModElement {
	public static EntityType entity = null;
	public RocketEntity(BossToolsModElements instance) {
		super(instance, 77);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
		NetworkLoader.registerMessages();
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(100).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(1f, 3f)).build("rocket")
						.setRegistryName("rocket");
		elements.entities.add(() -> entity);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelRocketTier1(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("boss_tools:textures/rockettier1newnew.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 1000);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 5;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public double getMountedYOffset() {
			return super.getMountedYOffset() + -1.7000000000000002;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				RocketEntityIsHurt1Procedure.executeProcedure($_dependencies);
			}
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PlayerEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}
		private final ItemStackHandler inventory = new ItemStackHandler(9) {
			@Override
			public int getSlotLimit(int slot) {
				return 64;
			}
		};
		private final CombinedInvWrapper combined = new CombinedInvWrapper(inventory, new EntityHandsInvWrapper(this),
				new EntityArmorInvWrapper(this));
		@Override
		public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
			if (this.isAlive() && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && side == null)
				return LazyOptional.of(() -> combined).cast();
			return super.getCapability(capability, side);
		}

		@Override
		protected void dropInventory() {
			super.dropInventory();
			for (int i = 0; i < inventory.getSlots(); ++i) {
				ItemStack itemstack = inventory.getStackInSlot(i);
				if (!itemstack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemstack)) {
					this.entityDropItem(itemstack);
				}
			}
		}

		@Override
		public void writeAdditional(CompoundNBT compound) {
			super.writeAdditional(compound);
			compound.put("InventoryCustom", inventory.serializeNBT());
		}

		@Override
		public void readAdditional(CompoundNBT compound) {
			super.readAdditional(compound);
			INBT inventoryCustom = compound.get("InventoryCustom");
			if (inventoryCustom instanceof CompoundNBT)
				inventory.deserializeNBT((CompoundNBT) inventoryCustom);
		}

		@Override
		public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
			if (sourceentity.isSecondaryUseActive()) {
				if (sourceentity instanceof ServerPlayerEntity) {
					NetworkHooks.openGui((ServerPlayerEntity) sourceentity, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("Rocket");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							PacketBuffer packetBuffer = new PacketBuffer(Unpooled.buffer());
							packetBuffer.writeBlockPos(new BlockPos(sourceentity.getPosition()));
							packetBuffer.writeByte(0);
							packetBuffer.writeVarInt(CustomEntity.this.getEntityId());
							return new RocketTier1GUIFuelGui.GuiContainerMod(id, inventory, packetBuffer);
						}
					}, buf -> {
						buf.writeBlockPos(new BlockPos(sourceentity.getPosition()));
						buf.writeByte(0);
						buf.writeVarInt(this.getEntityId());
					});
				}
				return ActionResultType.func_233537_a_(this.world.isRemote());
			}
			super.func_230254_b_(sourceentity, hand);
			sourceentity.startRiding(this);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			return retval;
		}

		@Override
		public void baseTick() {
			super.baseTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				RocketOnEntityTickUpdateProcedure.executeProcedure($_dependencies);
			}
			if (!this.world.isRemote)
				NetworkLoader.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> this),
						new RocketSpinPacket(this.getEntityId(), this.getPersistentData().getDouble("Animation")));
			// new Nbt
			if (!this.world.isRemote)
				NetworkLoader.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> this),
						new RocketSpin2Packet(this.getEntityId(), this.getPersistentData().getDouble("AnimationPitch")));
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelRocketTier1 extends EntityModel<Entity> {
		private final ModelRenderer Rocket;
		public ModelRocketTier1() {
			textureWidth = 512;
			textureHeight = 256;
			Rocket = new ModelRenderer(this);
			Rocket.setRotationPoint(0.0F, 23.0F, 0.0F);
			Rocket.setTextureOffset(43, 17).addBox(11.0F, -7.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -7.0F, -12.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-12.0F, -7.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -7.0F, 11.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(273, 90).addBox(4.0F, -31.0F, -8.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(273, 90).addBox(-7.0F, -31.0F, -8.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(85, 46).addBox(3.0F, -31.0F, -8.1F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(86, 47).addBox(-4.0F, -31.0F, -8.1F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(87, 52).addBox(-3.0F, -31.0F, -8.1F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(89, 52).addBox(-3.0F, -25.0F, -8.1F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(274, 82).addBox(-7.0F, -39.0F, -8.0F, 14.0F, 8.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(276, 135).addBox(-7.0F, -24.0F, -8.0F, 14.0F, 19.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(279, 120).addBox(-7.0F, -39.0F, 7.0F, 14.0F, 34.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(276, 107).addBox(-8.0F, -39.0F, -7.0F, 1.0F, 34.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(307, 78).addBox(-8.0F, -40.0F, -8.0F, 1.0F, 35.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(307, 78).addBox(-8.0F, -40.0F, 7.0F, 1.0F, 35.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(37, 23).addBox(-7.0F, -40.0F, 7.0F, 14.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(37, 23).addBox(-7.0F, -40.0F, -8.0F, 14.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(29, 17).addBox(-8.0F, -40.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(29, 17).addBox(7.0F, -40.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(307, 78).addBox(7.0F, -40.0F, 7.0F, 1.0F, 35.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(307, 78).addBox(7.0F, -37.0F, -8.0F, 1.0F, 32.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(307, 78).addBox(7.0F, -40.0F, -8.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(10.0F, -9.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -9.0F, -11.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-11.0F, -9.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -9.0F, 10.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(9.0F, -10.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -10.0F, -10.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-10.0F, -10.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -10.0F, 9.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(12.0F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -7.0F, -13.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-13.0F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -7.0F, 12.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(13.0F, -11.0F, -1.0F, 1.0F, 13.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -11.0F, -14.0F, 2.0F, 13.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-14.0F, -11.0F, -1.0F, 1.0F, 13.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -11.0F, 13.0F, 2.0F, 13.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(8.0F, -11.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -11.0F, -9.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-9.0F, -11.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(43, 17).addBox(-1.0F, -11.0F, 8.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(277, 106).addBox(7.0F, -39.0F, -7.0F, 1.0F, 34.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(33, 87).addBox(4.0F, -41.0F, -7.0F, 2.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(33, 87).addBox(6.0F, -41.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
			Rocket.setTextureOffset(33, 87).addBox(-7.0F, -41.0F, -6.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-7.0F, -41.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(6.0F, -41.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(5.0F, -42.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(5.0F, -43.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(4.0F, -45.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(4.0F, -44.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(4.0F, -45.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(4.0F, -44.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-5.0F, -45.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-4.0F, -47.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-3.0F, -49.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-3.0F, -48.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(2.0F, -49.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(2.0F, -48.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-3.0F, -49.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-2.0F, -50.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-2.0F, -51.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-2.0F, -50.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-2.0F, -51.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(1.0F, -50.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(1.0F, -51.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(1.0F, -50.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(1.0F, -51.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-3.0F, -48.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(2.0F, -49.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(2.0F, -48.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-4.0F, -46.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-4.0F, -47.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-4.0F, -46.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(3.0F, -47.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(3.0F, -46.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(3.0F, -47.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(3.0F, -46.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-5.0F, -44.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-5.0F, -45.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-5.0F, -44.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-6.0F, -42.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-6.0F, -43.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(5.0F, -42.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(5.0F, -43.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-6.0F, -42.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-6.0F, -43.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(-7.0F, -41.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(249, 94).addBox(6.0F, -41.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(31, 17).addBox(4.0F, -5.0F, -8.0F, 4.0F, 1.0F, 16.0F, 0.0F, false);
			Rocket.setTextureOffset(31, 17).addBox(3.0F, -40.0F, -7.0F, 4.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 5).addBox(-1.0F, -68.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(500, 146).addBox(-1.0F, -66.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(-1.0F, -50.0F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(-1.0F, -51.0F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(-2.0F, -50.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(-2.0F, -51.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(1.0F, -50.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(64, 102).addBox(1.0F, -51.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-3.0F, -49.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-3.0F, -48.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-2.0F, -49.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-2.0F, -48.0F, -3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-2.0F, -49.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 110).addBox(-2.0F, -48.0F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(-3.0F, -47.0F, -4.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(-3.0F, -46.0F, -4.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(3.0F, -47.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(3.0F, -46.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(-4.0F, -47.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(88, 88).addBox(-4.0F, -46.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(-4.0F, -45.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(-4.0F, -44.0F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(-5.0F, -45.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(-5.0F, -44.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(4.0F, -45.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(75, 97).addBox(4.0F, -44.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(-5.0F, -42.0F, -6.0F, 10.0F, 1.0F, 12.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(-5.0F, -43.0F, -6.0F, 10.0F, 1.0F, 12.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(-6.0F, -42.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(-6.0F, -43.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(5.0F, -42.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(65, 106).addBox(5.0F, -43.0F, -5.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
			Rocket.setTextureOffset(66, 94).addBox(-6.0F, -41.0F, -7.0F, 10.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(444, 32).addBox(-7.0F, -5.0F, -6.0F, 11.0F, 1.0F, 14.0F, 0.0F, false);
			Rocket.setTextureOffset(30, 14).addBox(-7.0F, -40.0F, -7.0F, 10.0F, 1.0F, 14.0F, 0.0F, false);
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
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Rocket.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Rocket.rotateAngleY = f3 / (180F / (float) Math.PI);
			// this.Rocket.rotateAngleX = f4 / (180F / (float) Math.PI);
			// Animation1
			this.Rocket.rotateAngleZ = f2 / (180F / (float) Math.PI);
			if (e instanceof LivingEntity) {
				this.Rocket.rotateAngleZ = (float) ((LivingEntity) e).getPersistentData().getDouble("Animation");
			}
			// Animation2
			this.Rocket.rotateAngleX = f2 / (180F / (float) Math.PI);
			if (e instanceof LivingEntity) {
				this.Rocket.rotateAngleX = (float) ((LivingEntity) e).getPersistentData().getDouble("AnimationPitch");
			}
		}
	}

	// packages System
	private static class NetworkLoader {
		public static SimpleChannel INSTANCE;
		private static int id = 1;
		public static int nextID() {
			return id++;
		}

		public static void registerMessages() {
			INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation("boss_tools", "rocket_link"), () -> "1.0", s -> true, s -> true);
			INSTANCE.registerMessage(nextID(), RocketSpinPacket.class, RocketSpinPacket::encode, RocketSpinPacket::decode, RocketSpinPacket::handle);
			// new animationpitch
			INSTANCE.registerMessage(nextID(), RocketSpin2Packet.class, RocketSpin2Packet::encode, RocketSpin2Packet::decode,
					RocketSpin2Packet::handle);
		}
	}

	// First Animation
	private static class RocketSpinPacket {
		private double animation;
		private int entityId;
		public RocketSpinPacket(int entityId, double animation) {
			this.animation = animation;
			this.entityId = entityId;
		}

		public static void encode(RocketSpinPacket msg, PacketBuffer buf) {
			buf.writeInt(msg.entityId);
			buf.writeDouble(msg.animation);
		}

		public static RocketSpinPacket decode(PacketBuffer buf) {
			return new RocketSpinPacket(buf.readInt(), buf.readDouble());
		}

		public static void handle(RocketSpinPacket msg, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Entity entity = Minecraft.getInstance().world.getEntityByID(msg.entityId);
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).getPersistentData().putDouble("Animation", msg.animation);
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}

	// new animationpitch
	private static class RocketSpin2Packet {
		private double animationpitch;
		private int entityId;
		public RocketSpin2Packet(int entityId, double animationpitch) {
			this.animationpitch = animationpitch;
			this.entityId = entityId;
		}

		public static void encode(RocketSpin2Packet msg, PacketBuffer buf) {
			buf.writeInt(msg.entityId);
			buf.writeDouble(msg.animationpitch);
		}

		public static RocketSpin2Packet decode(PacketBuffer buf) {
			return new RocketSpin2Packet(buf.readInt(), buf.readDouble());
		}

		public static void handle(RocketSpin2Packet msg, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Entity entity = Minecraft.getInstance().world.getEntityByID(msg.entityId);
				if (entity instanceof LivingEntity) {
					((LivingEntity) entity).getPersistentData().putDouble("AnimationPitch", msg.animationpitch);
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}
