/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;

/**
 * @author mark
 *
 */
public class HealthOnHitEnchantment extends WeaponBase{
	private WeaponBase weapon;
	private int amount;
	
	@Override
	public void attack(Character attacker, Character attacked) {
		attacker.heal(amount);
		weapon.attack(attacker, attacked);
	}

	@Override
	public void equip(Character equipper) {
		weapon.equip(equipper);
	}

	@Override
	public void unequip(Character equipper) {
		weapon.equip(equipper);
	}

}
