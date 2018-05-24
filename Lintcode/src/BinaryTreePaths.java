import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author zg55
 *480. Binary Tree Paths 
Description
Given a binary tree, return all root-to-leaf paths.

Have you met this question in a real interview?  
Example
Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]

 */
public class BinaryTreePaths {
	/**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) {
            paths.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            paths.add(root.val + "->" + path);
        }
        
        // root is a leaf
        if (paths.size() == 0) {
            paths.add("" + root.val);
        }
        
        return paths;
    }
}
