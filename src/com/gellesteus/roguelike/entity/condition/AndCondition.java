/**
 * 
 */
package com.gellesteus.roguelike.entity.condition;

import com.gellesteus.roguelike.entity.Character;

/**
 * @author mark
 *
 */
public class AndCondition extends Condition {
	private Condition condition1,condition2;
	
	public AndCondition(Condition condition1, Condition condition2){
		this.condition1=condition1;
		this.condition2=condition2;
	}
	
	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.condition.Condition#evalue(com.gellesteus.roguelike.entity.Character)
	 */
	@Override
	public boolean evalue(Character character) {
		return condition1.evalue(character)&condition2.evalue(character);
	}

}
