package com.gellesteus.roguelike.entity;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

import com.gellesteus.roguelike.entity.data.ability.Ability;
import com.gellesteus.roguelike.entity.data.ability.AbilityFactory;
import com.gellesteus.roguelike.entity.data.ability.DamageType;
import com.gellesteus.roguelike.entity.data.ability.Passive.Trigger;
import com.gellesteus.roguelike.entity.data.attribute.Attribute;
import com.gellesteus.roguelike.entity.data.perk.Perk;
import com.gellesteus.roguelike.entity.data.race.Race;
import com.gellesteus.roguelike.entity.data.resource.Resource;
import com.gellesteus.roguelike.entity.data.tag.Tag;
import com.gellesteus.roguelike.entity.data.characterclass.Class;
import com.gellesteus.roguelike.entity.data.diety.Diety;
import com.gellesteus.roguelike.entity.data.effect.Effect;
import com.gellesteus.roguelike.entity.data.effect.EffectFactory;
import com.gellesteus.roguelike.entity.data.item.Item;
import com.gellesteus.roguelike.entity.data.item.weapon.WeaponBase;
import com.gellesteus.roguelike.entity.data.item.armor.ArmorBase;
import com.gellesteus.roguelike.entity.data.item.armor.Slot;
import com.gellesteus.roguelike.entity.data.item.consumable.Consumable;
public class Character extends Reference implements Update {
	private static final int RESIST_HALF_POINT = 100;
	
	private String name;
	private Race race;
	private boolean isMale;
	
	private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	private ArrayList<Ability> abilities = new ArrayList<Ability>();
	private ArrayList<Resource> resources = new ArrayList<Resource>();
	private ArrayList<Perk> perks = new ArrayList<Perk>();
	private ArrayList<Effect> effects = new ArrayList<Effect>();
	private HashMap<Item,Integer> inventory = new HashMap<Item,Integer>();
	
	private WeaponBase equippedWeapon;
	private EnumMap<Slot,ArmorBase> equippedArmor = new EnumMap<Slot,ArmorBase>(Slot.class);
	
	private EnumMap<Tag,Boolean> actions = new EnumMap<Tag,Boolean>(Tag.class);
	
	private Resource health = new Resource(Resource.HEALTH,10);
	private int level;
	private Class cClass;
	
	private int gcd;
	private int maxGcd;
	
	private int x,y;
	
	
	public int getDevotionTo(Diety diety){
		return 0;
		//TODO Write this
	}
	
	public int getNumTaggedPerks(Tag tag){
		int count=0;
		for(Perk i:perks){
			if(i.isTag(tag)){
				count++;
			}
		}
		return count;
	}
	
	public boolean isVampire(){
		//Vampirism is a hard-coded ability
		return false;
	}
	
	public void disallowAction(Tag tag){
		actions.put(tag, false);
	}
	
	public void allowAction(Tag tag){
		actions.put(tag,true);
	}
	
	public boolean isActionAllowed(Tag tag){
		return actions.get(tag);
	}
	
	public boolean hasPerk(Perk perk){
		return perks.contains(perk);
	}
	
	public void addPerk(Perk perk){
		perks.add(perk);
		addAbility(perk.getEffect());
	}
	
	public boolean isBelowHalfHP(){
		return health.getCurrent()<=(health.getMax()*0.5);
	}
	
	public boolean hasAbility(Ability ability){
		return abilities.contains(ability);
	}
	
	public boolean hasAbility(int ability){
		for(Ability i:abilities){
			if(i.getID()==ability){
				return true;
			}
		}
		return false;
	}
	
	public void addItem(Item item, int amount){
		if(inventory.containsKey(item)){
			inventory.put(item,inventory.get(item)+amount);
		}else{
			inventory.put(item,amount);
		}
	}
	
	public void removeItem(Item item, int amount){
		if(inventory.containsKey(item)){
			int after = inventory.get(item)-amount;
			if(after>0){
				inventory.put(item,inventory.get(item)-amount);
			}else{
				inventory.remove(item);
			}
		}
	}
	
	public int getItemCount(Item item){
		if(inventory.containsKey(item)){
			return inventory.get(item);
		}
		return 0;
	}
	
	public void equip(WeaponBase weapon){
		if(getItemCount(weapon)>0){
			if(equippedWeapon != null){
				equippedWeapon.unequip(this);
				addItem(equippedWeapon,1);
			}
			equippedWeapon=weapon;
			weapon.equip(this);
			removeItem(equippedWeapon,1);
		}
	}
	
	public void equip(ArmorBase armor){
		if(getItemCount(armor)>0){
			if(equippedArmor.get(armor.getSlot())!=null){
				ArmorBase toUnequip = equippedArmor.get(armor.getSlot());
				toUnequip.onUnequip(this);
				addItem(toUnequip,1);
			}
			removeItem(armor,1);
			equippedArmor.put(armor.getSlot(), armor);
			armor.onEquip(this);
		}
	}
	
	public void equip(Consumable consumable){
		consumable.use(this);
	}
	
	public Race getRace(){
		return race;
	}
	
	public int getLevel(){
		return level;
	}
	
	public Class getCharacterClass(){
		return cClass;
	}
	
	public boolean castAbility(Ability ab,int x,int y){
		if(gcd<=0){
			if(abilities.contains(ab)){
				if(ab.canCast(this)){
					ab.cast(x, y);
					gcd=maxGcd;
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void modResource(int resource, int amount,boolean max){
		for(Resource i:resources){
			if(i.getID()==resource){
				if(max){
					i.modMax(amount);
					return;
				}
				i.modCurrent(amount);
				return;
			}
		}
	}
	
	public void modAV(int attribute, int amount){
		for(Attribute i:attributes){
			if(i.getID()==attribute){
				i.modAttribute(amount);
				return;
			}
		}
	}
	
	public void modAV(Attribute attribute,int amount){
		if(attributes.contains(attribute)){
			attributes.get(attributes.indexOf(attribute)).modAttribute(amount);
		}else{
			attributes.add(new Attribute(attribute, amount));
		}
	}
	
	public void setAV(Attribute attribute,int amount){
		if(attributes.contains(attribute)){
			attributes.get(attributes.indexOf(attribute)).setAttribute(amount);
		}else{
			attributes.add(new Attribute(attribute, amount));
		}
	}
	
	public void modAV(Resource attribute,int amount){
		if(resources.contains(attribute)){
			resources.get(attributes.indexOf(attribute)).modCurrent(amount);
		}else{
			resources.add(new Resource(attribute, amount));
		}
	}
	
	public void increaseMaxResource(Resource attribute,int amount){
		if(resources.contains(attribute)){
			resources.get(attributes.indexOf(attribute)).modMax(amount);
		}else{
			resources.add(new Resource(attribute, amount));
		}
	}
	
	public void setAV(Resource attribute,int amount){
		if(resources.contains(attribute)){
			resources.get(attributes.indexOf(attribute)).setCurrent(amount);
		}else{
			resources.add(new Resource(attribute, amount));
		}
	}
	
	public void removePerk(Perk perk){
		if(perks.contains(perk)){
			removeAbility(perk.getEffect());
			perks.remove(perk);
		}
	}
	
	public void removeAbility(Ability ability){
		if(hasAbility(ability)){
			abilities.get(abilities.indexOf(ability)).notify(Trigger.ON_REMOVE, this);
			abilities.remove(ability);
		}
	}
	
	public void applyEffect(Effect effect){
		EffectFactory.CreateEffect(effect, this, this);
	}
	
	public void addEffect(Effect effect){
		//Use apply effect or you will get nullpointerexceptions.
		effects.add(effect);
	}
	
	public void removeEffect(Effect effect){
		if(effects.contains(effect)){
			effects.remove(effect);
		}
	}
	
	public int heal(int amount){
		return amount;
	}
	
	public int heal(int amount, Character healer) {
		return amount;
	}
	
	public int getAttribute(Attribute attribute){
		return 0;
	}
	
	public int getAV(int attribute){
		for(Attribute i :attributes){
			if(i.getID()==attribute){
				return i.getCurrentValue();
			}
		}
		for(Resource i :resources){
			if(i.getID()==attribute){
				return i.getCurrent();
			}
		}
		return 0;
	}
	
	public int damage(int amount, DamageType...damageTypes){
		for(DamageType i:damageTypes){
			amount *= getAttribute(i.getResistanceAttr())/(getAttribute(i.getResistanceAttr())+RESIST_HALF_POINT);
		}
		health.modCurrent(-amount);
		return amount;
		//TODO: method stub
	}
	
	public void moveUp(){
		y--;
	}
	
	public void moveDown(){
		y++;
	}
	
	public void moveLeft(){
		x++;
	}
	
	public void moveRight(){
		x--;
	}
	
	public void charge(int x,int y){
		notifyAll(Trigger.ON_CHARGE);
	}
	
	public void teleport(int x,int y){
		this.x=x;
		this.y=y;
		notifyAll(Trigger.ON_TELEPORT);
	}
	
	public void attack(Character attacked){
		
	}
	
	private void notifyAll(Trigger trigger){
		for(Ability i:abilities){
			i.notify(trigger,this);
		}
	}
	
	private void notifyAll(Trigger trigger,Character character){
		for(Ability i:abilities){
			i.notify(trigger,character);
		}
	}
	
	public void addAbility(Ability ability){
		abilities.add(AbilityFactory.createAbility(ability, this));
	}
	
	/** 
	 *  Update all needed members of the character.
	 */
	@Override
	public void update(int msPassed) {
		for(Attribute i:attributes){
			i.update(msPassed);
		}
		for(Ability i:abilities){
			i.update(msPassed);
		}
		for(Resource i:resources){
			i.update(msPassed);
		}
		for(Effect i:effects){
			i.update(msPassed);
		}
		if(gcd>0){
			gcd-=msPassed;
		}
		if(gcd<0){
			gcd=0;
		}
		health.update(msPassed);
	}



}
