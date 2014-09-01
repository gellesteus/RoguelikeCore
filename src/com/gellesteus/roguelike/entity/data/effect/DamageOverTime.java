package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.ability.DamageType;

public class DamageOverTime extends Effect {
	private int dps;
	private DamageType[] damagetypes;
	
	public DamageOverTime(int dps,int duration,DamageType...damageTypes){
		super(duration);
		this.dps=dps;
		this.damagetypes=damageTypes;
	}
	
	@Override
	public void update(int msPassed) {
		affects.damage((dps*(msPassed/1000)), damagetypes);
		super.update(msPassed);
	}

	@Override
	public void onApply() {}
	@Override
	public void onRemove() {}

	@Override
	public Object clone() {
		return new DamageOverTime(this.dps,this.duration,this.damagetypes);
	}

}
