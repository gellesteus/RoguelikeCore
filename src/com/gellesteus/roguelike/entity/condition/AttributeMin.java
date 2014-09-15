/**
 * @author mark
 */
package com.gellesteus.roguelike.entity.condition;

import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.attribute.Attribute;

/**
 * @author mark
 *
 */
public class AttributeMin extends Condition {
	private int attribute;
	private int value;
	
	public AttributeMin(int attribute,int value){
		this.attribute=attribute;
		this.value=value;
	}
	
	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.condition.Condition#evalue(com.gellesteus.roguelike.entity.Character)
	 */
	@Override
	public boolean evaluate(Character character) {
		// TODO Auto-generated method stub
		return false;
	}

}
