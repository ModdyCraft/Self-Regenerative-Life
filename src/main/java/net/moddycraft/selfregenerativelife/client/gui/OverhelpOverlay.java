
package net.moddycraft.selfregenerativelife.client.gui;

import net.moddycraft.selfregenerativelife.network.SelfregenerativeLifeModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class OverhelpOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.level;
				_x = entity.getX();
				_y = entity.getY();
				_z = entity.getZ();
			}
			Level world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			if (true) {
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + (SelfregenerativeLifeModVariables.MapVariables.get(world).SaludAAnadir) + "", posX + -207, posY + -112, -12829636);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + (SelfregenerativeLifeModVariables.MapVariables.get(world).ticksNeeded) + "", posX + -207, posY + -94, -12829636);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + (SelfregenerativeLifeModVariables.MapVariables.get(world).reducTicks) + "", posX + -207, posY + -103, -12829636);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + (SelfregenerativeLifeModVariables.MapVariables.get(world).xpNeeded) + "", posX + -207, posY + -85, -12829636);
				Minecraft.getInstance().font.draw(event.getMatrixStack(),
						"" + (SelfregenerativeLifeModVariables.MapVariables.get(world).removeXp) + "", posX + -207, posY + -76, -12829636);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), "" + (entity.getPersistentData().getDouble("ticksDelJugador")) + "",
						posX + -108, posY + -112, -12829636);
			}
		}
	}
}
