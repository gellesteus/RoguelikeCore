/**
 * 
 */
package com.gellesteus.roguelike.Renderring;

import com.gellesteus.roguelike.scene.Level;

/**
 * @author mark
 *
 */
public class Camera {
	private static Camera camera = new Camera();
	private int x,y;
	
	public static Camera getCamera(){
		return camera;
	}
	
	public Camera(){
		x=y=0;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public void moveUp(){
		y++;
	}
	
	public void moveDown(){
		y--;
	}
	
	public void moveLeft(){
		x--;
	}
	
	public void moveRight(){
		x++;
	}
	
	public void moveTo(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public void render(Level level){
		
	}
}
