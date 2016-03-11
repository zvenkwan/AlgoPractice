package TreesAndGraphs;
import java.util.ArrayList;
import java.util.List;
/**
 * 107. Binary Tree Level Order Traversal II
 * @author zg55
 *Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
   return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(root==null)
        	return l;
        List<TreeNode> ln = new ArrayList<TreeNode>();
        ln.add(root);
        getLevelValues(l, ln);
        return l;
    }
	
	public void getLevelValues(List<List<Integer>> l, List<TreeNode> ln) {
		if(ln.size()==0)
			return;
		List<TreeNode> ltn = new ArrayList<TreeNode>();
		List<Integer> lv = new ArrayList<Integer>();
		for(TreeNode i:ln) {
			lv.add(i.val);
			if(i.left!=null) {
				ltn.add(i.left);
			}
			if(i.right!=null) {
				ltn.add(i.right);
			}
		}
		if(lv.size()!=0) {
			l.add(0,lv);
			getLevelValues(l, ltn);
		}
		return;
	}
	
//	public List<TreeNode> getNextLevelNodes(List<TreeNode> ln) {
//		List<TreeNode> ltn = new ArrayList<TreeNode>();
//		List<Integer> lv = new ArrayList<Integer>();
//		for(TreeNode i:ln) {
//			if(i.left!=null) {
//				ltn.add(i.left);
//				lv.add(i.left.val);
//			}
//			if(i.right!=null) {
//				ltn.add(i.right);
//				lv.add(i.right.val);
//			}
//		}
//		if(lv.size()!=0)
//			this.l.add(0,lv);
//		return ltn;
//	}
	
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
		System.out.println(new BinaryTreeLevelOrderTraversalII().levelOrderBottom(tn1));
	}

}
