package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.attribute.Attribute;

public class IncreaseAttribute extends Effect {
	private int amount;
	private Attribute attribute;
	
	public IncreaseAttribute(int duration,int amount, Attribute attribute) {
		super(duration);
		this.amount=amount;
		this.attribute=attribute;
	}

	@Override
	public void onApply() {
		affects.modAV(attribute, amount);
	}

	@Override
	public void onRemove() {
		affects.modAV(attribute, -amount);
	}

	@Override
	public Object clone() {
		return new IncreaseAttribute(duration,amount,attribute);
	}

	

}
