/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.armor;

import com.gellesteus.roguelike.entity.Character;
import com.gellesteus.roguelike.entity.data.ability.Ability;

/**
 * @author mark
 *
 */
public class AbilityEnchantment extends ArmorBase {
	private Ability ab;
	private ArmorBase armor;
	
	@Override
	public void onEquip(Character equipper) {
		equipper.addAbility(ab);
		armor.onEquip(equipper);
	}

	@Override
	public void onUnequip(Character equipper) {
		equipper.removeAbility(ab);
		armor.onUnequip(equipper);
	}
	
}
