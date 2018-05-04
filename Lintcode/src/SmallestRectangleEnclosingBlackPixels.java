import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author jguan
 *600. Smallest Rectangle Enclosing Black Pixels
Description
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

Have you met this question in a real interview?  
Example
For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.
 */
public class SmallestRectangleEnclosingBlackPixels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] image = new char[3][];
		String s1 = "0010";
		String s2 = "0110";
		String s3 = "0100";
		image[0] = s1.toCharArray();
		image[1] = s2.toCharArray();
		image[2] = s3.toCharArray();
		int x=0;
		int y=2;
		SmallestRectangleEnclosingBlackPixels sr = new SmallestRectangleEnclosingBlackPixels();
		int res = sr.minArea(image, x, y);
		System.out.println(res);
	}

    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        if(image == null || image.length == 0) return 0;
        Queue<Location> queue = new LinkedList<>();
        int maxX = 0;
        int maxY = 0;
        int minX = image.length - 1;
        int minY = image[0].length - 1;
        Location lc = new Location(x,y);
        queue.offer(lc);
        image[x][y] = '0';
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while(!queue.isEmpty()) {
            Location loc = queue.poll();
            maxX = Math.max(loc.x, maxX);
            minX = Math.min(loc.x, minX);
            maxY = Math.max(loc.y, maxY);
            minY = Math.min(loc.y, minY);
            for(int i = 0 ; i < 4; i ++) {
                int nbrX = loc.x + dx[i];
                int nbrY = loc.y + dy[i];
                Location nbr = new Location(nbrX, nbrY);
                if(inBound(nbr, image) && image[nbrX][nbrY] =='1') {
                    queue.offer(nbr);
                    image[nbrX][nbrY] = '0';
                }
            }
        }
        return (maxY - minY + 1) * (maxX - minX + 1);
    }
    
    private boolean inBound(Location loc, char[][] image) {
        return loc.x >= 0 && loc.x < image.length && loc.y >=0 && loc.y < image[0].length;
    }

	class Location {
	    int x;
	    int y;
	    public Location(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
	
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
	
	//using binary search
    public int minArea2(char[][] image, int x, int y) {
        // write your code here
        if(image == null || image.length == 0 || image[0].length == 0) return 0;
        int row = image.length - 1;
        int col = image[0].length - 1;
        // find left most black
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, col);
        int top = findTop(image, 0, x);
        int bottom = findBottom(image, x, row);
        return (right - left + 1) * (bottom - top + 1);
    }
    
    public boolean isColumnEmpty(char[][] image, int col) {
        for(int r=0; r<image.length;r++) {
            if(image[r][col] == '1') return false;
        }
        return true;
    }
    public boolean isRowEmpty(char[][] image, int row) {
        for(int c=0; c<image[0].length;c++) {
            if(image[row][c] == '1') return false;
        }
        return true;
    }
    
    public int findLeft(char[][] image, int start, int end) {
        while(start + 1 < end) {
            int m = start + (end - start)/2;
            if(isColumnEmpty(image, m)) {
                start = m;
            }
            else {
                end = m;
            }
        }
        if(isColumnEmpty(image, start)) return end;
        else return start;
    }
    
    public int findRight(char[][] image, int start, int end) {
        while(start + 1 < end) {
            int m = start + (end - start)/2;
            if(isColumnEmpty(image, m)) {
                end = m;
            } else {
                start = m;
            }
        }
        if(isColumnEmpty(image, end)) return start;
        else return end;
    }
    
    
    public int findTop(char[][] image, int start, int end) {
        while(start + 1 < end) {
            int m = start + (end - start)/2;
            if(isRowEmpty(image, m)) {
                start = m;
            }
            else {
                end = m;
            }
        }
        if(isRowEmpty(image, start)) return end;
        else return start;
    }
    
    
    public int findBottom(char[][] image, int start, int end) {
        while(start + 1 < end) {
            int m = start + (end - start)/2;
            if(isRowEmpty(image, m)) {
                end = m;
            }
            else {
                start = m;
            }
        }
        if(isRowEmpty(image, end)) return start;
        else return end;
    }
}
