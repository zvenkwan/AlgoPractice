
public class MinimuSubtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] tree = new Integer[]{1,-1,2,1,2,-4,-5};
		TreeNode root = TreeNode.buildTree(tree);
		MinimuSubtree tn = new MinimuSubtree();
		
		TreeNode.print(tn.findSubtree(root));
		
	}
	private int min = Integer.MAX_VALUE;
	private TreeNode minNode = null;
	
	public TreeNode findSubtree(TreeNode root) {
		helper(root);
		return minNode;
	}
	
	private int helper(TreeNode root) {
		if(root == null) return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		int sum = left + right + root.val;
		if(sum < min) {
			min = sum;
			minNode = root;
		}
		return sum;
	}
	
	
}
