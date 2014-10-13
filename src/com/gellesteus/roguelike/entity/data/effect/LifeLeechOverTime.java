package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.ability.DamageType;
import com.gellesteus.roguelike.entity.data.effect.scaling.NumericValue;

public class LifeLeechOverTime extends Effect {
	private NumericValue dps;
	
	public LifeLeechOverTime(int duration,NumericValue dps) {
		super(duration);
		this.dps=dps;
	}

	public void update(int msPassed){
		int damage = dps.getValue(affects)*(msPassed/1000);
		applier.heal(affects.damage(damage, DamageType.NEGATIVE));
	}
	
	@Override
	public void onApply() {}
	@Override
	public void onRemove() {}

	@Override
	public Object clone() {
		return new LifeLeechOverTime(this.duration,this.dps);
	}

}
