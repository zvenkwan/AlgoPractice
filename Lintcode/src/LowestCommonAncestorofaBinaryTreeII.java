import java.util.LinkedList;

/**
 * 
 * @author jguan
 * 474. Lowest Common Ancestor II
 *Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

The node has an extra attribute parent which point to the father of itself. The root's parent is null.
 */
public class LowestCommonAncestorofaBinaryTreeII {

	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
            ParentTreeNode A,
            ParentTreeNode B) {

		LinkedList<ParentTreeNode> pathA = getPathtoRoot(A);
		LinkedList<ParentTreeNode> pathB = getPathtoRoot(B);
		ParentTreeNode res = null;
		while(!pathA.isEmpty()&&!pathA.isEmpty()) {
			ParentTreeNode a = pathA.pop();
			ParentTreeNode b = pathB.pop();
			if(a == b) {
				res = a;
			} else {
				break;
			}
		}
		return res;
	}
	
	public LinkedList<ParentTreeNode> getPathtoRoot(ParentTreeNode node) {
		LinkedList<ParentTreeNode> path = new LinkedList<ParentTreeNode>();
		while(node != null) {
			node = node.parent;
			path.push(node);
		}
		return path;
	}
	
}

class ParentTreeNode {
	public ParentTreeNode parent, left, right;
}