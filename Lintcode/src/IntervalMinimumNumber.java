import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jguan
 *205. Interval Minimum Number
Description
Given an integer array (index from 0 to n-1, where n is the size of this array), and an query list. Each query has two integers [start, end]. For each query, calculate the minimum number between index start and end in the given array, return the result list.

We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

Have you met this question in a real interview?  
Example
For array [1,2,7,8,5], and queries [(1,2),(0,4),(2,4)], return [2,1,5]

Challenge
O(logN) time for each query
 */
public class IntervalMinimumNumber {
	/**
     * @param A: An integer array
     * @param queries: An query list
     * @return: The result list
     */
    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        // write your code here
        
        SegmentTreeNode root = build(A, 0, A.length - 1);
        List<Integer> res = new ArrayList<>();
        for(Interval query: queries) {
            res.add(query(root, query.start, query.end));
        }
        return res;
    }
    
    private int query(SegmentTreeNode node, int start, int end) {
        if(node.start == start && node.end == end) {
            return node.min;
        }
        
        int left = Integer.MAX_VALUE;
        int right= Integer.MAX_VALUE;
        
        if(start <= node.left.end) {
            left = Math.min(left, query(node.left, start, Math.min(end, node.left.end)));
        }
        if(node.right.start <= end) {
            right = Math.min(right, query(node.right, Math.max(node.right.start, start), end));
        }
        
        return Math.min(left, right);
    }
    
    private SegmentTreeNode build(int[] A, int start, int end) {
        if(start > end) return null;
        if(start == end) return new SegmentTreeNode(start, end, A[start]);
        SegmentTreeNode snode = new SegmentTreeNode(start, end, A[start]);
        int left_end = (start + end) / 2;
        int right_start = left_end + 1;
        
        SegmentTreeNode left = build(A, start, left_end);
        SegmentTreeNode right = build(A, right_start, end);
        snode.min = Math.min(left.min, right.min);
        snode.left = left;
        snode.right = right;
        return snode;
    }
    
    private class SegmentTreeNode {
        int start, end, min;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int min) {
            this.start = start;
            this.end = end;
            this.min = min;
            this.left = this.right = null;
        }
    }
    
    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}