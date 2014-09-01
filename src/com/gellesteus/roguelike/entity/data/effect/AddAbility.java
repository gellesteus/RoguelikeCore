package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.ability.Ability;

public class AddAbility extends Effect {
	private Ability ability;
	private boolean hasAbility;
	
	public AddAbility(int duration,Ability ability) {
		super(duration);
		this.ability=ability;
	}

	@Override
	public void onApply() {
		hasAbility=affects.hasAbility(ability);
		if(!hasAbility){
			affects.addAbility(ability);
		}
	}

	@Override
	public void onRemove() {
		if(!hasAbility){
			affects.removeAbility(ability);
		}
	}

	@Override
	public Object clone() {
		return new AddAbility(this.duration,this.ability);
	}
}
