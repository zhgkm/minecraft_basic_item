package mhzd.net.moreItem2.util.handler;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import mhzd.net.moreItem2.init.ModBlock;
import mhzd.net.moreItem2.init.ModItem;
import mhzd.net.moreItem2.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onFallDown(LivingFallEvent e)
	{
		if(e.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer p = (EntityPlayer) e.getEntityLiving();
			if(p.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItem.SLIME_BOOTS)
				e.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> e)
	{
		e.getRegistry().registerAll(ModItem.ITEMS.toArray(new Item[0]));
	}
	
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> e)
	{
		e.getRegistry().registerAll(ModBlock.BLOCKS.toArray(new Block[0]));
	}
	
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent e)
	{
		for(Item i: ModItem.ITEMS)
		{
			if(i instanceof IHasModel)
				((IHasModel)i).registerModels();
		}
		
		for(Block b: ModBlock.BLOCKS)
		{
			if(b instanceof IHasModel)
				((IHasModel)b).registerModels();
		}
	}
	
	
}
