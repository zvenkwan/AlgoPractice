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
		List<List<TreeNode>> lt = new ArrayList<List<TreeNode>>();
        List<TreeNode> ln = new ArrayList<TreeNode>();
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(root==null)
        	return l;
        ln.add(root);
        lt.add(ln);
        while(ln.size()!=0) {
        	List<TreeNode> lv = getNextLevelValues(ln);
        	if(lv.size()!=0)
        		lt.add(lv);
        	ln=lv;
        }
        for(int i =lt.size()-1; i>=0; i--) {
        	List<TreeNode> ltn = lt.get(i);
        	List<Integer> ltv = new ArrayList<Integer>();
        	for(TreeNode j:ltn) {
        		ltv.add(j.val);
        	}
        	l.add(ltv);
        }
        return l;
    }
	
	public List<TreeNode> getNextLevelValues(List<TreeNode> ln) {
		List<TreeNode> l = new ArrayList<TreeNode>();
		for(TreeNode i:ln) {
			if(i.left!=null) {
				l.add(i.left);
			}
			if(i.right!=null) {
				l.add(i.right);
			}
		}
		System.out.println("there are "+l.size());
		return l;
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
		System.out.println(new BinaryTreeLevelOrderTraversalII().levelOrderBottom(null));
	}

}
