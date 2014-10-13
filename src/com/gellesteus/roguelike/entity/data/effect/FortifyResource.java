package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.effect.scaling.NumericValue;
import com.gellesteus.roguelike.entity.data.resource.Resource;

public class FortifyResource extends Effect{
	private NumericValue amount;
	private Resource resource;
	private int valAtCast=0;
	
	public FortifyResource(int duration,NumericValue amount, Resource resource) {
		super(duration);
		this.amount=amount;
		this.resource=resource;
	}

	@Override
	public void onApply() {
		valAtCast=amount.getValue(applier);
		affects.increaseMaxResource(resource,valAtCast);
	}

	@Override
	public void onRemove() {
		affects.increaseMaxResource(resource, -valAtCast);
	}

	@Override
	public Object clone() {
		return new FortifyResource(duration,amount,resource);
	}


}
