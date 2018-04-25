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
 *615. Course Schedule 
 Description
 Notes
 Testcase
 Judge
Discuss 
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Have you met this question in a real interview? 
Example
Given n = 2, prerequisites = [[1,0]]
Return true

Given n = 2, prerequisites = [[1,0],[0,1]]
Return false
 */
public class CourseSchedule {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        if(prerequisites == null || prerequisites.length == 0) return true;
        Map<Integer, DirectedNode> map = new HashMap<Integer, DirectedNode>();
        for(int i = 0 ; i < numCourses; i ++) {
            map.put(i, new DirectedNode(i));
        }
        
        // build graph
        Map<DirectedNode, Integer> indegree = new HashMap<>();
        for(int[] edge: prerequisites) {
            // [1] --> [0]
            map.get(edge[1]).neighbors.add(map.get(edge[0]));
            DirectedNode next = map.get(edge[0]);
            indegree.put(next, indegree.getOrDefault(next, 0) + 1);
        }
        
        Queue<DirectedNode> queue = new LinkedList<>();
        Set<DirectedNode> visited = new HashSet<>();
        for(int i = 0 ; i < numCourses; i ++) {
            if(indegree.getOrDefault(map.get(i), 0) == 0) {
                queue.offer(map.get(i));
                visited.add(map.get(i));
            }
        }
        
        if(queue.isEmpty()) return false;
        while(!queue.isEmpty()) {
            DirectedNode curr = queue.poll();
            for(DirectedNode next: curr.neighbors) {
                if(!visited.contains(next)) {
                        
                    indegree.put(next, indegree.get(next) - 1);
                    if(indegree.get(next) == 0) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        
        return visited.size() == numCourses;
    }
    
}

class DirectedNode {
    int val;
    ArrayList<DirectedNode> neighbors;
    public DirectedNode(int val) {
        this.val = val;
        neighbors = new ArrayList<DirectedNode>();
    }
}