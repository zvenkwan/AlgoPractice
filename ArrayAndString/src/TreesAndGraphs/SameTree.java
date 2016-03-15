package TreesAndGraphs;
/**
 * 100. Same Tree
 * @author zg55
 *Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Show Company Tags
Show Tags

 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
        	return true;
        if(p!=null&&q!=null) 
        	return p.val==q.val&&isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer t1[] = {1, null, 1};
		Integer t2[] = {1, null, 1};
		TreeNode tn1 = TreeNode.buildTree(t1);
		TreeNode tn2 = TreeNode.buildTree(t2);
		System.out.println(new SameTree().isSameTree(tn1, tn2));
	}

}
