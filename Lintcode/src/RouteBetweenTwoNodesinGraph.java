/*
 * 176
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class RouteBetweenTwoNodesinGraph {
    /*
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if(graph == null || s == null || t == null) return false;
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        Set<Integer> set = new HashSet<Integer>();
        queue.offer(s);
        set.add(s.label);
        while(!queue.isEmpty()) {
            DirectedGraphNode curr = queue.poll();
            if(curr.label == t.label) return true;
            for(DirectedGraphNode next: curr.neighbors) {
                if(!set.contains(next.label)) {
                    queue.offer(next);
                    set.add(next.label);
                }
            }
        }
        return false;
    }
}
