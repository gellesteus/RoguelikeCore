/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.item.Item;
/**
 * @author mark
 *
 */
public abstract class WeaponBase extends Item{
	public abstract void attack(Character attacker, Character attacked);
	public abstract void equip(Character equipper);
	public abstract void unequip(Character equipper);
	
}
