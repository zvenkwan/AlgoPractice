/**
 * 
 * @author jguan
 *
 *41. Maximum Subarray
Description
Given an array of integers, find a contiguous subarray which has the largest sum.

The subarray should contain at least one number.

Have you met this question in a real interview?  
Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

Challenge
Can you do it in time complexity O(n)?
 */
public class MaximumSubarray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        // do prefix sum, then find max subarry
        if(nums == null || nums.length == 0) return 0;
        int[] prefix = new int[nums.length + 1];
        for(int i = 1 ; i < prefix.length; i++) {
            prefix[i] = nums[i-1] + prefix[i-1];
        }
        // System.out.println(Arrays.toString(prefix));
        int maxSum = prefix[prefix.length - 1];
        int max = prefix[prefix.length - 1];
        for(int i = prefix.length - 1; i >= 1; i --) {
            max = Math.max(max, prefix[i]);
            int sum = max - prefix[i-1];
            maxSum = Math.max(maxSum, sum);
        // System.out.println(max + "   "+ maxSum);
        }
        return maxSum;
    }
}
