package net.moddycraft.selfregenerativelife.procedures;

import net.moddycraft.selfregenerativelife.network.SelfregenerativeLifeModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RegenerarVidaProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			execute(event, entity.level, entity);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("ticksDelJugador", (entity.getPersistentData().getDouble("ticksDelJugador") + 1));
		if (entity.getPersistentData().getDouble("ticksDelJugador") >= 500) {
			entity.getPersistentData().putDouble("ticksDelJugador", 0);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt
				? _livEnt.getMaxHealth()
				: -1) && (entity instanceof Player _plr ? _plr.experienceLevel : 0) >= 1
				&& entity.getPersistentData().getDouble("ticksDelJugador") >= 120) {
			if (entity instanceof Player _player)
				_player.giveExperiencePoints(-(2));
			entity.getPersistentData().putDouble("ticksDelJugador", 0);
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						+ SelfregenerativeLifeModVariables.MapVariables.get(world).SaludAAnadir));
		}
	}
}
