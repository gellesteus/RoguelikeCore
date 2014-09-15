package com.gellesteus.roguelike.entity.data.attribute;

import java.util.HashMap;

import com.gellesteus.roguelike.entity.Update;

public class Attribute implements Update{
	public static final Attribute STRENGTH = new Attribute("Strength",1);
	public static final Attribute DEXTERITY = new Attribute("Dexterity",2);
	public static final Attribute CONSTITUTION = new Attribute("Constitution",3);
	public static final Attribute INTELLIGENCE = new Attribute("Intelligence",4);
	public static final Attribute WISDOM = new Attribute("Wisdom",5);
	public static final Attribute CHARISMA = new Attribute("Charisma",6);
	
	public static final Attribute ARMOR = new Attribute("Armor",10);
	public static final Attribute MAGIC_RESIST = new Attribute("Magic Resistance",11);
	public static final Attribute FIRE_RESIST = new Attribute("Fire Resistance",12);
	public static final Attribute AIR_RESIST = new Attribute("Air Resistance",13);
	public static final Attribute EARTH_RESIST = new Attribute("Earth Resistance",14);
	public static final Attribute WATER_RESIST = new Attribute("Water Resistance",15);
	public static final Attribute POISON_RESIST = new Attribute("Poison Resistance",16);
	public static final Attribute PSIONIC_RESIST = new Attribute("Psionic Resistance",17);
	public static final Attribute SHOCK_RESIST = new Attribute("Shock Resistance",18);
	public static final Attribute POSITIVE_RESISTANCE = new Attribute("Positive Energy Resistance",19);
	public static final Attribute NEGATIVE_RESISTANCE = new Attribute("Negative Energy Resistance",20);
	public static final Attribute TRUE_RESISTANCE = new Attribute("This should always be 0",21);
	
	public static final Attribute ATTACK_POWER = new Attribute("Attack Power",30);
	public static final Attribute SPELL_POWER = new Attribute("Spell Power",31);
	public static final Attribute SPELL_CRIT = new Attribute("Spell Critical Chance",32);
	public static final Attribute ATTACK_CRIT = new Attribute("Attack Critical Chance",33);
	public static final Attribute CRIT_MULT = new Attribute("Critical Damage",34);
	
	public static final Attribute AI_CAUTION = new Attribute("AI Caution Amount",40);
	
	static{
		ARMOR.derivedFrom.put(3, 0.5f);
		MAGIC_RESIST.derivedFrom.put(3, 0.5f);
		ATTACK_POWER.derivedFrom.put(1, 1.0f);
		ATTACK_POWER.derivedFrom.put(2, 0.5f);
		SPELL_POWER.derivedFrom.put(4, 0.5f);
		SPELL_POWER.derivedFrom.put(5, 1.0f);
		SPELL_CRIT.derivedFrom.put(2, 1.0f);
		ATTACK_CRIT.derivedFrom.put(4, 1.0f);
	}
	
	protected String name;
	protected int ID;
	protected int base;
	protected int derivedValue;
	protected int modifier;
	protected int value;
	protected HashMap<Integer,Float> derivedFrom = new HashMap<Integer,Float>();
	
	public Attribute(Attribute attribute,int base){
		this.name=attribute.name;
		this.derivedFrom=attribute.derivedFrom;
		this.ID=attribute.ID;
	}
	
	private Attribute(String name,int ID){
		this.name=name;
		this.ID=ID;
	}
	
	public void modAttribute(int value){
		this.modifier+=value;
	}
	
	public void setAttribute(int value){
		this.modifier=value;
	}
	
	@Override
	public void update(int msPassed) {
		//make sure that the value is correct;
		if(!derivedFrom.isEmpty()){
			derivedValue = 0;
			//TODO: loop through all attributes and update derived value
		}
		
		value = base+derivedValue+modifier;
		
		if(value < 0){
			value = 0;
		}
	}
	
	public int getID(){
		return ID;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}else{
			if(this.getClass()!=obj.getClass()){
				return false;
			}else{
				return this.ID == ((Attribute)obj).ID;
			}
		}
	}
}
