package TreesAndGraphs;
/**
 * 270. Closest Binary Search Tree Value
 * @author zg55
 *Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if(root.left==null&&root.right==null)
            return root.val;
        TreeNode child = target<root.val?root.left:root.right;
        if(child==null)
            return root.val;
        int closeChild = closestValue(child, target);
        return Math.abs(closeChild-target)<Math.abs(root.val-target)?closeChild:root.val;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
