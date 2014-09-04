/**
 * 
 */
package com.gellesteus.roguelike.entity.data.ability;

import com.gellesteus.roguelike.entity.data.attribute.Attribute;

/**
 * @author mark
 *
 */
public enum DamageType {
	PHYSICAL(Attribute.ARMOR),
	MAGICAL(Attribute.MAGIC_RESIST),
	AIR(Attribute.AIR_RESIST),
	EARTH(Attribute.EARTH_RESIST),
	FIRE(Attribute.FIRE_RESIST),
	WATER(Attribute.WATER_RESIST),
	SHOCK(Attribute.SHOCK_RESIST),
	PSIONIC(Attribute.PSIONIC_RESIST),
	POISON(Attribute.POISON_RESIST),
	POSITIVE(Attribute.POSITIVE_RESISTANCE),
	NEGATIVE(Attribute.NEGATIVE_RESISTANCE),
	TRUE(Attribute.TRUE_RESISTANCE);
	
	private Attribute resistance;
	
	private DamageType(Attribute attribute){
		resistance=attribute;
	}
	
	public Attribute getResistanceAttr(){
		return resistance;
	}
}
