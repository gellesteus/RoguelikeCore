package com.gellesteus.roguelike.entity.data.effect.scaling;

import java.util.ArrayList;
import java.util.Arrays;

import com.gellesteus.roguelike.entity.Character;

public class NumericValue {
	private ArrayList<AbstractScaling> values = new ArrayList<AbstractScaling>();
	public NumericValue(AbstractScaling...abstractScalings) {
		values.addAll((ArrayList<AbstractScaling>)Arrays.asList(abstractScalings));
	}

	public int getValue(Character character){
		int value = 0;
		for(AbstractScaling i:values){
			value+=i.getValue(character);
		}
		return value;
	}
}
