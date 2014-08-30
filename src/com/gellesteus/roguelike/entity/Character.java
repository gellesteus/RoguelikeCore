package com.gellesteus.roguelike.entity;

import java.util.ArrayList;

import com.gellesteus.roguelike.entity.data.ability.Ability;
import com.gellesteus.roguelike.entity.data.ability.AbilityFactory;
import com.gellesteus.roguelike.entity.data.ability.DamageType;
import com.gellesteus.roguelike.entity.data.ability.Passive.Trigger;
import com.gellesteus.roguelike.entity.data.attribute.Attribute;
import com.gellesteus.roguelike.entity.data.perk.Perk;
import com.gellesteus.roguelike.entity.data.race.Race;
import com.gellesteus.roguelike.entity.data.resource.Resource;
import com.gellesteus.roguelike.entity.data.characterclass.Class;
import com.gellesteus.roguelike.entity.data.effect.Effect;
public class Character implements Update {
	private String name;
	private Race race;
	private boolean isMale;
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	private ArrayList<Ability> abilities = new ArrayList<Ability>();
	private ArrayList<Resource> resources = new ArrayList<Resource>();
	private ArrayList<Perk> perks = new ArrayList<Perk>();
	private ArrayList<Effect> effects = new ArrayList<Effect>();
	private Resource health = new Resource(Resource.HEALTH,10);
	private int level;
	private Class cClass;
	private int gcd;
	private int maxGcd;
	
	private int x,y;
	
	public boolean hasPerk(Perk perk){
		return perks.contains(perk);
	}
	
	public boolean hasAbility(Ability ability){
		return abilities.contains(ability);
	}
	
	public Race getRace(){
		return race;
	}
	
	public int getLevel(){
		return level;
	}
	
	public Class getCharacterClass(){
		return cClass;
	}
	
	public boolean castAbility(Ability ab,int x,int y){
		if(abilities.contains(ab)){
			if(ab.canCast(this)){
				ab.cast(x, y);
				return true;
			}
		}
		return false;
	}
	
	public void modAV(Attribute attribute,int amount){
		if(attributes.contains(attribute)){
			attributes.get(attributes.indexOf(attribute)).modAttribute(amount);
		}else{
			attributes.add(new Attribute(attribute, amount));
		}
	}
	
	public void setAV(Attribute attribute,int amount){
		if(attributes.contains(attribute)){
			attributes.get(attributes.indexOf(attribute)).setAttribute(amount);
		}else{
			attributes.add(new Attribute(attribute, amount));
		}
	}
	
	public void modAV(Resource attribute,int amount){
		if(resources.contains(attribute)){
			resources.get(attributes.indexOf(attribute)).modCurrent(amount);
		}else{
			resources.add(new Resource(attribute, amount));
		}
	}
	
	public void setAV(Resource attribute,int amount){
		if(resources.contains(attribute)){
			resources.get(attributes.indexOf(attribute)).setCurrent(amount);
		}else{
			resources.add(new Resource(attribute, amount));
		}
	}
	
	public void removeAbility(Ability ab){
		
	}
	
	public void applyEffect(Effect effect){
		
	}
	
	public int heal(int amount){
		return amount;
	}
	
	public int damage(int amount, DamageType...damageTypes){
		return amount;
		//TODO: method stub
	}
	
	public void moveUp(){
		y--;
	}
	
	public void moveDown(){
		y++;
	}
	
	public void moveLeft(){
		x++;
	}
	
	public void moveRight(){
		x--;
	}
	
	public void charge(int x,int y){
		notifyAll(Trigger.ON_CHARGE);
	}
	
	public void teleport(int x,int y){
		this.x=x;
		this.y=y;
		notifyAll(Trigger.ON_TELEPORT);
	}
	
	public void attack(Character attacked){
		
	}
	
	private void notifyAll(Trigger trigger){
		for(Ability i:abilities){
			i.notify(trigger,this);
		}
	}
	
	private void notifyAll(Trigger trigger,Character character){
		for(Ability i:abilities){
			i.notify(trigger,character);
		}
	}
	
	public void addAbility(Ability ability){
		abilities.add(AbilityFactory.createAbility(ability, this));
	}
	
	/** 
	 *  Update all needed members of the character.
	 */
	@Override
	public void update(int msPassed) {
		for(Attribute i:attributes){
			i.update(msPassed);
		}
		for(Ability i:abilities){
			i.update(msPassed);
		}
		for(Resource i:resources){
			i.update(msPassed);
		}
		for(Effect i:effects){
			i.update(msPassed);
		}
		health.update(msPassed);
	}

}
