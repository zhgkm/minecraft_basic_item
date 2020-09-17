package mhzd.net.moreItem2.init;

import java.util.ArrayList;
import java.util.List;

import mhzd.net.moreItem2.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ModBlock 
{

	public static List<Block> BLOCKS = new ArrayList<>();

	public static final BlockBase FIRE_STONE_ORE = new BlockBase("fire_stone_ore", ModItem.FIRE_STONE);
	public static final BlockBase WIND_STONE_ORE = new BlockBase("wind_stone_ore", ModItem.WIND_STONE);
	public static final BlockBase WATER_STONE_ORE = new BlockBase("water_stone_ore", ModItem.WATER_STONE);
	
}
