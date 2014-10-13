package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;

public class GemSlotEnchantment extends WeaponBase {
	private boolean isReplaced=false;
	private WeaponBase weapon;
	private WeaponBase gem;
	
	@Override
	public void attack(Character attacker, Character attacked,float amount) {
		if(isReplaced){
			gem.attack(attacker, attacked, amount);
		}else{
			weapon.attack(attacker, attacked, amount);
		}
	}

	@Override
	public void equip(Character equipper) {
		if(isReplaced){
			gem.equip(equipper);
		}else{
			weapon.equip(equipper);
		}
	}

	@Override
	public void unequip(Character equipper) {
		if(isReplaced){
			gem.unequip(equipper);
		}else{
			weapon.unequip(equipper);
		}
	}

	@Override
	public boolean hasGemSlot() {
		if(isReplaced)return weapon.hasGemSlot();
		return true;
	}
	
	@Override
	public void update(int msPassed, Character equipped) {
		weapon.update(msPassed, equipped);
	}

}
