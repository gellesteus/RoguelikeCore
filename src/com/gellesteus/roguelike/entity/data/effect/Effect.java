package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.Update;
import com.gellesteus.roguelike.entity.Character;
public abstract class Effect implements Update{
	private int duration;
	private Character affects;
	private Character applier;
	private float durationRemaining;
	public abstract void onApply();
	
	@Override
	public void update(int msPassed) {
		// TODO Auto-generated method stub
		
	}
}
