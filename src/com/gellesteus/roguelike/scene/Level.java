/**
 * 
 */
package com.gellesteus.roguelike.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author mark
 *
 */
public class Level {
	private class Node implements Comparator<Node>,Comparable<Node>{
		Cell cell;
		Node parent;
		int g,h;
		
		Node(Cell cell, Node parent,Cell to){
			this.cell=cell;
			this.parent=parent;
			this.g=parent.g+cell.getCelltype().getCost();
			this.h=Math.abs(cell.getX()-to.getX())+Math.abs(cell.getY()-to.getY())*100;
		}
		
		Node(Cell cell, Cell to){
			this.cell=cell;
			this.g=0;
			this.h=Math.abs(cell.getX()-to.getX())+Math.abs(cell.getY()-to.getY())*100;
		}
		
		public boolean equals(Object obj){
			if(obj!=null){
				if(obj.getClass()==this.getClass()){
					return ((Node)obj).cell.equals(cell);
				}else if(obj instanceof Cell){
					return ((Cell)obj).equals(this.cell);
				}
			}
			return false;
		}

		@Override
		public int compare(Node arg0, Node arg1) {
			return arg0.g+arg0.h-arg1.g+arg1.h;
		}

		@Override
		public int compareTo(Node arg0) {
			return compare(this,arg0);
		}
	}
	
	private Cell origin = new Cell(this,0,0,Celltype.FLOOR);
	private boolean finalized = false;
	
	protected Cell getOrigin(){
		return origin;
	}
	
	protected void addCell(Cell cell){
		
	}
	
	protected void connectCrawl(){
		/* Connects the cells by using A* pathfinding to go from center to center.
		 * any wall squares it passes over become non-wall squares
		 * Movement costs are defined in Celltype.java
		 */
		
		ArrayList<Cell> centers = new ArrayList<Cell>();
		//Find centers
 		
		//travel center to center, taking care not to backtrack
		for(Cell i:centers){
			for(Cell j:centers){
				if(i!=j){
					connectHallways(i,j);
				}
			}
		}
	}
	
	private void connectHallways(Cell from,Cell to){
		//Pathfind and clear passed cells.
		ArrayList<Node> open = new ArrayList<Node>();
		ArrayList<Node> closed = new ArrayList<Node>();
		Node current = new Node(from,to);
		open.add(new Node(from,to));
		while(current.cell != to){
			//check all neighbours to find lowest f value
			//Then continue from that point until we reach end
			if(!closed.contains(current.cell.getDown())){
				if(open.contains(current.cell.getDown())){
					Node check = open.get(open.indexOf(current.cell.getDown()));
					Node newN = new Node(current.cell.getDown(),current,to);
					if(newN.g<check.g){
						open.remove(check);
						open.add(newN);
					}
				}else{
					open.add(new Node(current.cell.getDown(),current,to));
				}
			}
			if(!closed.contains(current.cell.getRight())){
				if(open.contains(current.cell.getRight())){
					Node check = open.get(open.indexOf(current.cell.getRight()));
					Node newN = new Node(current.cell.getRight(),current,to);
					if(newN.g<check.g){
						open.remove(check);
						open.add(newN);
					}
				}else{
					open.add(new Node(current.cell.getRight(),current,to));
				}
			}
			if(!closed.contains(current.cell.getLeft())){
				if(open.contains(current.cell.getLeft())){
					Node check = open.get(open.indexOf(current.cell.getLeft()));
					Node newN = new Node(current.cell.getLeft(),current,to);
					if(newN.g<check.g){
						open.remove(check);
						open.add(newN);
					}
				}else{
					open.add(new Node(current.cell.getLeft(),current,to));
				}
			}
			if(!closed.contains(current.cell.getUp())){
				if(open.contains(current.cell.getUp())){
					Node check = open.get(open.indexOf(current.cell.getUp()));
					Node newN = new Node(current.cell.getUp(),current,to);
					if(newN.g<check.g){
						open.remove(check);
						open.add(newN);
					}
				}else{
					open.add(new Node(current.cell.getUp(),current,to));
				}
			}
			open.remove(current);
			closed.add(current);
			if(open.size()==0) return; //Path cannot be found
			Collections.sort(open);
			//Select lowest f value from all squares on open list.
			current=open.get(0);
		}
		while(current.cell != from){
			//Go back through the path carving it out.
			current.cell.setCelltype(Celltype.FLOOR);
			current=current.parent;
		}
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
