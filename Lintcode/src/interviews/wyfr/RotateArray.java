package interviews.wyfr;
/**
 * 
 * @author jguan
 *
1334. Rotate Array
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example
Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Challenge
1.Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
2.Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    /**
     * @param nums: an array
     * @param k: an integer
     * @return: rotate the array to the right by k steps
     */
    public int[] rotate(int[] nums, int k) {
        // Write your code here
        if(nums == null || nums.length < 2) return nums;
        
        k = k%nums.length;
        
        // method 1: create another array, put elements in it 
        // method 2: do it in place, swap in the array
        // method 3: reverse 
        
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length -k, nums.length -1);
        reverse(nums, 0, nums.length - 1);
        
        return nums;
        
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            // swap without temp
            nums[start] = nums[end] + nums[start];
            nums[end] = nums[start] - nums[end];
            nums[start] = nums[start] - nums[end];
            start++;
            end--;
        }
    }

	
}
