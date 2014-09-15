package com.gellesteus.util;

import java.lang.reflect.Array;

public class RingBuffer<t> {
	protected final t[] buffer;
	private int head;
	
	@SuppressWarnings("unchecked")
	public RingBuffer(int size,Class<t> clazz){
		if(size<1) throw new IllegalArgumentException("Cannot create a ring buffer of zero or negative size");
		buffer=(t[])Array.newInstance(clazz, size);
		head=0;
	}
	
	private int search(t toSearch){
		for(int i = head;i<head+buffer.length;i++){
			if(buffer[i%buffer.length].equals(toSearch)){
				head=i%buffer.length;
				return i%buffer.length;
			}
		}
		return -1;//not found.
	}
	
	public void place(t toPlace){
		buffer[search(null)]=toPlace;
	}
	
	public void dispose(t toDispose){
		int pos = search(toDispose);
		if(pos>-1){
			buffer[pos]=null;
			head=pos;
		}
	}
}
