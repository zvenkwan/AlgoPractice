/**
 * 
 * @author jguan
202. Segment Tree Query
Description
For an integer array (index from 0 to n-1, where n is the size of this array), in the corresponding SegmentTree, each node stores an extra attribute max to denote the maximum number in the interval of the array (index from start to end).

Design a query method with three parameters root, start and end, find the maximum number in the interval [start, end] by the given root of segment tree.

It is much easier to understand this problem if you finished Segment Tree Build first.

Have you met this question in a real interview?  
Example
For array [1, 4, 2, 3], the corresponding Segment Tree is:

                  [0, 3, max=4]
                 /             \
          [0,1,max=4]        [2,3,max=3]
          /         \        /         \
   [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
query(root, 1, 1), return 4

query(root, 1, 2), return 4

query(root, 2, 3), return 3

query(root, 0, 2), return 4
 */
public class SegmentTreeQuery {
    /**
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(start == root.start && end == root.end) return root.max;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(start <= root.left.end) left = Math.max(left, query(root.left, start, Math.min(end, root.left.end)));
        if(root.right.start <= end) right = Math.max(right, query(root.right, Math.max(start, root.right.start), end));
        return Math.max(left, right);
    }
    
    private class SegmentTreeNode {
    	public int start, end, max;
    	public SegmentTreeNode left, right;
    	public SegmentTreeNode(int start, int end, int max) {
    		this.start = start;
    		this.end = end;
    		this.max = max;
    		this.left = this.right = null;
    	}
    }
}

