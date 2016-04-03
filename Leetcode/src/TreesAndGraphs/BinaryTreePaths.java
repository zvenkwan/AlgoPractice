package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;
/**
 * 257. Binary Tree Paths
 * @author zg55
 *Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root==null)
            return result;
        binaryTreePaths(root, "", result);
        return result;
    }
    
    public void binaryTreePaths(TreeNode root, String prefix, List<String> result) {
        if(root.left==null&&root.right==null)
            result.add(prefix+root.val);
        if(root.left!=null)
            binaryTreePaths(root.left, prefix+root.val+"->", result);
        if(root.right!=null)
            binaryTreePaths(root.right, prefix+root.val+"->", result);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
