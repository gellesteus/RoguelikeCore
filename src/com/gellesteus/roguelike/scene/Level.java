package com.gellesteus.roguelike.scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Level {
	private static final int MAX_ROOM_SIZE=15,MIN_ROOM_SIZE=10;
	private static final int ROOMS_TO_CREATE=20;
	private static final int UP =0,DOWN=1,LEFT=2,RIGHT=3;

	
	private Node[][] graph;

	
	private static class NodeComp implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			return o1.getG()+o1.getH()-o2.getG()+o2.getH();
		}
		
	}
	
	private static final NodeComp comp = new NodeComp();
	
	private void constructGraph(int width, int height){
		graph=new Node[width][height];
		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				Node newNode = new Node(x,y,CellType.WALL);
				graph[x][y]=newNode;
				if(x>0){
					newNode.addNeighbour(graph[x-1][y], LEFT);
				}
				if(y>0){
					newNode.addNeighbour(graph[x][y-1], DOWN);
				}
			}
		}
	}
	
	private ArrayList<int[]> createRooms(int width,int height,int seed){
		ArrayList<int[]> centers = new ArrayList<int[]>();
		ArrayList<Room> created = new ArrayList<Room>();
		Random random=new Random(seed);
		for(int i =0;i<ROOMS_TO_CREATE;i++){
			int xSize = random.nextInt(MAX_ROOM_SIZE-MIN_ROOM_SIZE)+MIN_ROOM_SIZE;
			int ySize = random.nextInt(MAX_ROOM_SIZE-MIN_ROOM_SIZE)+MIN_ROOM_SIZE;
			int x = random.nextInt(width-xSize);
			int y = random.nextInt(height-ySize);
			created.add(new Room(x,y,xSize,ySize));
		}
		ArrayList<Room> toPlace = new ArrayList<Room>();
		for(Room i:created){
			boolean collides = false;
			for(Room j:toPlace){
				if(i.collides(j)){
					collides=true;
					break;
				}
			}
			if(!collides){
				toPlace.add(i);
			}
		}
		
		for(Room i:toPlace){
			centers.add(new int[]{i.x+(i.width/2),i.y+(i.height/2)});
			for(int x=i.x;x<i.x+i.width;x++){
				for(int y=i.y;y<i.y+i.height;y++){
					graph[x][y].setType(CellType.FLOOR);
				}
			}
		}
		
		return centers;
	}
	
	private void crawl(ArrayList<int[]> centers){
		for(int i = 0;i<centers.size();i++){
			for(int j = i+1;j<centers.size();j++){
				connectNode(graph[centers.get(i)[0]][centers.get(i)[1]],graph[centers.get(j)[0]][centers.get(j)[1]]);
			}
		}
	}
	
	private void connectNode(Node node1,Node node2){
		ArrayList<Node> open = new ArrayList<Node>();
		ArrayList<Node> closed = new ArrayList<Node>();
		Node current = node1;
		current.setParent(null);
		current.setG(0);
		current.calculateH(node2);
		System.out.println("Connecting " + node1.getX()+" "+node1.getY()+" to " + node2.getX()+" "+node2.getY());
		while(current != node2){
			for(Node i:current.getNeighbours()){
				if(i!=null){
					if(!closed.contains(i)){
						if(open.contains(i)){
							int g = i.getG();
							i.calculateG(current);
							if(i.getG()>g){
								i.setG(g);
							}else{
								i.setParent(current);
							}
						}else{
							i.calculateG(current);
							i.calculateH(node2);	
							i.setParent(current);
							open.add(i);
							
						}
					}
				}
			}
			
			if(open.size()==0)return;
			
			Collections.sort(open,new Comparator<Node>(){

				@Override
				public int compare(Node arg0, Node arg1) {
					return (arg0.getG()+arg0.getH())-(arg1.getG()+arg1.getH());
				}
			});
			closed.add(current);
			current = open.get(0);
			open.remove(0);
		}
		while(current.getParent()!=null){
			current.setType(CellType.FLOOR);
			current=current.getParent();
		}
	}
	
	public Level(int width,int height){
		Random random = new Random();
		constructGraph(width,height);
		crawl(createRooms(width,height,random.nextInt(32700)));
	}
	
	public Level(int width,int height, int seed){
		constructGraph(width,height);
		crawl(createRooms(width,height,seed));
	}
}
