package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.ability.DamageType;

public class LifeLeechInstant extends Effect{
	private int damage;
	
	
	public LifeLeechInstant(int damage) {
		super(0);
		this.damage=damage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onApply() {
		applier.heal(affects.damage(damage,DamageType.NEGATIVE));
		affects.removeEffect(this);
	}

	@Override
	public void onRemove() {
		
	}

	@Override
	public Object clone() {
		return new LifeLeechInstant(this.damage);
	}

}
