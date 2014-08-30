package com.gellesteus.roguelike.entity.data.perk;

import com.gellesteus.roguelike.entity.condition.Condition;
import com.gellesteus.roguelike.entity.data.ability.Passive;
import com.gellesteus.roguelike.entity.Character;
public class Perk {
	private String name;
	private String decription;
	private Condition requirements;
	private Passive effect;
	
	public boolean isEligible(Character character){
		return requirements.evaluate(character);
	}
	
	public Passive getEffect(){
		return effect;
	}
}
