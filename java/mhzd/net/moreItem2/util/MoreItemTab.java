package mhzd.net.moreItem2.util;

import mhzd.net.moreItem2.init.ModItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MoreItemTab extends CreativeTabs
{

	public MoreItemTab() 
	{
		super("moreitem2");
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ModItem.FIRE_SWORD_1);
	}

}
