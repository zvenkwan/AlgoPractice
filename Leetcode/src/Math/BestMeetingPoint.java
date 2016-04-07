package Math;

import java.util.List;
import java.util.ArrayList;

/**
 * 296. Best Meeting Point
 * @author zg55
 *A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):
1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 */
public class BestMeetingPoint {
	
	public int minTotalDistance(int[][] grid) {
		if(grid==null || grid.length==0)
			return 0;
//        brute force O(m^2*n^2)
		List l = new ArrayList();
		for(int m=0;m<grid.length;m++) {
			for(int n=0;n<grid[0].length;n++) {
				if(grid[m][n]==1) {
					l.add(m);
					l.add(n);
				}
			}
		}
		if(l.size()<2) 
			return 0;
		int minDist = Integer.MAX_VALUE;
		for(int m=0;m<grid.length;m++) {
			for(int n=0;n<grid[0].length;n++) {
				int dist=0;
				for(int i=0; i<l.size(); i+=2) {
					dist+=Math.abs(m-(Integer)l.get(i));
					dist+=Math.abs(n-(Integer)l.get(i+1));
				}
				minDist = Math.min(minDist, dist);
			}
		}
		return minDist;
    }
	public static void main(String[] args) {
		int[][] grid = new int[][] {
			{1,0,0,0,1},
			{0,0,0,0,0},
			{0,0,1,0,0}
		};
		int d = new BestMeetingPoint().minTotalDistance(grid);
		System.out.println(d);
	}

}
