package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.Update;
import com.gellesteus.roguelike.entity.Character;
public abstract class Effect implements Update,Cloneable{
	protected int duration;
	protected Character affects;
	protected Character applier;
	protected float durationRemaining;
	
	public Effect(int duration){
		this.duration=duration;
		this.durationRemaining=duration*1000.0f;
	}
	
	public void apply(Character affects, Character applier){
		this.affects=affects;
		this.applier=applier;
		this.onApply();
	}
	
	@Override
	public void update(int msPassed){
		durationRemaining -=(msPassed / 1000.0f);
		if(duration < 0){
			affects.removeEffect(this);
		}
	}
	public abstract void onApply();
	public abstract void onRemove();
	public abstract Object clone();
}
