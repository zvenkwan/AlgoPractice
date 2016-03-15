package TreesAndGraphs;
/**
 * 298. Binary Tree Longest Consecutive Sequence
 * @author zg55
 *	Given a binary tree, find the length of the longest consecutive sequence path.
 *	The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from 
 *	parent to child (cannot be the reverse).
 *	For example,
 *	  1
    \
     3
    / \
   2   4
        \
         5
         Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
 	Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence {
	public int longestConsecutive(TreeNode root) {
	    return dfs(root, null, 0);
	}

	private int dfs(TreeNode p, TreeNode parent, int length) {
		if(p==null) return length;
		if(parent!=null&&p.val == parent.val+1) {
			length +=1;
		} else
			length = 1;
		return Math.max(length, Math.max(dfs(p.left, p, length),
                dfs(p.right, p, length)));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		[1,null,3,2,4,null,null,null,5]
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn5 = new TreeNode(5);
		tn1.right = tn3;
		tn3.left = tn2;
		tn3.right = tn4;
		tn4.right = tn5;
		System.out.println(new BinaryTreeLongestConsecutiveSequence().longestConsecutive(tn1));
	}

}

