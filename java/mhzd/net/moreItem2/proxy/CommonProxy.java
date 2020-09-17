package mhzd.net.moreItem2.proxy;

import mhzd.net.moreItem2.init.ModItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public void registerModel(Item item, int metadata) 
	{
		
	}
	
	public void preInit()
	{
		GameRegistry.addSmelting(Item.getItemFromBlock(Blocks.OBSIDIAN), new ItemStack(ModItem.OBS_STONE), 10);
	}
	
}
