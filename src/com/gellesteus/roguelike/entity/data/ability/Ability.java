package com.gellesteus.roguelike.entity.data.ability;

import com.gellesteus.roguelike.entity.Update;
import com.gellesteus.roguelike.entity.condition.Condition;
import com.gellesteus.roguelike.entity.Character;

public abstract class Ability implements Update,Cloneable {
	protected String name;
	protected Condition castCondition;
	protected float cooldownMax;
	protected float cooldownCurrent;
	protected Character owner;
	
	public Ability(Ability ability, Character character){
		this.owner=character;
		this.castCondition=ability.castCondition;
		this.cooldownMax=ability.cooldownMax;
	}
	
	/**
	 * 
	 */
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
			return castCondition.evalue(character);
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
}
