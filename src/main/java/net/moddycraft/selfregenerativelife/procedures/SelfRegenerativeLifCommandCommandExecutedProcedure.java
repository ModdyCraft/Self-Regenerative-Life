package net.moddycraft.selfregenerativelife.procedures;

import net.moddycraft.selfregenerativelife.network.SelfregenerativeLifeModVariables;

import net.minecraft.world.level.LevelAccessor;

import java.util.HashMap;

public class SelfRegenerativeLifCommandCommandExecutedProcedure {
	public static void execute(LevelAccessor world, HashMap cmdparams) {
		if (cmdparams == null)
			return;
		double saludAA = 0;
		double reducT = 0;
		double ticksN = 0;
		double xpN = 0;
		double removeX = 0;
		saludAA = 1;
		reducT = 200;
		ticksN = 120;
		xpN = 2;
		removeX = 1.5;
		SelfregenerativeLifeModVariables.MapVariables.get(world).SaludAAnadir = saludAA * new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "");
		SelfregenerativeLifeModVariables.MapVariables.get(world).syncData(world);
		SelfregenerativeLifeModVariables.MapVariables.get(world).reducTicks = reducT * new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "");
		SelfregenerativeLifeModVariables.MapVariables.get(world).syncData(world);
		SelfregenerativeLifeModVariables.MapVariables.get(world).ticksNeeded = ticksN * new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "");
		SelfregenerativeLifeModVariables.MapVariables.get(world).syncData(world);
		SelfregenerativeLifeModVariables.MapVariables.get(world).xpNeeded = xpN * new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "");
		SelfregenerativeLifeModVariables.MapVariables.get(world).syncData(world);
		SelfregenerativeLifeModVariables.MapVariables.get(world).removeXp = removeX * new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "");
		SelfregenerativeLifeModVariables.MapVariables.get(world).syncData(world);
	}
}
