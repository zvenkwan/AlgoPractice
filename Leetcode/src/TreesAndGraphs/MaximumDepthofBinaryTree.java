package TreesAndGraphs;
/**
 * 104. Maximum Depth of Binary Tree
 * @author zg55
 *Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
        if(root==null)
        return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
