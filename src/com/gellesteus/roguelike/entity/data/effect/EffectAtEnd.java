package com.gellesteus.roguelike.entity.data.effect;


public class EffectAtEnd extends Effect {
	private Effect effect;
	
	public EffectAtEnd(int duration,Effect effect){
		super(duration);
		this.effect=effect;
	}
	
	@Override
	public void update(int msPassed) {
		super.update(msPassed);
	}

	@Override
	public void onApply() {}
	@Override
	public void onRemove() {
		affects.applyEffect(effect);
	}

	@Override
	public Object clone() {
		return new EffectAtEnd(this.duration,this.effect);
	}

	
}
