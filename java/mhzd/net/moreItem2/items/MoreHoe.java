package mhzd.net.moreItem2.items;

import mhzd.net.moreItem2.Main;
import mhzd.net.moreItem2.init.ModItem;
import mhzd.net.moreItem2.util.IHasModel;
import net.minecraft.item.ItemHoe;

public class MoreHoe extends ItemHoe implements IHasModel
{

	public MoreHoe(String name, ToolMaterial material) 
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabs);
		this.setMaxDamage((int) (material.getMaxUses() * 1.2));
		ModItem.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		Main.proxy.registerModel(this, 0);
	}

}
