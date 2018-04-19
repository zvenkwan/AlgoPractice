import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * 477. Surrounded Regions 
 */
/**
 * 
 * @author jguan
 *Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that surrounded region.

Have you met this question in a real interview? 
Example
X X X X
X O O X
X X O X
X O X X
After capture all regions surrounded by 'X', the board should be:

X X X X
X X X X
X X X X
X O X X
 */
public class SurroundedRegions {

    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
     int[] dr = {0, 1, 0 , -1};
     int[] dc = {1, 0 , -1, 0};
    public void surroundedRegions(char[][] board) {
        // write your code here
        if(board == null || board.length < 3 || board[0].length < 3) return;
        Set<Point> keep = new HashSet<Point>();
        LinkedList<Point> queue = new LinkedList<Point>();
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                Point p = new Point(i, 0);
                queue.offer(p);
                keep.add(p);
            }
            if(board[i][board[0].length - 1] == 'O') {
                Point p = new Point(i, board[0].length - 1); 
                queue.offer(p);
                keep.add(p);
            }
        }
        for(int i = 1; i < board[0].length - 1; i++) {
            if(board[0][i] == 'O') {
                Point p = new Point(0, i);
                queue.offer(p);
                keep.add(p);
            }
            if(board[board.length - 1][i] == 'O') {
                Point p = new Point(board.length - 1, i);
                queue.offer(p);
                keep.add(p);
            }
        }
        // System.out.println(keep.size());
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            for(int i = 0 ; i < dr.length; i++) {
                Point next = new Point(curr.r + dr[i], curr.c + dc[i]);
                if(next.isInside(board) && board[next.r][next.c] == 'O' && !keep.contains(next)) {
                    // System.out.println("adding " + next.r + ", " + next.c);
                    queue.offer(next);
                    keep.add(next);
                }
            }
        }
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                if(board[r][c] == 'O' && !keep.contains(new Point(r, c))) {
                    board[r][c] = 'X';
                }
            }
        }
    }
    
    class Point {
        int r;
        int c;
        public Point(int r, int c) {
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
            if(obj == null) return true;
            if(getClass() != obj.getClass()) return false;
            Point other = (Point)obj;
            if(r != other.r) return false;
            if(c != other.c) return false;
            return true;
        }
        public boolean isInside(char[][] board) {
            return this.r >= 0 && this.c >= 0 && this.r < board.length && this.c < board[0].length;
        }
    }
}
