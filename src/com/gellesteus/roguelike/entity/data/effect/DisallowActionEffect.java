package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.data.tag.Tag;

public class DisallowActionEffect extends Effect {
	private Tag tag;
	
	public DisallowActionEffect(Tag tag,int duration) {
		super(duration);
		this.tag=tag;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onApply() {
		affects.disallowAction(tag);
	}

	@Override
	public void onRemove() {
		affects.allowAction(tag);
	}

	@Override
	public Object clone() {
		return new DisallowActionEffect(this.tag,this.duration);
	}

}
