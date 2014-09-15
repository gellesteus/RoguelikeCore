/**
 * 
 */
package com.gellesteus.roguelike.entity.condition;

import com.gellesteus.roguelike.entity.Character;

/**
 * @author mark
 *
 */
public class AttributeMax extends Condition {
	private int attribute;
	private int value;
	
	public AttributeMax(int attribute, int value){
		this.value=value;
		this.attribute=attribute;
	}
	
	@Override
	public boolean evaluate(Character character) {
		// TODO Auto-generated method stub
		return false;
	}

}
