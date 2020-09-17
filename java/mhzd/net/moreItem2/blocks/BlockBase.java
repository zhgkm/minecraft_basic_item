package mhzd.net.moreItem2.blocks;

import java.util.Random;

import mhzd.net.moreItem2.Main;
import mhzd.net.moreItem2.init.ModBlock;
import mhzd.net.moreItem2.init.ModItem;
import mhzd.net.moreItem2.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends BlockOre implements IHasModel
{

	private Item drop;
	
	public BlockBase(String name, Item drop) 
	{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabs);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		this.drop = drop;
		ModBlock.BLOCKS.add(this);
		ModItem.ITEMS.add(new ItemBlock(this).setRegistryName(name));
		
	}

	@Override
	public void registerModels() 
	{
		// TODO Auto-generated method stub
		Main.proxy.registerModel(Item.getItemFromBlock(this), 0);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		// TODO Auto-generated method stub
		return this.drop;
	}
}
