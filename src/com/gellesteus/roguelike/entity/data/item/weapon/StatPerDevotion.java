package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;

public class StatPerDevotion extends WeaponBase {
	private int diety;
	private float mult;
	private WeaponBase weapon;
	private int current;
	private int stat;
	
	@Override
	public void attack(Character attacker, Character attacked,float amount) {
		weapon.attack(attacker, attacked, amount);
	}

	@Override
	public void equip(Character equipper) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unequip(Character equipper) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasGemSlot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(int msPassed, Character equipped) {
		// TODO Auto-generated method stub

	}

}
