/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.ability.Ability;

/**
 * @author mark
 *
 */
public class AddAbilityEnchantment extends WeaponBase {
	private Ability ab;
	private WeaponBase weapon;
	
	@Override
	public void attack(Character attacker, Character attacked,float amount) {
		weapon.attack(attacker, attacked,amount);
	}

	@Override
	public void equip(Character equipper) {
		equipper.addAbility(ab);
		weapon.equip(equipper);
	}

	@Override
	public void unequip(Character equipper) {
		equipper.removeAbility(ab);
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