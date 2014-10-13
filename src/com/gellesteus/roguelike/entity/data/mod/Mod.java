package com.gellesteus.roguelike.entity.data.mod;

import java.util.ArrayList;
import java.util.Arrays;

import com.gellesteus.roguelike.entity.Reference;

public class Mod {
	private static ArrayList<Mod> modList = new ArrayList<Mod>();
	private String name;
	private String Author;
	private String Description;
	private int priority;		//Lower priority are loaded first
	private int loadPosition;	//Determined before load
	private int numObjects;
	private int numNewObjects;
	private Reference[] objects;
	public Mod() {
		// TODO Auto-generated constructor stub
	}
	
	public static int totalRefCount(){
		int count=0;
		for(Mod i:modList){
			count+=i.numNewObjects;
		}
		return count;
	}
	
	public static void loadAll(Mod...mods){
		Arrays.sort(mods, (Mod m1,Mod m2) -> m1.priority - m2.priority);
		for(Mod i:mods){
			modList.add(i);
		}
		//Mods ordered, now load.
		Reference.initializePool(totalRefCount());
		for(Mod i:modList){
			for(Reference j:i.objects){
				Reference.addItem(j);
			}
		}
		//Open up all space taken up by mods for GC.
		modList.clear();
		modList=null;
	}
}