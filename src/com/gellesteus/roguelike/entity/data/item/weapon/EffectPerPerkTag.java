package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.tag.Tag;

public class EffectPerPerkTag extends WeaponBase {
	private WeaponBase weapon;
	private Tag tag;
	private int stat;
	private int am;
	
	@Override
	public void attack(Character attacker, Character attacked,float amount) {
		weapon.attack(attacker, attacked, amount);
	}

	@Override
	public void equip(Character equipper) {
		weapon.equip(equipper);
	}

	@Override
	public void unequip(Character equipper) {
		weapon.unequip(equipper);
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
