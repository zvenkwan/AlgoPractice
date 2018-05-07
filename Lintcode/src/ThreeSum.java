import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author jguan
 *57. 3Sum
Description
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.

Have you met this question in a real interview?  
Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)
(-1, -1, 2)
 */
public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> results =  new ArrayList<>();
        if(numbers == null || numbers.length < 3) return results;
        
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 2; i ++) {
            int target = -numbers[i];
            if(i == 0 || (i > 0 && numbers[i] != numbers[i-1]))
                twoSum(i+1, numbers, target, results );
            else continue;
        }
        return results;
    }
    
    private void twoSum(int start, int[] numbers, int target, List<List<Integer>> results) {
        int i = start;
        int j = numbers.length - 1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) {
                List<Integer> result = new ArrayList<>();
                result.add(-target);
                result.add(numbers[i]);
                result.add(numbers[j]);
                results.add(result);
                i++;
                j--;
                while(i < j && numbers[i] == numbers[i-1]) {
                    i++;
                } 
                while(i < j && numbers[j] == numbers[j+1]) {
                    j--;
                }
            } else if(sum > target) {
                j--;
            } else {
                i++;
            }
        }
    }
}
