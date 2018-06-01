import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author jguan
 *16. Permutations II
Description
Given a list of numbers with duplicate number in it. Find all unique permutations.

Have you met this question in a real interview?  
Example
For numbers [1,2,2] the unique permutations are:

[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
Challenge
Using recursion to do it is acceptable. If you can do it without recursion, that would be great!
 */
public class PermutationsII {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;
        List<Integer> permute = new ArrayList<Integer>();
        if(nums.length == 0) {
            results.add(permute);
            return results;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums, permute, results, visited);
        return results;
    }
    
    private void helper(int[] nums, List<Integer> permute, List<List<Integer>> results, boolean[] visited) {
        if(nums.length == permute.size()) {
            results.add(new ArrayList<Integer>(permute));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }    
            permute.add(nums[i]);
            visited[i] = true;
            helper(nums, permute, results, visited);
            permute.remove(permute.size() -1);
            visited[i] = false;
        }
    }
}
