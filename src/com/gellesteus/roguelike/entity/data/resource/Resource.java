package com.gellesteus.roguelike.entity.data.resource;

import com.gellesteus.roguelike.entity.Reference;
import com.gellesteus.roguelike.entity.Update;

/*  Mark Kohler
 * 
 * 	Class that contains all resources that can change over the course of the game.
 *  To use an instance of this class, you must prototype from an existing resource.
 */
public class Resource extends Reference implements Update{
	public static final Resource HEALTH = new Resource("Health",0,1,0);
	public static final Resource MANA = new Resource("Mana",0,1,1);
	public static final Resource STAMINA = new Resource("Stamina",0,5,2);
	public static final Resource BLOOD = new Resource("Blood",0,0,3);
	public static final Resource MIND_POINTS = new Resource("Mind Points",0,1,4);
	public static final Resource DIVINE_ENERGY = new Resource("Divine Energy",-100,0,5);
	public static final Resource COMBO_POINT = new Resource("Combo Position",0,0,6);
	public static final Resource SHIELD = new Resource("Shield",0,-5,7);
	public static final Resource AIFEAR = new Resource("AI Fear State Controller",0,-1,8);
	
	protected int min,max;
	protected String name;
	protected float current;
	protected float regenPerSecond;
	protected int ID;
	
	public Resource(Resource resource, int max){
		this.min=resource.min;
		this.name=resource.name;
		this.max=max;
		this.current=max;
		this.ID=resource.ID;
	}
	
	private Resource(String name,int min,int regen,int ID){
		this.min=min;
		this.name=name;
		this.regenPerSecond = regen;
		this.ID=ID;
	}

	public int getID(){
		return ID;
	}
	
	public void modCurrent(int value){
		current += value;
		if(current > max){
			current = max;
		}else if(current < min){
			current = min;
		}
	}
	
	public void setCurrent(int value){
		current = value;
		if(current > max){
			current = max;
		}else if(current < min){
			current = min;
		}
	}

	public void modMax(int value){
		max+= value;
		if(max < min){
			max = min+1;
		}
	}
	
	public void setMax(int value){
		max = value;
		if(max < min){
			max = min+1;
		}
	}
	
	public void modRegen(float value){
		regenPerSecond += value;
	}
	
	public void setRegen(float value){
		regenPerSecond=value;
	}
	
	public int getCurrent(){
		return (int)current;
	}
	
	public int getMax(){
		return max;
	}
	
	public float getRegen(){
		return regenPerSecond;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public void update(int msPassed) {
		//Advance the regeneration of the stat, if it regenerates
		if(regenPerSecond != 0){
			current += regenPerSecond * msPassed / 1000;
		}
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj!=null){
			if(obj.getClass()==this.getClass()){
				return ((Resource)(obj)).name==this.name;
			}
		}
		return false;
	}
}
