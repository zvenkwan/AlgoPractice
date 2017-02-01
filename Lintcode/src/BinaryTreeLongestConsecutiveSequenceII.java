/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        // Write your code here
        Result r = helper(root);
        return r.len;
    }
    
    private Result helper(TreeNode root) {
        if(root == null) return new Result(0,0,0);
        Result left = helper(root.left);
        Result right = helper(root.right);
        int down = 0;
        int up = 0;
        int len = 0;
        // check max down
        if(root.left != null && root.val - 1 == root.left.val) {
            down = left.max_down + 1;
        }
        if(root.right != null && root.val - 1 == root.right.val) {
            down = Math.max(right.max_down + 1, down);
        }
        // check max up
        if(root.left != null && root.val + 1 == root.left.val) {
            up = left.max_up + 1;
        }
        if(root.right != null && root.val + 1 == root.right.val) {
            up = Math.max(right.max_up + 1, up);
        }
        len = down + up + 1;
        len = Math.max(len, Math.max(left.len, right.len));
        return new Result(len, down, up);
    }
    
    
}

class Result {
    int len;
    int max_down; //max down value of child, root is no included
    int max_up; //max up value of child, root is no included
    public Result(int len, int max_down, int max_up) {
        this.len = len;
        this.max_down = max_down;
        this.max_up = max_up;
    }
}