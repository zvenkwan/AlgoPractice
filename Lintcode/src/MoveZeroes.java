/**
 * 
 * @author jguan
 *539. Move Zeroes
Description
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Have you met this question in a real interview?  
Example
Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeroes {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return;
        int slow = 0;
        int fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != 0) {
                int t = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = t;
                slow ++;
            }
            fast++;
        }
    }
}
