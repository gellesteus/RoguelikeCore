package com.gellesteus.roguelike.entity.data.item.weapon;

import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.effect.Effect;
import com.gellesteus.roguelike.entity.data.effect.EffectFactory;

public class EffectEnchantment extends WeaponBase {
	private Effect effect;
	private WeaponBase weapon;
	
	public EffectEnchantment(Effect effect, WeaponBase weapon) {
		this.effect=effect;
		this.weapon=weapon;
	}

	@Override
	public void attack(Character attacker, Character attacked) {
		EffectFactory.CreateEffect(effect, attacked, attacker);
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
