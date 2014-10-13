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
	public void attack(Character attacker, Character attacked,float amount) {
		attacker.heal(attacked.damage((int)(this.amount*amount), DamageType.NEGATIVE));
		weapon.attack(attacker, attacked,amount);
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
