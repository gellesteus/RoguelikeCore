package com.gellesteus.roguelike.entity.data.effect;

import com.gellesteus.roguelike.entity.Character;

public class EffectFactory {
	public static void CreateEffect(Effect effect, Character affects, Character applier){
		//Creates and applies effect
		Effect toApply = (Effect) effect.clone();
		toApply.affects=affects;
		toApply.applier=applier;
		affects.addEffect(toApply);
	}
}
