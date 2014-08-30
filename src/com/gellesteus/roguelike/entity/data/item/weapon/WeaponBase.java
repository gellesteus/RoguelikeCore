/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;
/**
 * @author mark
 *
 */
public abstract class WeaponBase {
	public abstract void attack(Character attacker, Character attacked);
	public abstract void equip(Character equipper);
	public abstract void unequip(Character equipper);
	
}
