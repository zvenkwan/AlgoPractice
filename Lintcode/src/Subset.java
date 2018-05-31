import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author jguan
 *17. Subsets
Description
Given a set of distinct integers, return all possible subsets.

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview?  
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Challenge
Can you do it in both recursively and iteratively?
 */
public class Subset {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
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
            list.add(nums[i]);
            helper(nums, i+1, list, results);
            list.remove(list.size()-1);
        }
    }
}
