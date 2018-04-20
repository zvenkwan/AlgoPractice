import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 
 * @author jguan
 *663. Walls and Gates 
 Description
 Notes
 Testcase
 Judge
Discuss 
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Have you met this question in a real interview? 
Example
Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
return the result:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class WallsandGates {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
     int[] dr = {1, 0, -1, 0};
     int[] dc = {0, 1, 0, -1};
     private static final int WALL = -1;
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        if(rooms == null) return;
        if(rooms.length < 2 && rooms[0] != null && rooms[0].length < 2) return;
        LinkedList<Room> queue = new LinkedList<Room>();
        Set<Room> set = new HashSet<Room>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    Room r = new Room(i, j);
                    queue.offer(r);
                    set.add(r);
                }
            }
        }
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i ++) {
                Room curr = queue.poll();
                rooms[curr.r][curr.c] = step;
                for(int j = 0; j < dr.length; j++) {
                    Room next = new Room(curr.r + dr[j], curr.c + dc[j]);
                    if(next.isInside(rooms) && rooms[next.r][next.c] != WALL && !set.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    }
                }
            }
            step++;
        }
    }
}
class Room {
    int r;
    int c;
    public Room(int r, int c) {
        this.r = r;
        this.c = c;
    }
    public int hashCode() {
        int prime = 31;
        int result = 0;
        result = result * prime + this.r;
        result = result * prime + this.c;
        return result;
    }
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Room room = (Room)obj;
        if(this.r != room.r) return false;
        if(this.c != room.c) return false;
        return true;
    }
    public boolean isInside(int[][] rooms) {
        return r >= 0 && c >= 0 && r < rooms.length && c < rooms[0].length;
    }
}
