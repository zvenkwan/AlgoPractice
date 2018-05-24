/**
 * 
 * @author jguan
 *Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 */
public class MinimumSubtree {
	int subtreeSum = Integer.MAX_VALUE;
	TreeNode subtree = null;
	public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subtree;
    }
	
	private int helper(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int sum = helper(root.left) + helper(root.right) + root.val;
		if(subtreeSum >= sum) {
			subtree = root;
			subtreeSum = sum;
		}
		return sum;
	}
}
