package com.gellesteus.roguelike.entity.data.ability;

import com.gellesteus.roguelike.entity.Character;


public class Melee extends Ability {

	/**
	 * @param ability
	 * @param character
	 */
	public Melee(Ability ability, Character character) {
		super(ability, character);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public Melee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.Update#update(int)
	 */
	@Override
	public void update(int msPassed) {
		super.update(msPassed);
	}

	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.data.ability.Ability#caster(com.gellesteus.roguelike.entity.Character, int, int)
	 */
	@Override
	public void cast(int x, int y) {
		this.cooldownCurrent=cooldownMax;
	}
	
	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.data.ability.Ability#clone()
	 */
	@Override
	public Object clone() {
		Melee cast= new Melee();
		cast.name=this.name;
		cast.castCondition=this.castCondition;
		cast.cooldownMax=this.cooldownMax;
		return cast;
	}

}
