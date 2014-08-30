/**
 * 
 */
package com.gellesteus.roguelike.scene;

/**
 * @author mark
 *
 */
public class Cell {
	private Cell left,right,up,down=null;
	private int x,y;
	private Celltype celltype;
	
	public Cell(Level level, int x, int y, Celltype celltype){
		if(!level.isFinal()){
			this.x=x;
			this.y=y;
			this.celltype=celltype;
			link(level);
		}//Discard it if else. TODO log exception
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Cell getLeft(){
		return left;
	}
	
	public Cell getRight(){
		return right;
	}
	
	public Cell getUp(){
		return up;
	}
	
	public Cell getDown(){
		return down;
	}
	
	public void link(Level level){
		if(!level.isFinal()){
			linkCells(level.cellAt(x, y+1));
			linkCells(level.cellAt(x, y-1));
			linkCells(level.cellAt(x-1, y));
			linkCells(level.cellAt(x+1, y));
		}//Cannot change a finalized cell. TODO: log exception
	}
	
	private void linkCells(Cell cell){
		if(cell!=null){
			if(cell.y>y){
				up=cell;
				cell.down=this;
			}else if(cell.y<y){
				down=cell;
				cell.up=this;
			}else if(cell.x>x){
				left=cell;
				cell.right=this;
			}else if(cell.x<x){
				right=cell;
				cell.left=this;
			}
		}
	}
}
