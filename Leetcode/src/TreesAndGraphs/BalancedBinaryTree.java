package TreesAndGraphs;
/**
 * 110. Balanced Binary Tree
 * @author zg55
 *Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
	boolean isBal = true;
	public boolean isBalanced(TreeNode root) {
        if(root==null)
        	return true;
        getHeight(root);
        return isBal;
	}
	
	public int getHeight(TreeNode tn) {
		if(tn==null)
			return -1;
		int l = getHeight(tn.left);
		int r = getHeight(tn.right);
		if(Math.abs(l-r)>1)
			isBal=false;
		return Math.max(l, r)+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tn1 = new TreeNode(3);
		TreeNode tn2 = new TreeNode(9);
		TreeNode tn3 = new TreeNode(20);
		TreeNode tn4 = new TreeNode(15);
		TreeNode tn5 = new TreeNode(7);
		TreeNode tn6 = new TreeNode(6);
		tn1.left=tn2;
		tn1.right=tn3;
		tn3.left=tn4;
		tn3.right=tn5;
		tn5.right=tn6;
		System.out.println(new BalancedBinaryTree().getHeight(tn3));
	}

}
