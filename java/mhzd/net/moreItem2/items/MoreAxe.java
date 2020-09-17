package mhzd.net.moreItem2.items;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import mhzd.net.moreItem2.Main;
import mhzd.net.moreItem2.init.ModItem;
import mhzd.net.moreItem2.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class MoreAxe extends ItemTool implements IHasModel
{

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);
	private double attack;
	
	
    public MoreAxe(String name, ToolMaterial ma, double attack) 
    {
		super(ma, EFFECTIVE_ON);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabs);
		this.attack = attack;
		this.setMaxDamage((int) (ma.getMaxUses() * 1.3));
		ModItem.ITEMS.add(this);
		
	}
    @Override
	public float getDestroySpeed(ItemStack stack, IBlockState state)
	{
		Material material = state.getMaterial();
		return material != Material.WOOD && material != Material.PLANTS 
				 && material != Material.VINE ? super.getDestroySpeed(stack, state) : this.efficiency; 
	}
    
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) 
    {
        final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);
        if (slot == EntityEquipmentSlot.MAINHAND) 
        {
            replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, 1);
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
			modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() * multiplier, modifier.getOperation()));
		}
	}
	
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		if(this.toolMaterial == ModItem.FIRE_TOOL_MA)
			return ModItem.FIRE_STONE == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		else if(this.toolMaterial == ModItem.WIND_TOOL_MA)
			return ModItem.WIND_STONE == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		else if(this.toolMaterial == ModItem.WATER_TOOL_MA)
			return ModItem.WATER_STONE == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		else if(this.toolMaterial == ModItem.SLIME_TOOL_MA)
			return Items.SLIME_BALL == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		else if(this.toolMaterial == ModItem.OBS_TOOL_MA)
			return ModItem.OBS_STONE == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
		
		return false;
	}
    
	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		Main.proxy.registerModel(this, 0);
	}


	
}
