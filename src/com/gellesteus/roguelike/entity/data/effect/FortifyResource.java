package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.resource.Resource;

public class FortifyResource extends Effect{
	int amount;
	Resource resource;
	
	public FortifyResource(int duration,int amount, Resource resource) {
		super(duration);
		this.amount=amount;
		this.resource=resource;
	}

	@Override
	public void onApply() {
		affects.increaseMaxResource(resource, amount);
	}

	@Override
	public void onRemove() {
		affects.increaseMaxResource(resource, -amount);
	}

	@Override
	public Object clone() {
		return new FortifyResource(duration,amount,resource);
	}


}
