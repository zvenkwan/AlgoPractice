package TreesAndGraphs;
/**
 * 111. Minimum Depth of Binary Tree
 * @author zg55
 *Given a binary tree, find its minimum depth.
 *The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthofBinaryTree {
	
	public int minDepth(TreeNode root) {
		if(root==null)
			return 0;
//		if one of the children is missing, go to the existing one, so the max value is return instead of 0
		if(root.left==null^root.right==null)
			return Math.max(minDepth(root.left), minDepth(root.right))+1;
//		if both children are there, check both and get the min
		else 
			return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tn1 = new TreeNode(3);
		TreeNode tn2 = new TreeNode(9);
		TreeNode tn3 = new TreeNode(20);
		TreeNode tn4 = new TreeNode(15);
		TreeNode tn5 = new TreeNode(7);
		tn1.left=tn2;
		tn1.right=tn3;
		tn3.left=tn4;
		tn3.right=tn5;
		System.out.println(new MinimumDepthofBinaryTree().minDepth(tn1));
	}

}
