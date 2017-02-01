import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.buildTree(new Integer[]{1,2,8,5,4,-1});
		int target = 8;
		
		System.out.println(new BinaryTreePathSum().binaryTreePathSum(root, target));
	}
	
//	divide and conquer
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) return results;
        if(root.left == null && root.right == null) {
        	List<Integer> result = null;
            if(target == root.val) {
            	result = new ArrayList<>();
            	result.add(root.val);
            	results.add(result);
            }
            return results;
        }
        List<List<Integer>> leftResults = binaryTreePathSum(root.left, target-root.val);
        List<List<Integer>> rightResults = binaryTreePathSum(root.right, target-root.val);
        for(List<Integer> p: leftResults) {
            p.add(0, root.val);
            results.add(p);
        }
        for(List<Integer> p: rightResults) {
            p.add(0, root.val);
            results.add(p);
        }
        return results;
    }
}
