/**
 * 175. Invert Binary Tree
Description
Invert a binary tree.

Have you met this question in a real interview?  
Example
  1         1
 / \       / \
2   3  => 3   2
   /       \
  4         4
Challenge
Do it in recursion is acceptable, can you do it without recursion?
 */

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class InvertBinaryTree {

    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root == null) return;
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if(root == null) return root;
        
        TreeNode left = helper(root.right);
        TreeNode right = helper(root.left);
        root.left = left;
        root.right = right;
        
        return root;
    }
}
