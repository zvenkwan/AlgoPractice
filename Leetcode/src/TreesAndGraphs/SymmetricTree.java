package TreesAndGraphs;
/**
 * 101. Symmetric Tree
 * @author zg55
 *Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        else 
            return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null&&right==null)
            return true;
        return(left!=null&&right!=null&&left.val==right.val&&isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
