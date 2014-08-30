/**
 * 
 */
package com.gellesteus.roguelike.entity.data.item.armor;

import com.gellesteus.roguelike.entity.data.item.Item;
import com.gellesteus.roguelike.entity.Character;
/**
 * @author mark
 *
 */
public abstract class ArmorBase extends Item{
	public abstract void onEquip(Character equipper);
	public abstract void onUnequip(Character equipper);
}
