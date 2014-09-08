package com.gellesteus.roguelike;

import com.badlogic.gdx.Game;
import com.gellesteus.roguelike.renderring.scene.MainGame;

public class Roguelike extends Game {

	
	@Override
	public void create () {
		this.setScreen(new MainGame());
	}

}
