package interviews.gg;

import java.util.HashSet;
/**
 * 
 * @author jguan
 *1644. Plane Maximum Rectangle
Given a n point on the two-dimensional coordinate system, output the maximum area of the rectangle that consisting of four points. If it cannot form a rectangle, output 0

Example
a = [[1,1],[1,2],[2,1],[2,2],[2,3],[3,2],[3,1]], return 2

The four points selected are: [1,1], [1,2], [3,1], [3,2]
a = [[1,1],[1,2],[2,2],[2,3],[3,3],[3,4],[4,4]], return 0

No four points can form a rectangle
Notice
n <= 1000
0 <= x,y <= 1000
each side of the rectangle is required to be perpendicular to the X or Y axis
 */
public class PlaneMaximumRectangle {
    /**
     * @param a: the points
     * @return: return the maximum rectangle area
     */
    public int getMaximum(int[][] a) {
        // write your code here
        HashSet<Point> set = new HashSet<Point>();
        for(int[] arr: a) {
            set.add(new Point(arr));
        }
        int max = 0;
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(set.contains(new Point(a[i][0], a[j][1]))
                && set.contains(new Point(a[j][0], a[i][1]))) {
                    max = Math.max(Math.abs((a[i][0] - a[j][0]) * (a[i][1] - a[j][1])) , max);
                }
            }
        }
        return max;
    }
    
    private class Point {
        int row;
        int col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public Point(int[] arr) {
            this.row = arr[0];
            this.col = arr[1];
        }
        public boolean equals(Object obj) {
		    Point that = (Point) obj;
            return this.row == that.row && this.col == that.col;
        }
        public int hashCode() {
            return this.row * 40009 + this.col;
        }
    }
}
class Point {
	int row;
	int col;
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public Point(int[] arr) {
		this.row = arr[0];
		this.col = arr[1];
	}
	public boolean equals(Object obj) {
		Point that = (Point) obj;
		return this.row == that.row && this.col == that.col;
	}
	public int hashCode() {
		return this.row * 40009 + this.col;
	}
}
