
public class InorderSuccessorinBinarySearchTree {

	public static void main(String[] arts) {
		
	}
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode successor = null;
        while(root != null && root.val != p.val) {
            if(root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if(root == null) return null;
        if(root.right != null) return successor;
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

}
