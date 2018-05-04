/**
 * 
 * @author jguan
 *608. Two Sum II - Input array is sorted
Description
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Have you met this question in a real interview?  
Example
Given nums = [2, 7, 11, 15], target = 9
return [1, 2]
 */
public class TwoSumII {
    /**
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length <2) return new int[]{-1,-1};
        int l =0;
        int r = nums.length -1;
        while(l < r) {
            if(nums[l] + nums[r] == target) {
                return new int[]{l+1, r+1};
            } else if(nums[l] + nums[r] > target) {
                r--;
            } else l++;
        }
        return new int[]{-1,-1};
    }
}
