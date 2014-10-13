package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.ability.DamageType;
import com.gellesteus.roguelike.entity.data.effect.scaling.NumericValue;

public class LifeLeechInstant extends Effect{
	private NumericValue damage;
	
	public LifeLeechInstant(NumericValue damage) {
		super(0);
		this.damage=damage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onApply() {
		applier.heal(affects.damage(damage.getValue(applier),DamageType.NEGATIVE));
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
