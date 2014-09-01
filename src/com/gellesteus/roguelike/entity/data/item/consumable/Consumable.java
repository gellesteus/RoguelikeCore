package com.gellesteus.roguelike.entity.data.item.consumable;

import com.gellesteus.roguelike.entity.data.effect.Effect;
import com.gellesteus.roguelike.entity.data.effect.EffectFactory;
import com.gellesteus.roguelike.entity.data.item.Item;
import com.gellesteus.roguelike.entity.Character;
public class Consumable extends Item{
	private Effect effect;
	
	public Consumable(Effect effect) {
		this.effect=effect;
	}
	
	public void use(Character user){
		EffectFactory.CreateEffect(effect, user, user);
	}

}
