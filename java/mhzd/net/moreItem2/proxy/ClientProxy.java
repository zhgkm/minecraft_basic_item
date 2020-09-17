package mhzd.net.moreItem2.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerModel(Item item, int meta) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, 
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@Override
	public void preInit() 
	{
		// TODO Auto-generated method stub
		super.preInit();
	}
}
