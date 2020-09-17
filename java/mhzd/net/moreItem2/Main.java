package mhzd.net.moreItem2;

import mhzd.net.moreItem2.proxy.CommonProxy;
import mhzd.net.moreItem2.util.MoreItemTab;
import mhzd.net.moreItem2.util.Reference;
import mhzd.net.moreItem2.util.WorldGenCustomOres;
import mhzd.net.moreItem2.util.handler.PlayerEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name=Reference.NAME, version=Reference.VERSION)
public class Main 
{

	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;
	
	public static MoreItemTab tabs = new MoreItemTab();
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e)
	{
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
		MinecraftForge.EVENT_BUS.register(new PlayerEvents());
		proxy.preInit();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent e)
	{
		
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e)
	{
		
	}
	
	
	
}
