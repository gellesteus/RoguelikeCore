package com.gellesteus.roguelike.entity.ai;

import com.gellesteus.roguelike.entity.Character;

public abstract class Routine {
	protected enum State{
		SUCCESS,
		FAILURE,
		RUNNING;
	}
	
	protected State state;
	
	protected boolean isSuccess(){
		return state==State.SUCCESS;
	}
	
	protected boolean isFailure(){
		return state==State.FAILURE;
	}
	
	protected boolean isRunning(){
		return state==State.RUNNING;
	}

	protected abstract void execute(Character character);
	protected abstract void reset();
}
