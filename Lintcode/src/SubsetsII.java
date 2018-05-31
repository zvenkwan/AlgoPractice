import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author jguan
 *18. Subsets II
Description
Given a list of numbers that may has duplicate numbers, return all possible subsets

Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview?  
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Challenge
Can you do it in both recursively and iteratively?
 */
public class SubsetsII {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if(nums == null) return results;
        if(nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void helper(int[] nums, int start, ArrayList<Integer> list, List<List<Integer>> results) {
        results.add(new ArrayList<Integer>(list));
        
        for(int i = start; i < nums.length; i++) {
            if(i!=start && nums[i] == nums[i-1]) continue;
            
            list.add(nums[i]);
            helper(nums, i+1, list, results);
            list.remove(list.size()-1);
        }
    }
}
