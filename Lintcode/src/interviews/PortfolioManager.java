package interviews;

import java.util.LinkedList;
/**
 * 
 * @author zg55
 *find max sum in a binary tree with any node
 *connected nodes can not both selected
 */
public class PortfolioManager {

	public static void main(String[] args) {
		int n = 9;
		String tree = "3 4 5 1 3 # 1000 9 10 100";
		long res = findMax(n, tree);
		System.out.println(res);
	}
	
	static long findMax(int n, String tree) {
        if(n == 0 || tree == null || tree.length() == 0)
            return 0;
        
        String[] nodes = tree.split(" ");
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode nd = queue.poll();
            if(i == nodes.length) break;
            String lval = nodes[i++];
            
            TreeNode left = null;
            TreeNode right = null;
            if(!"#".equals(lval)) {
                left = new TreeNode(Integer.parseInt(lval));
                queue.offer(left);
            }
            nd.left = left;
            

            if(i == nodes.length) break;
            String rval = nodes[i++];
            if(!"#".equals(rval)) {
                right = new TreeNode(Integer.parseInt(rval));
                queue.offer(right);
            }
            nd.right = right;
        }
        
        
        long choose = findMax(true, root);
        long skip = findMax(false, root);
        
        return Math.max(choose,skip);
        
    }

    static long findMax(boolean isChosen, TreeNode node) {
        if(node == null) return 0;
        if(isChosen) {
            long left = findMax(false, node.left);
            long right = findMax(false, node.right);
            return node.val + left + right;
        }
        else {
            long chooseLeft = findMax(true, node.left);
            long chooseRight = findMax(true, node.right);
            long skipLeft = findMax(false, node.left);
            long skipRight = findMax(false, node.right);
            long left = chooseLeft;
            long right = chooseRight;
            long left_and_right = chooseLeft + chooseRight;
            if(left > right && left > left_and_right) return left;
            else if(right > left && right > left_and_right) return right;
            else return left_and_right;
        }
    }


    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        boolean isChosen;
        public TreeNode(int val) {
            this.val = val;
            this.isChosen = false;
        }
        public String toString() {
        	return val+"";
        }
    }
}
