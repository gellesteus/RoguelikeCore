package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.ability.DamageType;
import com.gellesteus.roguelike.entity.data.effect.scaling.NumericValue;

public class ResourceBurn extends Effect {

	private NumericValue damage;
	private int resBurnId;
	private DamageType[] damagetypes;
	
	public ResourceBurn(NumericValue damage,int resBurnId,DamageType...damageTypes){
		super(0);
		this.damage=damage;
		this.resBurnId=resBurnId;
		this.damagetypes=damageTypes;
	}
	
	@Override
	public void update(int msPassed) {
		super.update(msPassed);
	}

	@Override
	public void onApply() {
		int damageDealt = (affects.getAV(resBurnId)>damage.getValue(applier)) ? damage.getValue(applier) : affects.getAV(resBurnId);
		affects.damage(damageDealt, damagetypes);
		affects.modResource(resBurnId, -damageDealt, false);
		affects.removeEffect(this);
	}
	@Override
	public void onRemove() {}

	@Override
	public Object clone() {
		return new ResourceBurn(this.damage,this.resBurnId,this.damagetypes);
	}

}
