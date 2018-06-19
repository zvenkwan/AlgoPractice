/**
 * 
 * @author zg55
 *247. Segment Tree Query II
Description
For an array, we can build a SegmentTree for it, each node stores an extra attribute count to denote the number of elements in the the array which value is between interval start and end. (The array may not fully filled by elements)

Design a query method with three parameters root, start and end, find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.

It is much easier to understand this problem if you finished Segment Tree Buildand Segment Tree Query first.

Have you met this question in a real interview?  
Example
For array [0, 2, 3], the corresponding value Segment Tree is:

                     [0, 3, count=3]
                     /             \
          [0,1,count=1]             [2,3,count=2]
          /         \               /            \
   [0,0,count=1] [1,1,count=0] [2,2,count=1], [3,3,count=1]
query(1, 1), return 0

query(1, 2), return 1

query(2, 3), return 2

query(0, 2), return 2
 */
public class SegmentTreeQueryII {

    /*
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if(root == null) return 0;
        if(start > end) return 0;
        // remember to check if the asking scope is bigger than the tree has
        if(start <= root.start && end >= root.end) return root.count;
        int mid = (root.start + root.end)/2;
        int leftsum = 0, rightsum = 0;
        // 左子区
        if(start <= mid) {
            if( mid < end) {
                leftsum =  query(root.left, start, mid);
            } else {
                leftsum = query(root.left, start, end);
            }
        }
        // 右子区
        if(mid < end) {
            if(start <= mid) {
                rightsum = query(root.right, mid+1, end);
            } else {
                rightsum = query(root.right, start, end);
            } 
        }
        return leftsum + rightsum;
    }
    private class SegmentTreeNode {
        public int start, end, count;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
}
