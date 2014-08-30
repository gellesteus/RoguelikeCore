package com.gellesteus.roguelike.entity.data.attribute;

import java.util.HashMap;

import com.gellesteus.roguelike.entity.Update;

public class Attribute implements Update{
	public static final Attribute STRENGTH = new Attribute("Strength");
	public static final Attribute DEXTERITY = new Attribute("Dexterity");
	public static final Attribute CONSTITUTION = new Attribute("Constitution");
	public static final Attribute INTELLIGENCE = new Attribute("Intelligence");
	public static final Attribute WISDOM = new Attribute("Wisdom");
	public static final Attribute CHARISMA = new Attribute("Charisma");
	
	public static final Attribute ARMOR = new Attribute("Armor");
	public static final Attribute MAGIC_RESIST = new Attribute("Magic Resistance");
	public static final Attribute FIRE_RESIST = new Attribute("Fire Resistance");
	public static final Attribute AIR_RESIST = new Attribute("Air Resistance");
	public static final Attribute EARTH_RESIST = new Attribute("Earth Resistance");
	public static final Attribute WATER_RESIST = new Attribute("Water Resistance");
	public static final Attribute POISON_RESIST = new Attribute("Poison Resistance");
	
	public static final Attribute ATTACK_POWER = new Attribute("Attack Power");
	public static final Attribute SPELL_POWER = new Attribute("Spell Power");
	public static final Attribute SPELL_CRIT = new Attribute("Spell Critical Chance");
	public static final Attribute ATTACK_CRIT = new Attribute("Attack Critical Chance");
	public static final Attribute CRIT_MULT = new Attribute("Critical Damage");
	
	public static final Attribute AI_CAUTION = new Attribute("AI Caution Amount");
	
	static{
		ARMOR.derivedFrom.put(CONSTITUTION, 0.5f);
		MAGIC_RESIST.derivedFrom.put(CONSTITUTION, 0.5f);
		ATTACK_POWER.derivedFrom.put(STRENGTH, 1.0f);
		ATTACK_POWER.derivedFrom.put(DEXTERITY, 0.5f);
		SPELL_POWER.derivedFrom.put(INTELLIGENCE, 0.5f);
		SPELL_POWER.derivedFrom.put(WISDOM, 1.0f);
		SPELL_CRIT.derivedFrom.put(INTELLIGENCE, 1.0f);
		ATTACK_CRIT.derivedFrom.put(DEXTERITY, 1.0f);
	}
	
	protected String name;
	protected int base;
	protected int derivedValue;
	protected int modifier;
	protected int value;
	protected HashMap<Attribute,Float> derivedFrom = new HashMap<Attribute,Float>();
	
	public Attribute(Attribute attribute,int base){
		this.name=attribute.name;
		this.derivedFrom=attribute.derivedFrom;
	}
	
	private Attribute(String name){
		this.name=name;
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
	
	@Override
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}else{
			if(this.getClass()!=obj.getClass()){
				return false;
			}else{
				return this.name == ((Attribute)obj).name;
			}
		}
	}
}
