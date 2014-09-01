package com.gellesteus.roguelike.entity.data.effect;

public class Charge extends Effect {
	public int x,y;
	
	public Charge(int x, int y) {
		super(0);
		this.x=x;
		this.y=y;
	}

	@Override
	public void onApply() {
		affects.charge(x,y);
	}

	@Override
	public void onRemove() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object clone() {
		return new Charge(x,y);
	}

}
