/**
 * 
 */
package com.gellesteus.roguelike.scene;

/**
 * @author mark
 *
 */
public enum Celltype {
	FLOOR(1),
	WALL(20),
	WALL_EXIT(4),	//Primarily used for room templates to describe places that you would like the room to exit
	WALL_HARD(50),	//Primarily used for room templates to describe places that you would not like the room to exit
	DOOR(1);
	
	private int cost;
	/* A digger algorithim is used to generate pathways from room to room.
	 * The cost is the movement cost used when it creates the paths.
	 * The costs are set up to favour using existing paths to creating new ones
	 * and to use predefined exit points if at all possible.
	 */
	private Celltype(int cost){
		this.cost=cost;
	}
	
	protected int getCost(){return cost;}
}
