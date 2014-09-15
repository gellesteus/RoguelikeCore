package com.gellesteus.roguelike.entity.data.diety;

import java.util.ArrayList;

import com.gellesteus.roguelike.entity.data.ability.Passive;

/* control class for a diety. Defines all attributes about them.
 * Any reputation passives in any instance of these classes properly created will
 * be added to the hero, hidden.
 * 
 */
public class Diety {
	private String name;
	private String description;
	private Passive rankUp;
	private Passive rankDown;
	private ArrayList<Integer> bonuses = new ArrayList<Integer>();
	private int ID;
	
	public int getID(){
		return ID;
	}
}
