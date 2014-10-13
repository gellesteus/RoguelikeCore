package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.attribute.Attribute;
import com.gellesteus.roguelike.entity.data.effect.scaling.NumericValue;

public class IncreaseAttribute extends Effect {
	private NumericValue amount;
	private Attribute attribute;
	private int valAtCast=0;
	
	public IncreaseAttribute(int duration,NumericValue amount, Attribute attribute) {
		super(duration);
		this.amount=amount;
		this.attribute=attribute;
	}

	@Override
	public void onApply() {
		valAtCast=amount.getValue(applier);
		affects.modAV(attribute, valAtCast);
	}

	@Override
	public void onRemove() {
		affects.modAV(attribute, -valAtCast);
	}

	@Override
	public Object clone() {
		return new IncreaseAttribute(duration,amount,attribute);
	}

	

}
