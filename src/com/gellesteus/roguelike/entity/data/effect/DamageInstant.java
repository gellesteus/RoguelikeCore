package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.ability.DamageType;
import com.gellesteus.roguelike.entity.data.effect.scaling.NumericValue;

public class DamageInstant extends Effect {
	private NumericValue damage;
	private DamageType[] damagetypes;
	
	public DamageInstant(NumericValue damage,DamageType...damageTypes){
		super(0);
		this.damage=damage;
		this.damagetypes=damageTypes;
	}
	
	@Override
	public void update(int msPassed) {
		super.update(msPassed);
	}

	@Override
	public void onApply() {
		affects.damage(damage.getValue(applier), damagetypes);
		affects.removeEffect(this);
	}
	@Override
	public void onRemove() {}

	@Override
	public Object clone() {
		return new DamageInstant(this.damage,this.damagetypes);
	}

}
