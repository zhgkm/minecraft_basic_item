package mhzd.net.moreItem2.items;

import mhzd.net.moreItem2.Main;
import mhzd.net.moreItem2.init.ModItem;
import mhzd.net.moreItem2.util.IHasModel;
import net.minecraft.item.ItemSpade;

public class MoreShovel extends ItemSpade implements IHasModel
{

	public MoreShovel(String name,ToolMaterial material) 
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabs);
		this.setMaxDamage((int) (material.getMaxUses() * 1.5));
		ModItem.ITEMS.add(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		Main.proxy.registerModel(this, 0);
	}
	

}
