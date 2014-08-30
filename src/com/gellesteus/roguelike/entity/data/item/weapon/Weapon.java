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
public class Weapon extends WeaponBase{
	private int damage;
	private String name;
	private boolean is2h;
	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.data.item.WeaponBase#attack(com.gellesteus.roguelike.entity.Character, com.gellesteus.roguelike.entity.Character)
	 */
	@Override
	public void attack(Character attacker, Character attacked) {
		attacked.damage(damage, DamageType.PHYSICAL);
	}

	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.data.item.WeaponBase#equip(com.gellesteus.roguelike.entity.Character)
	 */
	@Override
	public void equip(Character equipper) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.data.item.WeaponBase#unequip(com.gellesteus.roguelike.entity.Character)
	 */
	@Override
	public void unequip(Character equipper) {
		// TODO Auto-generated method stub
		
	}

}
