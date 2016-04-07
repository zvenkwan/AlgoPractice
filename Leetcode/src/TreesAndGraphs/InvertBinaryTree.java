package TreesAndGraphs;
/**
 * 226. Invert Binary Tree
 * @author zg55
 *Invert a binary tree.
 *     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
        if(root==null) 
        	return root;
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer t[]={4,2,7,1,3,null,9};
		TreeNode root= TreeNode.buildTree(t);
		System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
		System.out.println(new InvertBinaryTree().invertTree(root));
		System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
	}

}
