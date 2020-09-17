package mhzd.net.moreItem2.util.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerEvents 
{
	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent  e)
	{
		
		EntityPlayer p = (EntityPlayer)e.player;

		if(!p.world.isRemote)
		{
			TextComponentTranslation info1 = new TextComponentTranslation("mi2.message.login");
			TextComponentTranslation info2 = new TextComponentTranslation("mi2.message.login2");
			
			info2.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, 
					new TextComponentTranslation("mi2.message.login2.info").appendText("\n§3模组名字: §e更多武器二 \n§3模组官网: §e§n我的世界中国版\n\n§7本模组可以在网易PC版资源中心\n§7搜索作者 §e梦幻之都 §7即可找到")));
			
			p.sendMessage(info1);
			p.sendMessage(info2);
		}
	}
	
	
	
}
