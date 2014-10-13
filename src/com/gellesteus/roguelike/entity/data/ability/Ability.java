package com.gellesteus.roguelike.entity.data.ability;

import java.util.ArrayList;

import com.gellesteus.roguelike.entity.Reference;
import com.gellesteus.roguelike.entity.Update;
import com.gellesteus.roguelike.entity.condition.Condition;
import com.gellesteus.roguelike.entity.Character;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import com.gellesteus.roguelike.entity.data.tag.Tag;

public abstract class Ability extends Reference implements Update,Cloneable {
	protected String name;
	protected Condition castCondition;
	protected float cooldownMax;
	private int ID;
	protected ArrayList<Tag> tags = new ArrayList<Tag>();
	
	@XStreamOmitField
	protected Character owner;
	@XStreamOmitField
	protected float cooldownCurrent;
	
	public Ability(Ability ability, Character character){
		this.owner=character;
		this.castCondition=ability.castCondition;
		this.cooldownMax=ability.cooldownMax;
		this.tags=ability.tags;
	}

	public Ability() {
		// Null constructor
	}

	public void update(int msPassed){
		if(cooldownCurrent > 0){
			cooldownCurrent -= (msPassed/1000);
		}
		if(cooldownCurrent < 0){
			cooldownCurrent = 0;
		}
	}
	
	public boolean canCast(Character character){
		if(!(this instanceof Passive)){
			return castCondition.evaluate(character);
		}
		return false;
	}
	
	public void notify(Passive.Trigger trigger, Character notifier){};
	public abstract void cast(int x, int y);
	
	@Override
	public abstract Object clone();
	
	@Override
	public boolean equals(Object obj){
		if(obj!=null){
			if(this.getClass()==obj.getClass()){
				return this.name==((Ability)(obj)).name;
			}
		}
		return false;
	}

	public int getID() {
		return ID;
	}
}
