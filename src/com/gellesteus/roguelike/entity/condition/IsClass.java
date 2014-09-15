/**
 * 
 */
package com.gellesteus.roguelike.entity.condition;

import com.gellesteus.roguelike.entity.Character;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author mark
 *
 */
public class IsClass extends Condition {
	@XStreamAlias("class")
	private int check;
	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.condition.Condition#evalue(com.gellesteus.roguelike.entity.Character)
	 */
	@Override
	public boolean evaluate(Character character) {
		// TODO Auto-generated method stub
		return false;
	}

}
