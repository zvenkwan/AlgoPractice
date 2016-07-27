package TreesAndGraphs;
/**
 * 366. Find Leaves of Binary Tree
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

Hide Company Tags LinkedIn
Hide Tags Tree Depth-first Search

 */
import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getDepth(res, root);
        return res;
    }
    
    private int getDepth(List<List<Integer>> list, TreeNode node) {
        if(node == null) return -1;
        int h = Math.max(getDepth(list, node.left), getDepth(list,node.right)) + 1;
        if(h==list.size())
            list.add(new ArrayList<Integer>());
        list.get(h).add(node.val);
        return h;
    }
}
