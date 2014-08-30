package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.Update;
import com.gellesteus.roguelike.entity.Character;
public abstract class Effect implements Update{
	protected int duration;
	protected Character affects;
	protected Character applier;
	protected float durationRemaining;
	
	@Override
	public void update(int msPassed){
		durationRemaining -=(msPassed / 1000.0f);
		if(duration < 0){
			affects.removeEffect(this);
		}
	}
	public abstract void onApply();
	public abstract void onRemove();
}
