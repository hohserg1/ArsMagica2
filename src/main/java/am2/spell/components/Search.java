package am2.spell.components;

import java.util.EnumSet;
import java.util.Random;

import am2.api.ArsMagicaApi;
import am2.api.spell.component.interfaces.ISpellComponent;
import am2.api.spell.enums.Affinity;
import am2.playerextensions.BoundPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class Search implements ISpellComponent {

	@Override
	public boolean applyEffectBlock(ItemStack stack, World world, int blockx, int blocky, int blockz, int blockFace, double impactX, double impactY, double impactZ, EntityLivingBase caster){
		return applyEffect(stack, caster);
	}

	@Override
	public boolean applyEffectEntity(ItemStack stack, World world, EntityLivingBase caster, Entity target){
		return applyEffect(stack, caster);
	}
	
	public boolean applyEffect(ItemStack stack, EntityLivingBase caster) {
		BoundPlayer boundPlayerData = BoundPlayer.For(caster);
		Object[] boundPlayerDataObject = boundPlayerData.getData();
		
		if (caster instanceof EntityPlayer && (boundPlayerDataObject[0] != null)) {
			((EntityPlayer)caster).addChatMessage(new ChatComponentText("Name: " + boundPlayerDataObject[0]));
			((EntityPlayer)caster).addChatMessage(new ChatComponentText("Dimension: " + boundPlayerDataObject[1]));
			((EntityPlayer)caster).addChatMessage(new ChatComponentText("X: " + boundPlayerDataObject[2]));
			((EntityPlayer)caster).addChatMessage(new ChatComponentText("Y: " + boundPlayerDataObject[3]));
			((EntityPlayer)caster).addChatMessage(new ChatComponentText("Z: " + boundPlayerDataObject[4]));
		}
		
		return true;
	}

	@Override
	public float manaCost(EntityLivingBase caster){
		return 500;
	}

	@Override
	public float burnout(EntityLivingBase caster){
		return ArsMagicaApi.getBurnoutFromMana(manaCost(caster));
	}

	@Override
	public ItemStack[] reagents(EntityLivingBase caster){
		return null;
	}

	@Override
	public void spawnParticles(World world, double x, double y, double z, EntityLivingBase caster, Entity target, Random rand, int colorModifier){
	}

	@Override
	public EnumSet<Affinity> getAffinity(){
		return EnumSet.of(Affinity.NONE);
	}

	@Override
	public int getID(){
		return 553;
	}

	@Override
	public Object[] getRecipeItems(){
		return new Object[]{
				Items.compass,
				Items.ender_eye,
				Items.filled_map,
				Items.arrow
		};
	}

	@Override
	public float getAffinityShift(Affinity affinity){
		return 0.0f;
	}
}
