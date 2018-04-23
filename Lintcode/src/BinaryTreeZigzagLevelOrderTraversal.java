import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author jguan
71. Binary Tree Zigzag Level Order Traversal 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Have you met this question in a real interview? 
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean rev = true;
        while(!queue.isEmpty()) {
            rev = !rev;
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0 ; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            if(rev) Collections.reverse(level);
            result.add(level);
        }
        return result;
    }
}
