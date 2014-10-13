package com.gellesteus.roguelike.entity.data.perk;

import java.util.ArrayList;

import com.gellesteus.roguelike.entity.condition.Condition;
import com.gellesteus.roguelike.entity.data.ability.Passive;
import com.gellesteus.roguelike.entity.data.tag.Tag;
import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.Reference;
public class Perk extends Reference{
	private String name;
	private String decription;
	private Condition requirements;
	private Passive effect;
	private int ID;
	private ArrayList<Tag> tags = new ArrayList<Tag>();
	
	public Perk(String name, String description, Condition requirements, int ID, Passive effect,Tag...tags){
		this.name=name;
		this.decription=description;
		this.requirements=requirements;
		this.effect=effect;
		this.ID=ID;
		for(Tag i:tags){
			this.tags.add(i);
		}
	}
	
	public boolean isTag(Tag tag){
		return tags.contains(tag);
	}
	
	public boolean isEligible(Character character){
		return requirements.evaluate(character);
	}
	
	public Passive getEffect(){
		return effect;
	}
	
	public int getID(){
		return ID;
	}
}
