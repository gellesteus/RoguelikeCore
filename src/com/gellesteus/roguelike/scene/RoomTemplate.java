package com.gellesteus.roguelike.scene;

public class RoomTemplate {
	private int width,height;
	private Cell layout;
	
	public RoomTemplate(Cell layout){
		this.layout = new Cell(layout);
	}
	
	public static RoomTemplate select(int width,int height){
		return null;
	}
	
	public Cell placeAt(int x,int y,Level level){
		return null;
	}
}
