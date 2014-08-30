/**
 * 
 */
package com.gellesteus.roguelike.entity.condition;

import com.gellesteus.roguelike.entity.Character;

/**
 * @author mark
 *
 */
public class NotCondition extends Condition {
	private Condition condition;
	
	public NotCondition(Condition condition){
		this.condition=condition;
	}
	
	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.condition.Condition#evalue(com.gellesteus.roguelike.entity.Character)
	 */
	@Override
	public boolean evalue(Character character) {
		return !condition.evalue(character);
	}

}
