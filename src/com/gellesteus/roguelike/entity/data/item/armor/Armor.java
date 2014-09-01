/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.armor;

import com.gellesteus.roguelike.entity.Character;
/**
 * @author mark
 *
 */
public class Armor extends ArmorBase {
	private Slot slot;
	
	public void onEquip(Character equipper){
		
	}
	
	public void onUnequip(Character equipper){
		
	}
	
	public Slot getSlot(){return slot;}
}
