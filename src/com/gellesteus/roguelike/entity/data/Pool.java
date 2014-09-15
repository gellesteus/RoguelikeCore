package com.gellesteus.roguelike.entity.data;

import com.gellesteus.roguelike.entity.Update;
import com.gellesteus.util.RingBuffer;

public class Pool<t extends Update> extends RingBuffer<t> implements Update {

	public Pool(int size, Class<t> clazz) {
		super(size, clazz);
	}

	@Override
	public void update(int msPassed) {
		for(t i:buffer){
			i.update(msPassed);
		}
	}

}
