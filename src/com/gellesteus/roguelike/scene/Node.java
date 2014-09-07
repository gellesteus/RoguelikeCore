package com.gellesteus.roguelike.scene;

import java.util.Comparator;

public class Node {
	private static final int UP =0,DOWN=1,LEFT=2,RIGHT=3;
	
	private Node[] neighbours = new Node[4];
	private Node parent;
	private int x,y,g,h;
	private CellType type;
	
	public Node(int x,int y,CellType type){
		this.setX(x);
		this.setY(y);
		this.setType(type);
	}
	protected void addNeighbour(Node node, int direction){
		switch(direction){
			case UP:
				getNeighbours()[UP]=node;
				node.getNeighbours()[DOWN]=this;
				break;
			case DOWN:
				getNeighbours()[DOWN]=node;
				node.getNeighbours()[UP]=this;
				break;
			case LEFT:
				getNeighbours()[LEFT]=node;
				node.getNeighbours()[RIGHT]=this;
				break;
			case RIGHT:
				getNeighbours()[RIGHT]=node;
				node.getNeighbours()[LEFT]=this;
				break;
		}
	}
	protected void calculateH(Node target){
		this.setH(Math.abs(this.getX()-target.getX())+Math.abs(this.getY()-target.getY()));
	}
	
	protected void calculateG(Node parent){
		this.setG(parent.getG()+getType().getCost());
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node[] getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(Node[] neighbours) {
		this.neighbours = neighbours;
	}
	public CellType getType() {
		return type;
	}
	public void setType(CellType type) {
		this.type = type;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}

}
