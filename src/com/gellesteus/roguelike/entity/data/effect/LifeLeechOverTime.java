package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.ability.DamageType;

public class LifeLeechOverTime extends Effect {
	private int dps;
	
	public LifeLeechOverTime(int duration,int dps) {
		super(duration);
		this.dps=dps;
	}

	public void update(int msPassed){
		int damage = dps*(msPassed/1000);
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
