package mhzd.net.moreItem2.items.armor;

import java.util.Random;

import mhzd.net.moreItem2.Main;
import mhzd.net.moreItem2.init.ModItem;
import mhzd.net.moreItem2.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class MoreArmor extends ItemArmor implements IHasModel
{

	public MoreArmor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabs);
		this.setMaxStackSize(1);
		
		ModItem.ITEMS.add(this);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		// TODO Auto-generated method stub
		if(player.getItemStackFromSlot(EntityEquipmentSlot.FEET) == null)
			return;
		if(this.getArmorMaterial() == ModItem.FIRE_ARMOR_MA && isFullSet(player))
		{
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 11*20, 0));
			Random rand = new Random();
			if(rand.nextInt(10) > 6)
			{
			    double motionX = rand.nextGaussian() * 0.04D;
			    double motionY = rand.nextGaussian() * 0.04D;
			    double motionZ = rand.nextGaussian() * 0.04D;
			    player.world.spawnParticle(
			    		EnumParticleTypes.FLAME, 
			          player.posX + rand.nextFloat() * player.width * 2.0F - player.width, 
			          player.posY + 0.5D + rand.nextFloat() * player.height, 
			          player.posZ + rand.nextFloat() * player.width * 2.0F - player.width, 
			          motionX, 
			          motionY, 
			          motionZ);
			}
		}else if(this.getArmorMaterial() == ModItem.OBS_ARMOR_MA && isFullSet(player))
		{
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 11*20, 1));
			Random rand = new Random();
			if(rand.nextInt(10) > 6)
			{
			    double motionX = rand.nextGaussian() * 0.04D;
			    double motionY = rand.nextGaussian() * 0.04D;
			    double motionZ = rand.nextGaussian() * 0.04D;
			    player.world.spawnParticle(
			    		EnumParticleTypes.CRIT_MAGIC, 
			          player.posX + rand.nextFloat() * player.width * 2.0F - player.width, 
			          player.posY + 0.5D + rand.nextFloat() * player.height, 
			          player.posZ + rand.nextFloat() * player.width * 2.0F - player.width, 
			          motionX, 
			          motionY, 
			          motionZ);
			}
		}else if(this.getArmorMaterial() == ModItem.SLIME_ARMOR_MA && isFullSet(player))
		{
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 11*20, 2));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 11*20, 0));
		}else if(this.getArmorMaterial() == ModItem.WATER_ARMOR_MA && isFullSet(player))
		{
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(13), 11*20, 5));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 11*20, 0));

		}else if(this.getArmorMaterial() == ModItem.WIND_ARMOR_MA && isFullSet(player))
		{
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 11*20, 2));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 11*20, 2));
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 11*20, 2));
		}
		
		
	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		if(this.getArmorMaterial() == ModItem.FIRE_ARMOR_MA)
			return ModItem.FIRE_STONE == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		else if(this.getArmorMaterial() == ModItem.WIND_ARMOR_MA)
			return ModItem.WIND_STONE == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		else if(this.getArmorMaterial() == ModItem.WATER_ARMOR_MA)
			return ModItem.WATER_STONE == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		else if(this.getArmorMaterial() == ModItem.SLIME_ARMOR_MA)
			return Items.SLIME_BALL == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		else if(this.getArmorMaterial() == ModItem.OBS_ARMOR_MA)
			return ModItem.OBS_STONE == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		
		return false;
	}
	
	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		Main.proxy.registerModel(this, 0);
	}
	
	
	public boolean isFullSet(EntityPlayer player)
	{
		if(player == null)
			return false;
		
		if(this.getArmorMaterial() == ModItem.FIRE_ARMOR_MA)
		{
			if(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItem.FIRE_HELMET
					&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItem.FIRE_CHESTPLATE
					&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItem.FIRE_LEG
					&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItem.FIRE_BOOTS)
				return true;
		}else if(this.getArmorMaterial() == ModItem.OBS_ARMOR_MA)
		{
			if(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItem.OBS_HELMET
					&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItem.OBS_CHESTPLATE
					&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItem.OBS_LEG
					&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItem.OBS_BOOTS)
				return true;
		}else if(this.getArmorMaterial() == ModItem.SLIME_ARMOR_MA)
		{
			if(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItem.SLIME_HELMET
					&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItem.SLIME_CHESTPLATE
					&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItem.SLIME_LEG
					&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItem.SLIME_BOOTS)
				return true;
		}else if(this.getArmorMaterial() == ModItem.WATER_ARMOR_MA)
		{
			if(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItem.WATER_HELMET
					&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItem.WATER_CHESTPLATE
					&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItem.WATER_LEG
					&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItem.WATER_BOOTS)
				return true;
		}else if(this.getArmorMaterial() == ModItem.WIND_ARMOR_MA)
		{
			if(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItem.WIND_HELMET
					&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItem.WIND_CHESTPLATE
					&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItem.WIND_LEG
					&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItem.WIND_BOOTS)
				return true;
		}
		
		return false;
	}
}
