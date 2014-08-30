package com.gellesteus.roguelike.entity.data.ability;

import com.gellesteus.roguelike.entity.Character;

public class Sustained extends Ability {
	private Passive ability;
	
	
	/**
	 * @param ability
	 * @param character
	 */
	public Sustained(Ability ability, Character character) {
		super(ability, character);
		// TODO Auto-generated constructor stub
	}

	public Sustained(){super();}
	
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
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see com.gellesteus.roguelike.entity.data.ability.Ability#clone()
	 */
	@Override
	public Object clone() {
		Sustained cast= new Sustained();
		cast.name=this.name;
		cast.castCondition=this.castCondition;
		cast.cooldownMax=this.cooldownMax;
		cast.ability=this.ability;
		return cast;
	}

}
