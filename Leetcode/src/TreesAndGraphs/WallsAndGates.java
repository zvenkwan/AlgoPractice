package TreesAndGraphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 286. Walls and Gates
 * @author zg55
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
  After running your function, the 2D grid should be:
    3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class WallsAndGates {
	private static final int INF = Integer.MAX_VALUE;
	private static final int GATE = 0;
	private static final int WALL = -1;
	public void wallsAndGates(int[][] rooms) {
		
		
		
        if(rooms==null || rooms.length==0) {
        	return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        
        int distance[][] = rooms;
        Queue<Point> q = new LinkedList<Point>();
        for(int row=0;row<m;row++) {
        	for(int col=0;col<n; col++) {
        		if(rooms[row][col]==GATE) {
//        			gate is found, update path
        			q.offer(new Point(row, col));
        		}
        	}
        }
        int dist = 1;
        int currentLevel = q.size();
        int nextLevel = 0;
        while(!q.isEmpty()) {
        	currentLevel-=1;
        	Point pnt = q.poll();
        	if(pnt.row-1>=0 && rooms[pnt.row-1][pnt.col]!=WALL&& rooms[pnt.row-1][pnt.col]!=GATE) {
        		if(distance[pnt.row-1][pnt.col]>dist) {
        		distance[pnt.row-1][pnt.col]=dist;
        		q.offer(new Point(pnt.row-1,pnt.col));
        		nextLevel++;
        		}
        	}
        	if(pnt.row+1<m && rooms[pnt.row+1][pnt.col]!=WALL&& rooms[pnt.row+1][pnt.col]!=GATE) {
        		if(distance[pnt.row+1][pnt.col]>dist) {
        		distance[pnt.row+1][pnt.col]=dist;
        		q.offer(new Point(pnt.row+1,pnt.col));
        		nextLevel++;
        		}
        	}
        	if(pnt.col-1>=0 && rooms[pnt.row][pnt.col-1]!=WALL&& rooms[pnt.row][pnt.col-1]!=GATE) {
        		if(distance[pnt.row][pnt.col-1]>dist) {
        		distance[pnt.row][pnt.col-1]=dist;
        		q.offer(new Point(pnt.row,pnt.col-1));
        		nextLevel++;
        		}
        	}
        	if(pnt.col+1<n && rooms[pnt.row][pnt.col+1]!=WALL&& rooms[pnt.row][pnt.col+1]!=GATE) {
        		if(distance[pnt.row][pnt.col+1]>dist) {
        		distance[pnt.row][pnt.col+1]=dist;
        		q.offer(new Point(pnt.row,pnt.col+1));
        		nextLevel++;
        		}
        	}
        	if(currentLevel == 0) {
        		dist++;
        		currentLevel = nextLevel;
        		nextLevel = 0;
        	}
        }
	}
	
	public static void main(String args[]) {
		int x[][] = new int[][] {
			{INF , -1 , 0  ,INF},
			{INF ,INF ,INF , -1},
			{INF , -1 ,INF , -1},
			{ 0  , -1 ,INF ,INF}
			
		};
        for(int a=0;a<x.length;a++) {

    		System.out.println(Arrays.toString(x[a]));
        }
		new WallsAndGates().wallsAndGates(x);
		System.out.println(Arrays.toString(x[0]));
		System.out.println(Arrays.toString(x[1]));
		System.out.println(Arrays.toString(x[2]));
		System.out.println(Arrays.toString(x[3]));
	}
	
	
	
}

class Point {
	int row;
	int col;
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}