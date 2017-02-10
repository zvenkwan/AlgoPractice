import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int numCourses = 2;
//		int[][] pre = {{0,1},{1,0}};
//		int numCourses = 4;
//		int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
//		int numCourses = 4;
//		int[][] pre = {{1,0},{2,0},{3,1},{2,0}};
		int numCourses = 10;
		int[][] pre = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		CourseScheduleII cs = new CourseScheduleII();
		int[] rs = cs.findOrder(numCourses, pre);
		System.out.println(Arrays.toString(rs));
	}
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        if(numCourses <= 0) return new int[0];
        if(prerequisites == null || prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; i ++) {
                res[i]=i;
            }
        }
        
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = initializeGraph(numCourses, prerequisites, indegree);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int key: indegree.keySet()) {
            if(!set.contains(key) && indegree.get(key)==0) {
                queue.offer(key);
                set.add(key);
                res.add(key);
            }
        }

        while(!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> neighbors = graph.get(node);
            for(int nbr:neighbors) {
            	indegree.put(nbr, indegree.get(nbr)-1);
                if(!set.contains(nbr) && indegree.get(nbr) == 0) {
                    queue.offer(nbr);
                    set.add(nbr);
                    res.add(nbr);
                }
            }
        }
        
        if(res.size() == numCourses) {
        	int[] courses = new int[res.size()];
        	for(int i = 0; i < res.size(); i++) {
        		courses[i] = res.get(i);
        	}
        	return courses;
        }
        return new int[0];
    }
    
    private Map<Integer, List<Integer>> initializeGraph(int numCourses, int[][] prerequisites, Map<Integer, Integer> indegree) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i ++) {
            graph.put(i, new ArrayList<Integer>());
            indegree.put(i, 0);
        }
     // there might be duplicates input
//        Set<Integer> set = new HashSet<>();
        for(int[] pre:prerequisites) {
//        	if(!graph.get(pre[0]).contains(pre[1])) {
        		graph.get(pre[0]).add(pre[1]);
        		graph.get(pre[1]).add(pre[0]);
        		indegree.put(pre[0], indegree.get(pre[0])+1);
        }
        
        return graph;
    }
}
