/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.resource.Resource;

/**
 * @author mark
 *
 */
public class ResourceBurnEnchantment extends WeaponBase{
	private Weapon weapon;
	private int amount;
	private Resource resource;
	
	@Override
	public void attack(Character attacker, Character attacked) {
		attacked.modAV(resource, -amount);
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
