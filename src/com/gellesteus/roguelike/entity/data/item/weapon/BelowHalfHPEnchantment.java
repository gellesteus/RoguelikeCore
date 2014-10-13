package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;

public class BelowHalfHPEnchantment extends WeaponBase {
	private WeaponBase aboveHalf;
	private WeaponBase belowHalf;
	
	@Override
	public void attack(Character attacker, Character attacked,float amount) {
		if(attacker.isBelowHalfHP()){
			belowHalf.attack(attacker, attacked, amount);
		}else{
			aboveHalf.attack(attacker, attacked, amount);
		}
	}

	@Override
	public void equip(Character equipper) {
		belowHalf.equip(equipper);
	}

	@Override
	public void unequip(Character equipper) {
		belowHalf.unequip(equipper);
	}

	@Override
	public boolean hasGemSlot() {
		return belowHalf.hasGemSlot();
	}

	@Override
	public void update(int msPassed, Character equipped) {
		if(equipped.isBelowHalfHP()){
			belowHalf.update(msPassed, equipped);
		}else{
			aboveHalf.update(msPassed, equipped);
		}
	}

}
