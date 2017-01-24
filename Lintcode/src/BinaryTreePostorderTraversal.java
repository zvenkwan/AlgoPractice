import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreePostorderTraversal {
	
	public static void main(String[] args) {
//		Integer[] vals = new Integer[]{1,2,3,4,5,6,7};
		Integer[] vals = new Integer[]{1,2,null, null, 3};
		TreeNode root = TreeNode.buildTree(vals);
		BinaryTreePostorderTraversal post = new BinaryTreePostorderTraversal();
		System.out.println(post.postorderTraversal2(root));
	}
	
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        TreeNode crt = root;
        // nodes.push(crt);
        
        
        // while(nodes.size() != 0) {
        while( list.size()==0 || nodes.size()!=0) {
        // start from root, if not null push right child to stack and then push root
        // move pointer to left child
            if(crt != null) {
                if(crt.right != null) {
                    // if(nodes.peek() == crt)
                    //     nodes.pop();
                    nodes.push(crt.right);
                }
                nodes.push(crt);
                crt = crt.left;
            }
            else {
                // if the left child of previous node is null
                // return to the previous node which is obtained from stack
                crt = nodes.pop();
                // which means this is a leaf
                if(crt.right == null) {
                    list.add(crt.val);
                    crt = null;
                }
                // the node has right child and it has been stored in the stack
                // waiting for processing, so process this node
                 else if(crt.right == nodes.peek()) {
                    TreeNode right = nodes.pop();
                    // push back root
                    nodes.push(crt);
                    // move pointer to right
                    crt = right;
                }
                // if not equal, right child has been processed
                else {
                    list.add(crt.val);
                    crt = null;
                }
            }
        }
        
        return list;
    }
//	recursive
	public ArrayList<Integer> postorderTraversal2(TreeNode root) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    if (root == null) {
	        return result;
	    }
	    result.addAll(postorderTraversal(root.left));
	    result.addAll(postorderTraversal(root.right));
	    result.add(root.val);
	    return result;   
    }
}
