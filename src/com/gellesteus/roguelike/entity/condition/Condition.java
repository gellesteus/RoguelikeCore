package com.gellesteus.roguelike.entity.condition;

import com.gellesteus.roguelike.entity.Character;

public abstract class Condition {
	/*Evaluates the condition and returns it.
	 * 
	 */
	public abstract boolean evalue(Character character);
}
