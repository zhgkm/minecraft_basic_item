package mhzd.net.moreItem2.items.special;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import com.google.common.collect.Multimap;

import mhzd.net.moreItem2.Main;
import mhzd.net.moreItem2.init.ModItem;
import mhzd.net.moreItem2.util.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class IceSword extends ItemSword implements IHasModel
{
	private double damage;
	private double speed;
	
	public IceSword(String name, ToolMaterial material, double speed, double damage) 
	{
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabs);
		this.speed = speed;
		this.damage = damage;
		ModItem.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		// TODO Auto-generated method stub
		KeyBinding key = Minecraft.getMinecraft().gameSettings.keyBindSneak;
		if(GameSettings.isKeyDown(key))
		{
			tooltip.add(" ");
			tooltip.add("§7============§b物品介绍§7============");
			tooltip.add("§3品阶: §5高级");
			tooltip.add("§3伤害: §7中");
			tooltip.add("§3攻速: §a快");
			tooltip.add("§3效果: §a使敌人减速和虚弱状态6秒");
			tooltip.add("§7=================================");
			tooltip.add("§c无法修复");
		}else
		{
			tooltip.add(" ");
			tooltip.add("§7请按住 §e下蹲键 §7进行查看物品介绍");
		}
	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return false;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		// TODO Auto-generated method stub
		target.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 6*20, 1));
		target.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 6*20, 1));
		return super.hitEntity(stack, target, attacker);
	}
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer p, Entity entity) {
		// TODO Auto-generated method stub
		if(!p.world.isRemote)
			super.onLeftClickEntity(stack, p, entity);
				
		if(!(entity instanceof EntityLivingBase))
			super.onLeftClickEntity(stack, p, entity);
		EntityLivingBase target = (EntityLivingBase)entity;
		playEffect(target);
		return super.onLeftClickEntity(stack, p, entity);
	}

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) 
    {
        final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);
        if (slot == EntityEquipmentSlot.MAINHAND) 
        {
            replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, speed);
            replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, damage);
        }
        return modifiers;
    }
    
    
	public void playEffect(EntityLivingBase entityLivingBase)
	{
		Random rand = new Random();
		for(int x = 0; x< 10; x++)
		{
		    double motionX = rand.nextGaussian() * 0.04D;
		    double motionY = rand.nextGaussian() * 0.04D;
		    double motionZ = rand.nextGaussian() * 0.04D;
		    entityLivingBase.world.spawnParticle(
		    		EnumParticleTypes.SNOW_SHOVEL, 
		          entityLivingBase.posX + rand.nextFloat() * entityLivingBase.width * 2.0F - entityLivingBase.width, 
		          entityLivingBase.posY + 0.5D + rand.nextFloat() * entityLivingBase.height, 
		          entityLivingBase.posZ + rand.nextFloat() * entityLivingBase.width * 2.0F - entityLivingBase.width, 
		          motionX, 
		          motionY, 
		          motionZ);
		}
	}
	
	private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double multiplier) 
    {
		final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());
		final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();
		if (modifierOptional.isPresent()) 
		{
			final AttributeModifier modifier = modifierOptional.get();
			modifiers.remove(modifier);
			modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() * multiplier, modifier.getOperation())); // Add the new modifier
		}
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(this, 0);
	}
}

