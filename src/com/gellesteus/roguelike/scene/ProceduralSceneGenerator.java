package com.gellesteus.roguelike.scene;

import java.util.ArrayList;
import java.util.Random;

public class ProceduralSceneGenerator {
	private static final int MAX_ROOMS = 50;
	private static final int MIN_ROOMS = 30;
	private static final int ROOM_SIZE_MAX = 10;
	private static final int ROOM_SIZE_MIN = 5;
	private static final int X_SIZE = 100;
	private static final int Y_SIZE = 100;
	private static class Room{
		int x,y,width,height;
		
		Room(Random random){
			this.x=(random.nextInt(X_SIZE-ROOM_SIZE_MAX));
			this.y=(random.nextInt(Y_SIZE-ROOM_SIZE_MAX));
			this.height=random.nextInt(ROOM_SIZE_MAX-ROOM_SIZE_MIN)+ROOM_SIZE_MIN;
			this.width=random.nextInt(ROOM_SIZE_MAX-ROOM_SIZE_MIN)+ROOM_SIZE_MIN;
		}
		
		private boolean collidesWith(Room room){
			if(this.x>=room.x+room.width){
				return false;
			}else if(this.y>=room.y+room.height){
				return false;
			}else if(room.x>=this.x+this.width){
				return false;
			}else if(room.y>=this.y+this.height){
				return false;
			}else{
				return true;
			}
		}
	}
	
	public static Level generateLevel(int seed){
		//As long as the constants are not changed, will generate the same room each time the
		//function is called with the same seed
		Random random = new Random(seed);
		int roomCount = random.nextInt(MAX_ROOMS-MIN_ROOMS)+MIN_ROOMS;
		ArrayList<Room> rooms = new ArrayList<Room>();
		Level level = new Level();
		for(int i = 0;i<roomCount;i++){
			rooms.add(new Room(random));
		}
		ArrayList<Room> roomF = new ArrayList<Room>();
		for(Room i:rooms){
			boolean collides = false;
			for(Room j:roomF){
				if(i.collidesWith(j)){
					collides = true;
					break;
				}
			}
			if(!collides){
				roomF.add(i);
			}
		}
		//Fill level with walls
		for(int i = 0; i <X_SIZE;i++){
			for(int j = 0;j <Y_SIZE;j++){
				level.addCell(new Cell(i,j,Celltype.WALL));
			}
		}
		//Copy layout to cells
		for(Room i:roomF){
			for(int j=i.x;j<i.x+i.width;j++){
				for(int k=i.y;k<i.y+i.height;k++){
					level.addCell(new Cell(j,k,Celltype.FLOOR));
				}
			}
		}
		//Connect rooms
		level.connectCrawl();
		return level;
		
	}
	
	public static Level generateLevel(){
		Random random = new Random();
		return generateLevel(random.nextInt(32700));
	}
}
