import java.util.LinkedList;

public class BinaryTreeSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = TreeNode.buildTree(new Integer[]{1,2,null,3,null,4});
		BinaryTreeSerialization bts = new BinaryTreeSerialization();
		String data = bts.serialize(root);
		System.out.println(data);
		bts.deserialize(data);
	}
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null) return "{}";
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder res = new StringBuilder("{");
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null)
                res.append("#,");
            else {
            	res.append(node.val+",");
	            queue.add(node.left);
	            queue.add(node.right);
            }
        }
        res.deleteCharAt(res.length()-1);
        while(res.charAt(res.length()-1) == '#') {
            res.deleteCharAt(res.length()-1);
            res.deleteCharAt(res.length()-1);
        }
        res.append("}");
        return res.toString();
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
        if(data == null || data.length()<=2) return null;
        data = data.substring(1,data.length()-1);
        if(data.length() == 0) return null;
        String[] s_arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(s_arr[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i = 1; i < s_arr.length; ) {
            TreeNode node = queue.poll();
            if(node == null) continue;
            if("#".equals(s_arr[i])) node.left = null;
            else node.left = new TreeNode(Integer.parseInt(s_arr[i]));
            i++;
            queue.add(node.left);
            if("#".equals(s_arr[i])) node.right = null;
            else node.right = new TreeNode(Integer.parseInt(s_arr[i]));
            i++;
            queue.add(node.right);
        }
        return root;
    }
}