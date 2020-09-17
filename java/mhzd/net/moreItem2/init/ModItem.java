package mhzd.net.moreItem2.init;

import java.util.ArrayList;
import java.util.List;

import mhzd.net.moreItem2.items.ItemBase;
import mhzd.net.moreItem2.items.MoreAxe;
import mhzd.net.moreItem2.items.MoreHoe;
import mhzd.net.moreItem2.items.MorePickAxe;
import mhzd.net.moreItem2.items.MoreShovel;
import mhzd.net.moreItem2.items.MoreSword;
import mhzd.net.moreItem2.items.armor.MoreArmor;
import mhzd.net.moreItem2.items.special.BloodAxe;
import mhzd.net.moreItem2.items.special.FireSword;
import mhzd.net.moreItem2.items.special.FireSword2;
import mhzd.net.moreItem2.items.special.GMSword;
import mhzd.net.moreItem2.items.special.IceSword;
import mhzd.net.moreItem2.items.special.SoulSword;
import mhzd.net.moreItem2.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItem 
{

	public static List<Item> ITEMS = new ArrayList<>();
	
	//材质
	public static final ToolMaterial SLIME_TOOL_MA = EnumHelper.addToolMaterial(
			Reference.MOD_ID + ":slime_tool"
			, 2, 300, 5.5F, 1.5F, 20);
	public static final ToolMaterial FIRE_TOOL_MA = EnumHelper.addToolMaterial(
			Reference.MOD_ID + ":fire_tool"
			, 4, 580, 6.5F, 3.5F, 15);
	public static final ToolMaterial OBS_TOOL_MA = EnumHelper.addToolMaterial(
			Reference.MOD_ID + ":obs_tool"
			, 5, 980, 7.5F, 4.5F, 10);
	public static final ToolMaterial WIND_TOOL_MA = EnumHelper.addToolMaterial(
			Reference.MOD_ID + ":obs_tool"
			, 4, 680, 6.5F, 3.2F, 20);
	public static final ToolMaterial WATER_TOOL_MA = EnumHelper.addToolMaterial(
			Reference.MOD_ID + ":obs_tool"
			, 4, 550, 6.5F, 3.5F, 20);
	
	public static final ArmorMaterial SLIME_ARMOR_MA = EnumHelper.addArmorMaterial("slime_armor_ma"
			, Reference.MOD_ID + ":slime"
			, 12
			, new int[]{2,4,5,2}
			, 10
			, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND
			, 0.0F);
	public static final ArmorMaterial OBS_ARMOR_MA = EnumHelper.addArmorMaterial("obs_armor_ma"
			, Reference.MOD_ID + ":obs"
			, 38
			, new int[]{3,5,7,3}
			, 5
			, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND
			, 3.0F);
	public static final ArmorMaterial FIRE_ARMOR_MA = EnumHelper.addArmorMaterial("fire_armor_ma"
			, Reference.MOD_ID + ":fire"
			, 24
			, new int[]{3,5,8,4}
			, 20
			, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND
			, 1.0F);
	public static final ArmorMaterial WATER_ARMOR_MA = EnumHelper.addArmorMaterial("water_armor_ma"
			, Reference.MOD_ID + ":water"
			, 26
			, new int[]{3,5,8,4}
			, 20
			, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND
			, 1.0F);
	public static final ArmorMaterial WIND_ARMOR_MA = EnumHelper.addArmorMaterial("wind_armor_ma"
			, Reference.MOD_ID + ":wind"
			, 22
			, new int[]{3,5,8,4}
			, 20
			, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND
			, 1.0F);
	
	
	
	//合成物品
	public static final ItemBase WIND_STONE = new ItemBase("wind_stone");
	public static final ItemBase WATER_STONE = new ItemBase("water_stone");
	public static final ItemBase FIRE_STONE = new ItemBase("fire_stone");
	public static final ItemBase OBS_STONE = new ItemBase("obs_stone");
	
	//装备
	public static Item SLIME_HELMET = new MoreArmor("slime_helmet", SLIME_ARMOR_MA, 1, EntityEquipmentSlot.HEAD);
	public static Item SLIME_CHESTPLATE = new MoreArmor("slime_chestplate", SLIME_ARMOR_MA, 1, EntityEquipmentSlot.CHEST);
	public static Item SLIME_LEG = new MoreArmor("slime_leg", SLIME_ARMOR_MA, 2, EntityEquipmentSlot.LEGS);
	public static Item SLIME_BOOTS = new MoreArmor("slime_boots", SLIME_ARMOR_MA, 1, EntityEquipmentSlot.FEET);
	
	public static Item OBS_HELMET = new MoreArmor("obs_helmet", OBS_ARMOR_MA, 1, EntityEquipmentSlot.HEAD);
	public static Item OBS_CHESTPLATE = new MoreArmor("obs_chestplate", OBS_ARMOR_MA, 1, EntityEquipmentSlot.CHEST);
	public static Item OBS_LEG = new MoreArmor("obs_leg", OBS_ARMOR_MA, 2, EntityEquipmentSlot.LEGS);
	public static Item OBS_BOOTS = new MoreArmor("obs_boots", OBS_ARMOR_MA, 1, EntityEquipmentSlot.FEET);

	public static Item WIND_HELMET = new MoreArmor("wind_helmet", WIND_ARMOR_MA, 1, EntityEquipmentSlot.HEAD);
	public static Item WIND_CHESTPLATE = new MoreArmor("wind_chestplate", WIND_ARMOR_MA, 1, EntityEquipmentSlot.CHEST);
	public static Item WIND_LEG = new MoreArmor("wind_leg", WIND_ARMOR_MA, 2, EntityEquipmentSlot.LEGS);
	public static Item WIND_BOOTS = new MoreArmor("wind_boots", WIND_ARMOR_MA, 1, EntityEquipmentSlot.FEET);
	
	public static Item WATER_HELMET = new MoreArmor("water_helmet", WATER_ARMOR_MA, 1, EntityEquipmentSlot.HEAD);
	public static Item WATER_CHESTPLATE = new MoreArmor("water_chestplate", WATER_ARMOR_MA, 1, EntityEquipmentSlot.CHEST);
	public static Item WATER_LEG = new MoreArmor("water_leg", WATER_ARMOR_MA, 2, EntityEquipmentSlot.LEGS);
	public static Item WATER_BOOTS = new MoreArmor("water_boots", WATER_ARMOR_MA, 1, EntityEquipmentSlot.FEET);
	
	public static Item FIRE_HELMET = new MoreArmor("fire_helmet", FIRE_ARMOR_MA, 1, EntityEquipmentSlot.HEAD);
	public static Item FIRE_CHESTPLATE = new MoreArmor("fire_chestplate", FIRE_ARMOR_MA, 1, EntityEquipmentSlot.CHEST);
	public static Item FIRE_LEG = new MoreArmor("fire_leg", FIRE_ARMOR_MA, 2, EntityEquipmentSlot.LEGS);
	public static Item FIRE_BOOTS = new MoreArmor("fire_boots", FIRE_ARMOR_MA, 1, EntityEquipmentSlot.FEET);
	
	//5件套
	public static Item SLIME_SWORD = new MoreSword("slime_sword", SLIME_TOOL_MA, 0.625D ,1.2D);
	public static Item SLIME_AXE = new MoreAxe("slime_axe", SLIME_TOOL_MA, 3D);
	public static Item SLIME_PICKAXE = new MorePickAxe("slime_pickaxe", SLIME_TOOL_MA, 0D);
	public static Item SLIME_SHOVEL = new MoreShovel("slime_shovel", SLIME_TOOL_MA);
	public static Item SLIME_HOE = new MoreHoe("slime_hoe", SLIME_TOOL_MA);
	
	public static Item FIRE_SWORD = new MoreSword("fire_sword", FIRE_TOOL_MA, 0.625D ,1.6D);
	public static Item FIRE_AXE = new MoreAxe("fire_axe", FIRE_TOOL_MA, 1D);
	public static Item FIRE_PICKAXE = new MorePickAxe("fire_pickaxe", FIRE_TOOL_MA, 0D);
	public static Item FIRE_SHOVEL = new MoreShovel("fire_shovel", FIRE_TOOL_MA);
	public static Item FIRE_HOE = new MoreHoe("fire_hoe", FIRE_TOOL_MA);
	
	public static Item OBS_SWORD = new MoreSword("obs_sword", OBS_TOOL_MA, 0.625D ,1.6D);
	public static Item OBS_AXE = new MoreAxe("obs_axe", OBS_TOOL_MA, 1D);
	public static Item OBS_PICKAXE = new MorePickAxe("obs_pickaxe", OBS_TOOL_MA, 0D);
	public static Item OBS_SHOVEL = new MoreShovel("obs_shovel", OBS_TOOL_MA);
	public static Item OBS_HOE = new MoreHoe("obs_hoe", OBS_TOOL_MA);
	
	public static Item WIND_SWORD = new MoreSword("wind_sword", WIND_TOOL_MA, 0.5D ,1.7D);
	public static Item WIND_AXE = new MoreAxe("wind_axe", WIND_TOOL_MA, 1D);
	public static Item WIND_PICKAXE = new MorePickAxe("wind_pickaxe", WIND_TOOL_MA, 0D);
	public static Item WIND_SHOVEL = new MoreShovel("wind_shovel", WIND_TOOL_MA);
	public static Item WIND_HOE = new MoreHoe("wind_hoe", WIND_TOOL_MA);
	
	public static Item WATER_SWORD = new MoreSword("water_sword", WATER_TOOL_MA, 0.625D ,1.5D);
	public static Item WATER_AXE = new MoreAxe("water_axe", WATER_TOOL_MA, 1D);
	public static Item WATER_PICKAXE = new MorePickAxe("water_pickaxe", WATER_TOOL_MA, 0D);
	public static Item WATER_SHOVEL = new MoreShovel("water_shovel", WATER_TOOL_MA);
	public static Item WATER_HOE = new MoreHoe("water_hoe", WATER_TOOL_MA);
	
	//神器
	public static final Item FIRE_SWORD_1 = new FireSword("fire_sword_1", FIRE_TOOL_MA, 0.625D, 2.0);
	public static final Item FIRE_SWORD_2 = new FireSword2("fire_sword_2", FIRE_TOOL_MA, 0.525D, 1.8);
	public static final Item ICE_SWORD = new IceSword("ice_sword", WATER_TOOL_MA, 0.525D, 1.9);
	public static final Item BLOOD_AXE = new BloodAxe("blood_axe", WATER_TOOL_MA, 0.525D, 2.1);
	public static final Item SOUL_SOWRD = new SoulSword("soul_sword", WATER_TOOL_MA, 0.3D, 1.4);
	public static final Item GM_SOWRD = new GMSword("gm_sword", WATER_TOOL_MA, 1.2D, 3.0);

}
