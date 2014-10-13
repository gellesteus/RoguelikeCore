package com.gellesteus.roguelike.entity.data.ability;

import com.gellesteus.roguelike.entity.Character;

public class Cast extends Ability {

	/**
	 * @param ability
	 * @param character
	 */
	public Cast(Ability ability, Character character) {
		super(ability, character);
		// TODO Auto-generated constructor stub
	}

	public Cast() {
		super();
		//Null constructor
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
	
	public void cast(Character character){
		
	}

	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.data.ability.Ability#clone()
	 */
	@Override
	public Object clone() {
		Cast cast= new Cast();
		cast.name=this.name;
		cast.castCondition=this.castCondition;
		cast.cooldownMax=this.cooldownMax;
		return cast;
	}

}
