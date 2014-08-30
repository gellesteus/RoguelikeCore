/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.effect.Effect;

/**
 * @author mark
 *
 */
public class ApplyEffectEnchantment extends WeaponBase {
	private Effect effect;
	private Weapon weapon;
	
	@Override
	public void attack(Character attacker, Character attacked) {
		attacked.applyEffect(effect);
		weapon.attack(attacker, attacked);
	}

	@Override
	public void equip(Character equipper) {
		weapon.equip(equipper);
	}

	@Override
	public void unequip(Character equipper) {
		weapon.unequip(equipper);
	}

}
