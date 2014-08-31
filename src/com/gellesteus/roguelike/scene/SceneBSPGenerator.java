package com.gellesteus.roguelike.scene;

import java.util.Random;

public class SceneBSPGenerator {
	private static final int TEMPLATE_CHANCE=20;
	private static final int USED_MAX=100;
	private static final int USED_MIN=40;
	private static final int WALL_BUFFER=1;
	private static final int DIVIDE_MIN=45;
	private static final int DIVIDE_MAX=55;
	
	public static Cell generateSceneBSP(int width,int height,int depth){
		return generateSceneBSP(0,0,width,height,depth,new Level());
	}
	
	private static Cell generateSceneBSP(int x,int y,int width, int height, int depth,Level level){
		Random random = new Random();
		
		if(depth==0){
			if(random.nextInt(100)<=TEMPLATE_CHANCE){
				return RoomTemplate.select(width, height).placeAt(x, y, level);
			}else{
				int xUsed = rand(USED_MAX,USED_MIN)/100*(width-(2*WALL_BUFFER));
				int yUsed = rand(USED_MAX,USED_MIN)/100*(height-(2*WALL_BUFFER));
				int startX= x+rand(width-xUsed-WALL_BUFFER,WALL_BUFFER);
				int startY= y+rand(height-yUsed-WALL_BUFFER,WALL_BUFFER);
				
				Cell first = null;
				
				for(int i = 0;i<width;i++){
					for(int j= 0;j<height;j++){
						if(i>x+startX&&i<x+startX+xUsed &&
								j>y+startY&&j<y+startY+yUsed){
							if(first==null){
								first=new Cell(level,i+x,j+y,Celltype.FLOOR);
							}else{
								new Cell(level,i+x,j+y,Celltype.FLOOR);
							}
						}else{
							if(first==null){
								first = new Cell(level,i+x,j+y,Celltype.WALL);
							}else{
								new Cell(level,i+x,j+y,Celltype.WALL);
							}
						}
					}
				}
				return first;
			}
		}else{
			boolean verticalDivide=random.nextBoolean();
			if(verticalDivide){
				float divide=rand(DIVIDE_MAX,DIVIDE_MIN)/100.0f;
				int heightNew = (int)(divide*height);
				height -= heightNew;
				int yNew = y+height;
				return connectHallways(generateSceneBSP(x,y,width,height,depth-1,level),
						generateSceneBSP(x,yNew,width,heightNew,depth-1,level));
			}else{
				float divide=rand(DIVIDE_MAX,DIVIDE_MIN)/100.0f;
				int widthNew = (int)(divide*width);
				width -= widthNew;
				int xNew = x+width;
				return connectHallways(generateSceneBSP(x,y,width,height,depth-1,level),
						generateSceneBSP(xNew,y,widthNew,height,depth-1,level));
			}
		}
	}
	
	private static Cell connectHallways(Cell c1,Cell c2){
		return null;
	}
	
	private static int rand(int min, int max){
		Random random = new Random();
		return random.nextInt(max-min)+min;
	}
}
