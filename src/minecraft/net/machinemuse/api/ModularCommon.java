package net.machinemuse.api;

import icbm.api.IExplosive;

import java.util.LinkedList;
import java.util.List;

import net.machinemuse.general.MuseStringUtils;
import net.machinemuse.powersuits.common.Config;
import net.machinemuse.powersuits.item.ItemPowerTool;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public abstract class ModularCommon {
	/**
	 * String literals as constants to eliminate case sensitivity issues etc.
	 */
	public static final String MAXIMUM_ENERGY = "Maximum Energy";
	public static final String CURRENT_ENERGY = "Current Energy";
	public static final String ARMOR_VALUE_PHYSICAL = "Armor (Physical)";
	public static final String ARMOR_VALUE_ENERGY = "Armor (Energy)";
	public static final String ARMOR_ENERGY_CONSUMPTION = "Energy Per Damage";
	public static final String WEIGHT = "Weight";
	public static final String SHOVEL_HARVEST_SPEED = "Shovel Harvest Speed";
	public static final String AXE_HARVEST_SPEED = "Axe Harvest Speed";
	public static final String PICKAXE_HARVEST_SPEED = "Pickaxe Harvest Speed";
	public static final String SHOVEL_ENERGY_CONSUMPTION = "Shovel Energy Consumption";
	public static final String AXE_ENERGY_CONSUMPTION = "Axe Energy Consumption";
	public static final String PICKAXE_ENERGY_CONSUMPTION = "Pickaxe Energy Consumption";
	public static final String BATTERY_WEIGHT = "Battery Weight";
	public static final String SPRINT_ENERGY_CONSUMPTION = "Sprint Energy Consumption";
	public static final String SPRINT_SPEED_MULTIPLIER = "Sprint Speed Multiplier";
	public static final String SPRINT_FOOD_COMPENSATION = "Sprint Exhaustion Compensation";
	public static final String JUMP_ENERGY_CONSUMPTION = "Jump Energy Consumption";
	public static final String JUMP_MULTIPLIER = "Jump Boost";
	public static final String JUMP_FOOD_COMPENSATION = "Jump Exhaustion Compensation";
	public static final String SHOCK_ABSORB_MULTIPLIER = "Distance Reduction";
	public static final String SHOCK_ABSORB_ENERGY_CONSUMPTION = "Impact Energy consumption";
	public static final String JET_ENERGY_CONSUMPTION = "Jet Energy Consumption";
	public static final String JET_THRUST = "Jet Thrust";
	public static final String WATERBREATHING_ENERGY_CONSUMPTION = "Jolt Energy";
	public static final String AQUA_AFFINITY_ENERGY_CONSUMPTION = "Underwater Energy Consumption";
	public static final String UNDERWATER_HARVEST_SPEED = "Underwater Harvest Speed";
	public static final String SWIM_BOOST_AMOUNT = "Underwater Movement Boost";
	public static final String SWIM_BOOST_ENERGY_CONSUMPTION = "Swim Boost Energy Consumption";
	public static final String RED_TINT = "Red Tint";
	public static final String GREEN_TINT = "Green Tint";
	public static final String BLUE_TINT = "Blue Tint";
	public static final String PLASMA_CANNON_ENERGY_PER_TICK = "Plasma Energy Per Tick";
	public static final String PLASMA_CANNON_DAMAGE_AT_FULL_CHARGE = "Plasma Damage At Full Charge";
	public static final String PLASMA_CANNON_EXPLOSIVENESS = "Plasma Explosiveness";
	public static final String PUNCH_ENERGY = "Punch Energy Consumption";
	public static final String PUNCH_DAMAGE = "Melee Damage";
	public static final String PUNCH_KNOCKBACK = "Melee Knockback";
	public static final String WALKING_ENERGY_CONSUMPTION = "Walking Energy Consumption";
	public static final String WALKING_SPEED_MULTIPLIER = "Walking Speed Multiplier";

	/**
	 * Module names
	 */
	public static final String MODULE_SHOVEL = "Shovel";
	public static final String MODULE_AXE = "Axe";
	public static final String MODULE_PICKAXE = "Pickaxe";
	public static final String MODULE_BATTERY_BASIC = "Basic Battery";
	public static final String MODULE_BATTERY_ADVANCED = "Advanced Battery";
	public static final String MODULE_BATTERY_ELITE = "Elite Battery";
	public static final String MODULE_BASIC_PLATING = "Iron Plating";
	public static final String MODULE_DIAMOND_PLATING = "Diamond Plating";
	public static final String MODULE_ENERGY_SHIELD = "Energy Shield";
	public static final String MODULE_DIAMOND_PICK_UPGRADE = "Diamond Drill Upgrade";
	public static final String MODULE_SPRINT_ASSIST = "Sprint Assist";
	public static final String MODULE_JUMP_ASSIST = "Jump Assist";
	public static final String MODULE_SHOCK_ABSORBER = "Shock Absorber";
	public static final String MODULE_TRANSPARENT_ARMOR = "Transparent Armor";
	public static final String MODULE_GLIDER = "Glider";
	public static final String MODULE_JETPACK = "Jetpack";
	public static final String MODULE_JETBOOTS = "Jet Boots";
	public static final String MODULE_PARACHUTE = "Parachute";
	public static final String MODULE_ANTIGRAVITY = "Antigravity Drive";
	public static final String MODULE_WATER_ELECTROLYZER = "Water Electrolyzer";
	public static final String MODULE_AQUA_AFFINITY = "Aqua Affinity";
	public static final String MODULE_TINT = "Custom Colour Module";
	public static final String MODULE_CLIMB_ASSIST = "Uphill Step Assist";
	public static final String MODULE_SWIM_BOOST = "Swim Boost";
	public static final String MODULE_PLASMA_CANNON = "Plasma Cannon";
	public static final String MODULE_MELEE_ASSIST = "Melee Assist";
	public static final String MODULE_NIGHT_VISION = "Night Vision";
	public static final String MODULE_ACTIVE_CAMOUFLAGE = "Active Camouflage";

	/**
	 * Categories for modules
	 */
	public static final String CATEGORY_ARMOR = "Armor";
	public static final String CATEGORY_ENERGY = "Energy";
	public static final String CATEGORY_TOOL = "Tool";
	public static final String CATEGORY_WEAPON = "Weapon";
	public static final String CATEGORY_MOVEMENT = "Movement";
	public static final String CATEGORY_COSMETIC = "Cosmetic";
	public static final String CATEGORY_VISION = "Vision";
	public static final String CATEGORY_ENVIRONMENTAL = "Environment";
	public static final String CATEGORY_SPECIAL = "Special";

	/**
	 * Adds information to the item's tooltip when 'getting' it.
	 * 
	 * @param stack
	 *            The itemstack to get the tooltip for
	 * @param player
	 *            The player (client) viewing the tooltip
	 * @param currentTipList
	 *            A list of strings containing the existing tooltip. When
	 *            passed, it will just contain the name of the item;
	 *            enchantments and lore are appended afterwards.
	 * @param advancedToolTips
	 *            Whether or not the player has 'advanced tooltips' turned on in
	 *            their settings.
	 */
	public static void addInformation(ItemStack stack,
			EntityPlayer player, List currentTipList, boolean advancedToolTips) {
		if (stack.getItem() instanceof ItemPowerTool) {
			String mode = MuseItemUtils.getStringOrNull(stack, "Tool Mode");
			if (mode != null) {
				currentTipList.add("Mode:" + MuseStringUtils.wrapFormatTags(mode, MuseStringUtils.FormatCodes.Red));
			}
		}
		String energyinfo = "Energy: " + MuseStringUtils.formatNumberShort(getJoules(stack)) + "/"
				+ MuseStringUtils.formatNumberShort(getMaxJoules(stack));
		currentTipList.add(
				MuseStringUtils.wrapMultipleFormatTags(energyinfo, MuseStringUtils.FormatCodes.Italic.character, MuseStringUtils.FormatCodes.Grey)
				);
		if (Config.doAdditionalInfo()) {
			List<String> installed = ModularCommon.getItemInstalledModules(player, stack);
			if (installed.size() == 0) {
				String message = "No installed modules! This item is useless until you add some modules at a Tinker Table.";
				currentTipList.addAll(MuseStringUtils.wrapStringToLength(message, 30));
			} else {
				currentTipList.add("Installed Modules:");
				currentTipList.addAll(installed);
			}
		} else {
			currentTipList.add(Config.additionalInfoInstructions());
		}
	}

	// ///////////////////////////// //
	// --- UNIVERSAL ELECTRICITY --- //
	// ///////////////////////////// //

	/**
	 * Provide energy to an item.
	 * 
	 * @param joulesNeeded
	 *            Amount to request (in UE Joules).
	 * @param itemStack
	 *            Itemstack to request the energy from.
	 * @return Amount of joules provided by the item.
	 */
	public static double charge(double amount, ItemStack itemStack) {
		double stored = getJoules(itemStack);
		double capacity = getMaxJoules(itemStack) - stored;
		double taken = Math.min(amount, capacity);
		double surplus = amount - taken;
		setJoules(stored + taken, itemStack);
		return surplus;
	}

	/**
	 * Request energy from this item.
	 * 
	 * @param joulesNeeded
	 *            Amount to request (in UE Joules).
	 * @param itemStack
	 *            Itemstack to request the energy from.
	 * @return Amount of joules provided by the item.
	 */
	public static double discharge(double joulesNeeded, ItemStack itemStack) {
		NBTTagCompound itemProperties = MuseItemUtils.getMuseItemTag(itemStack);

		double joulesAvail = getJoules(itemStack);
		double joulesProvided = Math.min(joulesAvail, joulesNeeded);

		setJoules(joulesAvail - joulesProvided, itemStack);
		return joulesProvided;
	}

	public static double getJoules(ItemStack stack) {
		double joules = MuseItemUtils.getDoubleOrZero(stack, CURRENT_ENERGY);
		double maxJoules = getMaxJoules(stack);
		if (joules > maxJoules) {
			joules = maxJoules;
			setJoules(joules, stack);
		}
		return joules;
	}

	public static void setJoules(double joules, ItemStack stack) {
		MuseItemUtils.setDoubleOrRemove(stack, CURRENT_ENERGY, joules);
	}

	public static double getMaxJoules(ItemStack stack) {
		double maxJoules = ModuleManager.computeModularProperty(stack, ModularCommon.MAXIMUM_ENERGY);
		return maxJoules;
	}

	public static double getVoltage(ItemStack itemStack) {
		return 120;
	}

	// //////////////////////// //
	// --- OTHER PROPERTIES --- //
	// //////////////////////// //
	public static double getOrSetModuleProperty(NBTTagCompound moduleTag, String propertyName, double defaultValue) {
		if (!moduleTag.hasKey(propertyName)) {
			moduleTag.setDouble(propertyName, defaultValue);
		}
		return moduleTag.getDouble(propertyName);
	}

	public static double getTotalWeight(ItemStack stack) {
		return ModuleManager.computeModularProperty(stack, ModularCommon.WEIGHT);
	}

	public static List<String> getItemInstalledModules(EntityPlayer player, ItemStack stack) {
		NBTTagCompound itemTag = MuseItemUtils.getMuseItemTag(stack);
		List<String> modules = new LinkedList();
		for (IPowerModule module : MuseItemUtils.getValidModulesForItem(player, stack)) {
			if (MuseItemUtils.tagHasModule(itemTag, module.getName())) {
				modules.add(module.getName());
			}
		}
		return modules;
	}

	public static void onEMP(ItemStack itemStack, Entity entity, IExplosive empExplosive) {
		setJoules(0, itemStack);
	}
}
