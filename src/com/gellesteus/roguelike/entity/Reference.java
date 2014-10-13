package com.gellesteus.roguelike.entity;

import com.gellesteus.util.RingBuffer;
import java.lang.reflect.Array;

public abstract class Reference {
	private int id;	//Each id must be unique. If it is not bad things will happen.
	private boolean isDynamic;	//True if object is not defined in memory, but created at runtime.
								//Each mod contains a buffer with eachof the objects added by it
	private static Reference[] staticObjectPool = null;
	private static RingBuffer<Reference> dynamicObjectPool = new RingBuffer<Reference>(1024,Reference.class);
	
	public Reference() {
		//null constructor
	}
	
	public static void initializePool(int size){
		if(staticObjectPool==null){
			staticObjectPool = (Reference[]) Array.newInstance(Reference.class,size);
		}
	}
	
	public void freeID(){
		//Unloads a dynamic ID from memory and deletes the object
		if(isDynamic){
			dynamicObjectPool.dispose(this);
		}
	}
	
	public static void assignID(){
		//Most IDs are assigned at creation.
		//dynamic IDs (IDs for objects found in the world that are not the player) are assigned as they are created at runtime
	}

	public static void addItem(Reference item){
		staticObjectPool[item.id]=item;
	}
}
