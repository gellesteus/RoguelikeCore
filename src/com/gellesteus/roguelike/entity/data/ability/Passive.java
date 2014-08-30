package com.gellesteus.roguelike.entity.data.ability;

import java.util.ArrayList;

import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.effect.Effect;

public class Passive extends Ability {
	/**
	 * @param ability
	 * @param character
	 */
	public Passive(Ability ability, Character character) {
		super(ability, character);
		// TODO Auto-generated constructor stub
	}

	public enum Trigger{
		ON_APPLY,
		ON_COMBAT_START,
		ON_COMBAT_END,
		ON_ATTACK,
		ON_SPELL_CAST,
		ON_ATTACK_HIT,
		ON_SPELL_HIT,
		ON_HEALTH_DROP_BELOW_HALF,
		ON_KILL,
		ON_DEATH,
		ON_CHARGE,
		ON_TELEPORT,
		ON_UPDATE;
	}
	
	private class EventHandler{
		Trigger trigger;
		Effect effect;
		int duration;
	}
	
	public Passive(){
		super();
	}
	
	private ArrayList<EventHandler> effects = new ArrayList<EventHandler>();
	
	public void notify(Trigger event,Character notifier){
		for(EventHandler i:effects){
			if(i.trigger==event){
				//TODO notifier.addEffect(effect);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.Update#update(int)
	 */
	@Override
	public void update(int msPassed) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.data.ability.Ability#caster(com.gellesteus.roguelike.entity.Character, int, int)
	 */
	@Override
	public void cast(int x, int y) {
		// Intentionally left black, passives cannot be cast
		
	}
	
	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.data.ability.Ability#clone()
	 */
	@Override
	public Object clone() {
		Passive cast= new Passive();
		cast.name=this.name;
		cast.castCondition=this.castCondition;
		cast.cooldownMax=this.cooldownMax;
		cast.effects=this.effects;
		return cast;
	}
}
