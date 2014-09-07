package com.gellesteus.roguelike.scene;

public class Room {
	int x,y,width,height;
	
	public Room(int x,int y,int width,int height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}

	public boolean collides(Room room){
		if(this.x+this.width<room.x){
			return false;
		}
		if(this.y+this.height<room.y){
			return false;
		}
		if(room.x+room.width<this.x){
			return false;
		}
		if(room.y+room.height<this.y){
			return false;
		}
		return true;
	}
}
