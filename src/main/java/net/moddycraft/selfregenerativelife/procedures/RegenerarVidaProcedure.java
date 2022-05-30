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
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.TextComponent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RegenerarVidaProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("ticksDelJugador", (entity.getPersistentData().getDouble("ticksDelJugador") + 1));
		if (entity.getPersistentData().getDouble("ticksDelJugador") >= SelfregenerativeLifeModVariables.MapVariables.get(world).reducTicks) {
			entity.getPersistentData().putDouble("ticksDelJugador", 0);
		}
		if (entity.getPersistentData().getDouble("ticksDelJugador") >= SelfregenerativeLifeModVariables.MapVariables.get(world).ticksNeeded) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt
					? _livEnt.getMaxHealth()
					: -1)) {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) > SelfregenerativeLifeModVariables.MapVariables.get(world).xpNeeded) {
					if (entity instanceof Player _player)
						_player.giveExperiencePoints(-((int) SelfregenerativeLifeModVariables.MapVariables.get(world).removeXp));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
								+ SelfregenerativeLifeModVariables.MapVariables.get(world).SaludAAnadir));
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent((new TranslatableComponent("mensaje.dispo").getString())), (false));
					entity.getPersistentData().putDouble("ticksDelJugador", 0);
				} else {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent((new TranslatableComponent("mensaje.falta.xp").getString())), (false));
				}
			}
		}
	}
}
