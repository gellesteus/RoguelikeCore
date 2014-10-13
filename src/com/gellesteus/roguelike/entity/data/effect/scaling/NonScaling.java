package com.gellesteus.roguelike.entity.data.effect.scaling;

import com.gellesteus.roguelike.entity.Character;

public class NonScaling extends AbstractScaling {
	private int value;
	
	public NonScaling(int value) {
		this.value=value;
	}

	@Override
	protected int getValue(Character character) {
		return value;
	}

}
