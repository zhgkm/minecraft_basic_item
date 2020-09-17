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

public class SoulSword extends ItemSword implements IHasModel
{
	private double damage;
	private double speed;
	
	public SoulSword(String name, ToolMaterial material, double speed, double damage) 
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
			tooltip.add("§3攻速: §a极快");
			tooltip.add("§3效果: §a自身进入隐身状态,攻击附加凋零5秒");
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
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		// TODO Auto-generated method stub
		if(isSelected)
		{
			if(entityIn instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer)entityIn;
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(14), 15*20, 0));
			}
		}
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		// TODO Auto-generated method stub
		target.addPotionEffect(new PotionEffect(Potion.getPotionById(20), 6 * 20, 1));
		return super.hitEntity(stack, target, attacker);
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

