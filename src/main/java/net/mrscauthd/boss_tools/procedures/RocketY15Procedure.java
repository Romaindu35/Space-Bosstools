package net.mrscauthd.boss_tools.procedures;

import net.mrscauthd.boss_tools.entity.RocketTier3Entity;
import net.mrscauthd.boss_tools.entity.RocketTier2Entity;
import net.mrscauthd.boss_tools.entity.RocketEntity;
import net.mrscauthd.boss_tools.BossToolsModElements;
import net.mrscauthd.boss_tools.BossToolsMod;

import net.minecraft.entity.Entity;

import java.util.Map;

@BossToolsModElements.ModElement.Tag
public class RocketY15Procedure extends BossToolsModElements.ModElement {
	public RocketY15Procedure(BossToolsModElements instance) {
		super(instance, 589);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BossToolsMod.LOGGER.warn("Failed to load dependency entity for procedure RocketY15!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getPosY()) >= 140) && ((!((entity.getPosY()) >= 150)) && (((entity.getRidingEntity()) instanceof RocketEntity.CustomEntity)
				|| (((entity.getRidingEntity()) instanceof RocketTier2Entity.CustomEntity)
						|| ((entity.getRidingEntity()) instanceof RocketTier3Entity.CustomEntity)))))) {
			return (true);
		}
		return (false);
	}
}
