package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.ability.DamageType;

public class LifeLeechInstant extends Effect{
	private int damage;
	
	@Override
	public void onApply() {
		applier.heal(affects.damage(damage,DamageType.NEGATIVE));
		affects.removeEffect(this);
	}

	@Override
	public void onRemove() {
		
	}

}
