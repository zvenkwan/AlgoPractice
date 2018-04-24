import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/**
 * 
 * @author jguan
 *127. Topological Sorting 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

 Notice
You can assume that there is at least one topological order in the graph.

Have you met this question in a real interview? 
Clarification
Learn more about representation of graphs

Example
For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
 */
public class TopologicalSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> indegreeMap = new HashMap<>();
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode nbr: node.neighbors) {
                indegreeMap.put(nbr, indegreeMap.getOrDefault(nbr, 0) + 1);
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node : graph) {
            if(indegreeMap.getOrDefault(node, 0) == 0) {
                queue.offer(node);
                res.add(node);
            }
        }
        while(!queue.isEmpty()) {
            DirectedGraphNode dNode = queue.poll();
            for(DirectedGraphNode nbr : dNode.neighbors) {
                indegreeMap.put(nbr, indegreeMap.get(nbr)-1);
                if( indegreeMap.get(nbr) == 0 ) {
                    queue.offer(nbr);
                    res.add(nbr);
                }
            }
        }
        return res;
    }
	
//    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
//        // write your code here
//        ArrayList<DirectedGraphNode> result = new ArrayList<>();
//        if(graph == null) return result;
//        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
//        for(DirectedGraphNode node: graph) {
//            for(DirectedGraphNode nbr: node.neighbors) {
//                updateIndegree(indegree, nbr);
//            }
//        }
//        // indegree.forEach((k,v)->System.out.println("Item : " + k.label + " Count : " + v));
//        Queue<DirectedGraphNode> queue = new LinkedList<>();
//        for(DirectedGraphNode node: graph) {
//            if(indegree.get(node) == null || indegree.get(node) == 0) {
//                queue.offer(node);
//                result.add(node);
//            }
//        }
//        
//        while(!queue.isEmpty()) {
//            DirectedGraphNode curr = queue.poll();
//            for(DirectedGraphNode nbr: curr.neighbors) {
//                indegree.put(nbr, indegree.get(nbr) - 1);
//                if(indegree.get(nbr) == 0) {
//                    queue.offer(nbr);
//                    result.add(nbr);
//                }
//            }
//        }
//        
//        return result;
//    }
    
    private void updateIndegree(Map<DirectedGraphNode, Integer> indegree, DirectedGraphNode node) {
        if(indegree.get(node) == null) {
            indegree.put(node, 1);
        } else {
            indegree.put(node, 1 + indegree.get(node));
        }
    }
}
