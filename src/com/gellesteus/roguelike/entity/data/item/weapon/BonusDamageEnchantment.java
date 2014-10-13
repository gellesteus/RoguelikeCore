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
public class BonusDamageEnchantment extends WeaponBase{
	private int damage;
	private WeaponBase weapon;
	
	@Override
	public void attack(Character attacker, Character attacked, float amount) {
		attacked.damage((int)(damage*amount), DamageType.PHYSICAL);
		weapon.attack(attacker, attacked, amount);
	}

	@Override
	public void equip(Character equipper) {
		weapon.equip(equipper);
	}

	@Override
	public void unequip(Character equipper) {
		weapon.equip(equipper);
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
