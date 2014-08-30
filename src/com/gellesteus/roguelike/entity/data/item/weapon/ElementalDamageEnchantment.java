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
public class ElementalDamageEnchantment extends WeaponBase {
	private int damage;
	private DamageType dType;
	private WeaponBase weapon;
	@Override
	public void attack(Character attacker, Character attacked) {
		attacked.damage(damage, dType);
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
