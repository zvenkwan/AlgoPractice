import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author jguan
 *7. Serialize and Deserialize Binary Tree 
 Description
 Notes
 Testcase
 Judge
Discuss 
Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

 Notice
There is no limit of how you deserialize or serialize a binary tree, LintCode will take your output of serialize as the input of deserialize, it won't check the result of serialize.

Have you met this question in a real interview? 
Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.
 */
public class SerializeandDeserializeBinaryTree {
	/**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null) return "#";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null) sb.append("#");
            else {
                sb.append(curr.val);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data == null) return null;
        data = data.trim();
        String[] nodes = data.split("\\s+");
        if(nodes[0].equals("#")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        for(int i = 1; i < nodes.length; i++) {
            TreeNode node = queue.poll();
            if(nodes[i].equals("#")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(node.left);
            }
            i++;
            if(nodes[i].equals("#")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(node.right);
            }
        }
        return root;
    }
}
