/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.ability.DamageType;

/**
 * @author mark
 *
 */
public class LifeLeechEnchantment extends WeaponBase{
	private WeaponBase weapon;
	private int amount;
	
	@Override
	public void attack(Character attacker, Character attacked) {
		attacker.heal(attacked.damage(amount, DamageType.NEGATIVE));
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
