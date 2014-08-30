/**
 * 
 */
package com.gellesteus.roguelike.scene;

/**
 * @author mark
 *
 */
public class Level {
	private Cell origin = new Cell(this,0,0,Celltype.FLOOR);
	private boolean finalized = false;
	
	protected Cell getOrigin(){
		return origin;
	}
	
	protected Cell cellAt(int x, int y){
		if(!isFinal()){
			Cell current = origin;
			while(current.getX() != x){
				if(current.getX()>x){
					if(current.getRight()!= null){
						current=current.getRight();
					}else{
						current = new Cell(this,current.getX()+1,current.getY(),Celltype.WALL);
					}
				}else{
					if(current.getLeft()!= null){
						current=current.getLeft();
					}else{
						current = new Cell(this,current.getX()-1,current.getY(),Celltype.WALL);
					}
				}
			}
			
			while(current.getY() != y){
				if(current.getY()>y){
					if(current.getUp()!= null){
						current=current.getUp();
					}else{
						current = new Cell(this,current.getX(),current.getY()+1,Celltype.WALL);
					}
				}else{
					if(current.getDown()!= null){
						current=current.getDown();
					}else{
						current = new Cell(this,current.getX(),current.getY()-1,Celltype.WALL);
					}
				}
			}
			
			return current;
		}else{
			return null;
			//TODO Log exception
		}
		
	}
	public boolean isFinal(){
		return finalized;
	}
	
	public void Cull(){
		//After cell is culled, prevent it from being further editted.
		//New statics, characters and items can be created and placed,
		//but the underlying layout cannot be changed
		//Removes all unaccessible squares and frees up their memory for garbage collection
		if(!isFinal()){
			
			finalized = true;
		}
	}
}
