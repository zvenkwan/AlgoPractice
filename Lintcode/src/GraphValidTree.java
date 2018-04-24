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
 *178. Graph Valid Tree 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 Notice
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Have you met this question in a real interview? 
Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        // write your code here
        // valid tree, can be travesed from one to all, n nodes should have n - 1 edges
        if(edges == null) return false;
        if(n <= 0) return false;
        if(n - 1 != edges.length) return false;
        // build graph and bfs
        Map<Integer, UndirectedNode> map = new HashMap<>();
        for(int i = 0; i < n; i ++) {
            map.put(i, new UndirectedNode(i));
        }
        for(int[] edge: edges) {
            map.get(edge[0]).neighbors.add(map.get(edge[1]));
            map.get(edge[1]).neighbors.add(map.get(edge[0]));
        }
        Set<Integer> visited = new HashSet<>();
        Queue<UndirectedNode> queue = new LinkedList<>();
        queue.offer(map.get(0));
        visited.add(0);
        while(!queue.isEmpty()) {
            UndirectedNode curr = queue.poll();
            for(UndirectedNode next: curr.neighbors) {
                if(!visited.contains(next.val)) {
                    queue.offer(map.get(next.val));
                    visited.add(next.val);
                }
            }
        }
        return visited.size() == n;
    }
}

class UndirectedNode {
    int val;
    ArrayList<UndirectedNode> neighbors;
    public UndirectedNode(int val) {
        this.val = val;
        neighbors = new ArrayList<UndirectedNode>();
    }
}
