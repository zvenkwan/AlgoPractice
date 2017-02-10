import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
}
