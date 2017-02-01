
public class LowestCommonAncestorIII {
	public static void main(String args[]) {
		Integer[] a = new Integer[]{1,2,3,4,5,6,4};
		TreeNode root = TreeNode.buildTree(a);
		LowestCommonAncestorIII lca = new LowestCommonAncestorIII();
		TreeNode rr = lca.lowestCommonAncestor3(root, root, root.left);
		System.out.println(rr.val);
	}
	
    TreeNode res = null;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(A == B) return A;
        helper(root, A, B);
        return res;
    }
    
    private int helper(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null) return 0;
        int found = 0;
        // if found one of two nodes on root, look for the other on children trees
        if(root == A) found = 1;
        else if(root == B) found = 3;
        
        int left = helper(root.left, A, B);
        int right = helper(root.right, A, B);
        System.out.println("left="+left+",           right="+right);
        if(found + left + right == 4) res = res == null? root: res;
        return found + left + right;
    }
}
