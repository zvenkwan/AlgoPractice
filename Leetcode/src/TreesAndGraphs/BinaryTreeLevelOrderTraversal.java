package TreesAndGraphs;
import java.util.ArrayList;
import java.util.List;
/**
 * 102. Binary Tree Level Order Traversal
 * @author zg55
 *Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */
public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		if(root==null)
			return l;
        List<TreeNode> ltn = new ArrayList<TreeNode>();
        ltn.add(root);
        getLevelValues(l, ltn);
        return l;
    }
	
	public void getLevelValues(List<List<Integer>> l, List<TreeNode> ltn) {
		if(ltn.size()==0)
			return;
		List<Integer> lv = new ArrayList<Integer>();
		List<TreeNode> lnextn = new ArrayList<TreeNode>();
		for(TreeNode i:ltn) {
			lv.add(i.val);
			if(i.left!=null)
				lnextn.add(i.left);
			if(i.right!=null)
				lnextn.add(i.right);
		}
		if(lv.size()!=0) {
			l.add(lv);
			getLevelValues(l,lnextn);
		}
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
		System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(tn1));
	}

}
