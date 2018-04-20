/**
 * 605. Sequence Reconstruction 
 Description
 Notes
 Testcase
 Judge
Discuss 
Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Have you met this question in a real interview? 
Example
Given org = [1,2,3], seqs = [[1,2],[1,3]]
Return false
Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.

Given org = [1,2,3], seqs = [[1,2]]
Return false
Explanation:
The reconstructed sequence can only be [1,2].

Given org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
Return true
Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].

Given org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
Return true
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SequenceReconstruction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] org = {1};
		int[][] seqs = {{1}};
		System.out.println(
		new SequenceReconstruction().sequenceReconstruction(org, seqs)
				);
	}

    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        //construct graph
        Map<Integer, DirectedGraphNode> map = new HashMap<Integer, DirectedGraphNode>();
        for(int[] seq: seqs) {
            if(seq == null || seq.length == 0) continue;
            DirectedGraphNode curr = getNode(map, seq[0]);
            for(int i = 1; i < seq.length; i++) {
                DirectedGraphNode next = getNode(map, seq[i]);
                curr.neighbors.add(next);
                curr = next;
            }
        }
        if(org.length != map.size()) return false;
        if(org.length == 0 && (seqs.length == 0 || seqs[0].length == 0)) return true;
        DirectedGraphNode prev = map.get(org[0]);
        if(prev == null) return false;
        for(int i = 1; i < org.length; i++) {
            DirectedGraphNode curr = map.get(org[i]);
            if(curr == null) return false;
            if(!prev.neighbors.contains(curr)) return false;
            prev = curr;
        }
        return true;
    }
    
    public DirectedGraphNode getNode(Map<Integer, DirectedGraphNode> map, int label) {
        DirectedGraphNode node = map.get(label);
        if(node == null) {
            node = new DirectedGraphNode(label);
            map.put(label, node);
        }
        return node;
    }
}

class DirectedGraphNode {
    int label;
    HashSet<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int label) {
        this.label = label;
        this.neighbors = new HashSet<DirectedGraphNode>();
    }
}