package com.gellesteus.roguelike.entity.data.script;

import java.util.EnumMap;

import com.gellesteus.roguelike.entity.Reference;
import com.gellesteus.roguelike.entity.data.ability.DamageType;
import com.gellesteus.roguelike.entity.Character;

import java.util.HashMap;
import java.util.Stack;
public class Script {
	private EnumMap<ScriptTrigger,Boolean> blocks = new EnumMap<ScriptTrigger,Boolean>(ScriptTrigger.class);
	private HashMap<ScriptTrigger,Stack<ScriptFunctions>> scriptBlocks = new HashMap<ScriptTrigger,Stack<ScriptFunctions>>();
	public Script() {
		//TODO:Ensure all blocks are valid and record their existence.
	}
	
	public void run(ScriptTrigger trigger, Reference caster, Reference target,int magnitude,int duration) throws Exception{
		//Runs for 3 scriptEffect blocks
		
		
	}
	
	private Stack<?> run(Stack<ScriptFunctions> block,HashMap<String,Object> vars) throws Exception{
		Stack<?> returnVals = new Stack<java.lang.Object>();
		while(!block.isEmpty()){
			ScriptFunctions current = block.pop();
			switch(current){
			case IF:
				//Find matching end statement
				int i;
				ScriptFunctions c2;
				for(i=0;i<block.size();i++){
					c2=block.get(i);
					if(c2==ScriptFunctions.IF||c2==ScriptFunctions.ELSE||c2==ScriptFunctions.ENDIF){
						throw new Exception("Script if statement error: Mismatched blocks");
					}else if(c2==ScriptFunctions.THEN){
						 break;
						//Found our next position.
					}
				}
				
				boolean isIfTrue = (boolean)(run((Stack<ScriptFunctions>)block.subList(0, i-1),vars).pop());
				
				if(isIfTrue){
					int ifCount = 0; //Make sure that blocks line up to corresponding statements.
					int j;
					for(j=i;j<block.size();j++){
						c2=block.get(j);	//Find corresponding else or endif
						if(c2==ScriptFunctions.ELSE||c2==ScriptFunctions.ENDIF && ifCount == 0){
							 break;
						}else if(c2==ScriptFunctions.ENDIF){
							ifCount--;
						}else if(c2==ScriptFunctions.IF){
							 ifCount++;
							//Found our next position.
						}
					}
					if(ifCount > 0) throw new Exception("Script if statement error: Mismatched blocks");
					run((Stack<ScriptFunctions>)block.subList(i, j-1),vars);
					break;
				}else{
					int ifCount = 0; //Make sure that blocks line up to corresponding statements.
					int j;
					int k;
					boolean elseFound = false;
					for(j=i;j<block.size();j++){
						c2=block.get(j);	//Find corresponding else
						if(c2==ScriptFunctions.ELSE && ifCount == 0){
							elseFound=true; 
							break;
						}else if(c2==ScriptFunctions.ENDIF && ifCount == 0){
							elseFound=false;
							break;
						}else if(c2==ScriptFunctions.ENDIF){
							ifCount--;
						}else if(c2==ScriptFunctions.IF){
							 ifCount++;
							//Found our next position.
						}
					}
					if(!elseFound) break;
					ifCount = 0;
					
					for(k=j;k<block.size();k++){
						c2=block.get(k);	//Find corresponding else or endif
						if(c2==ScriptFunctions.ELSE||c2==ScriptFunctions.ENDIF && ifCount == 0){
							 break;
						}else if(c2==ScriptFunctions.ENDIF){
							ifCount--;
						}else if(c2==ScriptFunctions.IF){
							 ifCount++;
							//Found our next position.
						}
					}
					run((Stack<ScriptFunctions>)block.subList(j, k-1),vars);
					break;
				}
			case THEN:
				//Serves as a marker for if
				break;
			case ELSE:
				//Serves as a marker for if
				break;
			case ENDIF:
				//Serves as a marker for if
				break;
			case DO:
				break;
			case LOOP:
				//Serves as a marker for loop
				break;
			case BSTART:
				break;
			case BEND:
				//Serves as a marker for bstart
				break;
			case HEAL:
			{
				Character healer = (Character)(returnVals.pop());
				Character healed = (Character)(returnVals.pop());
				int amount = (int)(returnVals.pop());
				healed.heal(amount,healer);
				break;
			}
			case HEALNT:
				break;
			case DAMAGE:
			{
				Character attacker = (Character)(returnVals.pop());
				Character attacked = (Character)(returnVals.pop());
				int amount = (int)returnVals.pop();
				attacked.damage(amount, DamageType.TRUE);
				break;
			}
			case DAMAGENT:
				break;
			case TELEPORT:
				break;
			case TELEPORTNT:
				break;
			case GETAV:
				break;
			case MODAV:
				break;
			case SETAV:
				break;
			case GETAVMAX:
				break;
			case GETX:
				break;
			case GETY:
				break;
			case SETX:
				break;
			case SETY:
				break;
			case GETSTACKS:
				break;
			case ADDSTACKS:
				break;
			case REMOVESTACKS:
				break;
			case HASABILITY:
				break;
			case HASPERK:
				break;
			case ADDABILITY:
				break;
			case ADDPERK:
				break;
			case REMOVEABILITY:
				break;
			case REMOVEPERK:
				break;
			case SPAWN:
				break;
			case PLACEATME:
				break;
			case GETNAME:
				break;
			case SETNAME:
				break;
			case ADDITEM:
				break;
			case ADDITEMNS:
				break;
			case ADDITEMNT:
				break;
			case ADDITEMNSNT:
				break;
			case REMOVEITEM:
				break;
			case REMOVEITEMNS:
				break;
			case REMOVEITEMNT:
				break;
			case REMOVEITEMNSNT:
				break;
			case GETDURATIONREMAINING:
				break;
			case BEGIN:
				break;
			case END:
				break;
			case GETEQUIPPEDITEM:
				break;
			case GETITEMATTRIBUTE:
				break;
			default:
				throw new Exception("Undefined sript function");
				
			}
		}
		return returnVals;
	}
	public void run(ScriptTrigger trigger, Reference mover,int x,int y){
		//Movement block. Only references the character that moves and their location
		if(blocks.get(trigger)){
			
		}
	}
	
	public void run(ScriptTrigger trigger, Reference active,Reference passive,int amount){
		//Healing blocks. Active refers to the actor that the script is called from. In an onHeal block, the healer will be the active ref
		if(blocks.get(trigger)){
			
		}
	}
	

	public void run(ScriptTrigger trigger, Reference active,Reference passive,int amount,DamageType[] dTypes){
		//Damage blocks. Active refers to the actor that the script is called from. In an onDamage block, the attacker will be the active ref
		if(blocks.get(trigger)){
			
		}
	}
	
	public void run(ScriptTrigger trigger, Reference character,Reference item){
		//Item blocks. first reference is the triggering actor, the second the item in question
		if(blocks.get(trigger)){
			
		}
	}
}
