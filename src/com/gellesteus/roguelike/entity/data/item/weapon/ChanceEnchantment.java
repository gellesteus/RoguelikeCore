/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.weapon;

import java.util.Random;

import com.gellesteus.roguelike.entity.Character;

/**
 * @author mark
 *
 */
public class ChanceEnchantment extends WeaponBase{
	//Enchantment's weapon field should be the same as this weapon field
	private WeaponBase weapon;
	private WeaponBase enchantment;
	private float chance;
	private Random random = new Random();
	
	@Override
	public void attack(Character attacker, Character attacked,float amount) {
		if(random.nextFloat()<=chance){
			enchantment.attack(attacker, attacked,amount);
		}else{
			weapon.attack(attacker, attacked,amount);
		}
	}

	@Override
	public void equip(Character equipper) {
		enchantment.equip(equipper);
	}

	@Override
	public void unequip(Character equipper) {
		enchantment.unequip(equipper);
	}
	
	@Override
	public boolean hasGemSlot() {
		return weapon.hasGemSlot();
	}

	@Override
	public void update(int msPassed, Character equipped) {
		weapon.update(msPassed, equipped);
	}
}
