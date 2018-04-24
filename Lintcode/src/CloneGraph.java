import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * 
 * @author jguan
 *137. Clone Graph 
 Description
 Notes
 Testcase
 Judge
Discuss 
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

How we serialize an undirected graph:

Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node);
        map.put(node.label, new UndirectedGraphNode(node.label));
        while(!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            for(UndirectedGraphNode nbr: curr.neighbors) {
                if(!visited.contains(nbr)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(nbr.label);
                    map.put(copy.label, copy);
                    visited.add(nbr);
                    queue.offer(nbr);
                }
            }
        }
        queue.clear();
        visited.clear();
        queue.offer(node);
        visited.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            for(UndirectedGraphNode nbr: curr.neighbors) {
                map.get(curr.label).neighbors.add(map.get(nbr.label));
                if(!visited.contains(nbr)) {
                    visited.add(nbr);
                    queue.offer(nbr);
                }
            }
        }
        return map.get(node.label);
    }
}

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
