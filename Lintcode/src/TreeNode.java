import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	
	
//	TreeNode(Integer x) { if(x!=null) val = x.intValue(); }
	public static TreeNode buildTree(Integer[] treeNodes) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(Integer i:treeNodes ) 
			l.add(i);
		LinkedList<TreeNode> next= new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(l.poll().intValue());
		next.add(root);
		while(next.size()!=0&&l.size()!=0) {
			TreeNode left = null;
			if(l.peek()!=null&&next.peek()!=null)
				left = new TreeNode(l.peek().intValue());
			next.peek().left = left;
			l.poll();
			next.add(left);
			
			TreeNode right = null;
			if(l.peek()!=null&&next.peek()!=null)
				right = new TreeNode(l.peek().intValue());
			next.poll().right = right;
			l.poll();
			next.add(right);
		}
		return root;
	}
	
	public static void print(TreeNode root) {
		if(root == null) {
			System.out.println("Empty Tree");
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		queue.addFirst(root);
		while(queue.size() != 0) {
			TreeNode current = queue.removeFirst();
			if(current == null) list.add(null);
			else {
				list.add(current.val);
				queue.add(current.left);
				queue.add(current.right);
			}
		}
		while(list.get(list.size()-1) == null) list.remove(list.size()-1);
		System.out.println(list);
	}
	
	
	public static void main(String[] args) {
		Integer tree[] = {3,9,20,null,null,15,7};
		TreeNode.buildTree(tree);
	}
}
