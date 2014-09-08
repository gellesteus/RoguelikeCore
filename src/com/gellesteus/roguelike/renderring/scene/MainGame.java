package com.gellesteus.roguelike.renderring.scene;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gellesteus.roguelike.scene.Level;

public class MainGame implements Screen{
	SpriteBatch batch;
	private Texture wall;
	private Texture floor;
	private Sprite wSprite;
	private Sprite fSprite;
	private Level level;
	private int x =0;
	private int y = 0;
	
	public MainGame(){
		batch = new SpriteBatch();
		wall= new Texture(Gdx.files.internal("data/graphics/tiles/generic/wall.jpg"));
		floor= new Texture(Gdx.files.internal("data/graphics/tiles/generic/floor.jpg"));
		wSprite = new Sprite(wall);
		fSprite = new Sprite(floor);
		level = new Level(100,100);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			x--;
		}else if(Gdx.input.isKeyPressed(Input.Keys.D)){
			x++;
		}else if(Gdx.input.isKeyPressed(Input.Keys.W)){
			y++;
		}else if(Gdx.input.isKeyPressed(Input.Keys.S)){
			y--;
		}
		if(x<0){
			x=0;
		}else if(x>100){
			x=1000;
		}
		
		if(y<0){
			y=0;
		}else if(y>100){
			y=100;
		}
		batch.begin();
		level.render(x,y,wSprite, fSprite, batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
