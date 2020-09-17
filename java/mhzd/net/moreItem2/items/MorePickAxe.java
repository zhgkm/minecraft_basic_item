package mhzd.net.moreItem2.items;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import com.google.common.collect.Multimap;

import mhzd.net.moreItem2.Main;
import mhzd.net.moreItem2.init.ModItem;
import mhzd.net.moreItem2.util.IHasModel;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class MorePickAxe extends ItemPickaxe implements IHasModel
{
	private double damage;

	public MorePickAxe(String name, ToolMaterial material, double damage) 
	{
		super(material);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabs);
		this.damage = damage;
		this.setMaxDamage((int) (material.getMaxUses() * 1.8));
		ModItem.ITEMS.add(this);
	}

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) 
    {
        final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);
        if (slot == EntityEquipmentSlot.MAINHAND) 
        {
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
		// TODO Auto-generated method stub
		Main.proxy.registerModel(this, 0);
	}

}
