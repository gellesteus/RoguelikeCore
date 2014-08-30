/**
 * 
 */
package com.gellesteus.roguelike.entity.data.ability;
import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.ability.Passive.Trigger;
/**
 * @author mark
 *
 */
public class AbilityFactory {
	public static Ability createAbility(Ability ability,Character owner){
		if(ability instanceof Cast){
			Cast ab = (Cast) ability.clone();
			ab.owner=owner;
			return ab;
		}else if(ability instanceof Melee){
			Melee ab = (Melee) ability.clone();
			ab.owner=owner;
			return ab;
		}else if(ability instanceof Sustained){
			Sustained ab = (Sustained) ability.clone();
			ab.owner=owner;
			return ab;
		}else{ //must be passive
			Passive ab = (Passive) ability.clone();
			ab.owner=owner;
			ab.notify(Trigger.ON_APPLY, owner);
			return ab;
		}
	}
}
