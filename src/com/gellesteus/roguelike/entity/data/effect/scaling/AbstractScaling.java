package com.gellesteus.roguelike.entity.data.effect.scaling;

import com.gellesteus.roguelike.entity.Character;

public abstract class AbstractScaling {
	
	public AbstractScaling(){}
	
	protected abstract int getValue(Character character);
}
