package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.ability.DamageType;

public class DamageOverTime extends Effect {
	private int dps;
	private DamageType[] damagetypes;
	
	public DamageOverTime(int dps, DamageType...damageTypes){
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

}
