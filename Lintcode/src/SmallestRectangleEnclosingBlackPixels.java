import java.util.LinkedList;
import java.util.Queue;

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
}
