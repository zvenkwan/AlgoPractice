/**
 * 
 * @author jguan
 *201. Segment Tree Build
Description
The structure of Segment Tree is a binary tree which each node has two attributes start and end denote an segment / interval.

start and end are both integers, they should be assigned in following rules:

The root's start and end is given by build method.
The left child of node A has start=A.left, end=(A.left + A.right) / 2.
The right child of node A has start=(A.left + A.right) / 2 + 1, end=A.right.
if start equals to end, there will be no children for this node.
Implement a build method with two parameters start and end, so that we can create a corresponding segment tree with every node has the correct start and end value, return the root of this segment tree.

Have you met this question in a real interview?  
Clarification
Segment Tree (a.k.a Interval Tree) is an advanced data structure which can support queries like:

which of these intervals contain a given point
which of these points are in a given interval
 */
public class SegmentTreeBuild {
    /*
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if(start > end) return null;
        SegmentTreeNode curr = new SegmentTreeNode(start, end);
        if(start == end) return curr;
        
        int left_end = (start + end) / 2;
        int right_start = left_end + 1;
        
        SegmentTreeNode left = build(start, left_end);
        SegmentTreeNode right = build(right_start , end);
        
        curr.left = left;
        curr.right = right;
        return curr;
    }
}

 class SegmentTreeNode {
	public int start, end;
	public SegmentTreeNode left, right;
	public SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.left = this.right = null;
	}
}
/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */