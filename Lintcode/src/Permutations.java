import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author jguan
 *15. Permutations
Description
Given a list of numbers, return all possible permutations.

You can assume that there is no duplicate numbers in the list.

Have you met this question in a real interview?  
Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge
Do it without recursion.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
        	results.add(new ArrayList<Integer>());
        	return results;
        }
        dfsHelper(nums, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void dfsHelper (int[] nums, ArrayList<Integer> subset, List<List<Integer>> results) {
    	if(subset.size() == nums.length) {
    		results.add(new ArrayList<Integer>(subset));
    		return;
    	}
        for(int i=0;i<nums.length; i++) {
        	if(!subset.contains(nums[i])) {
        		subset.add(nums[i]);
        		dfsHelper(nums, subset, results);
        		subset.remove(subset.size()-1);
        	}
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3};
		Permutations p = new Permutations();
		System.out.println(p.permute(nums));
	}

}
