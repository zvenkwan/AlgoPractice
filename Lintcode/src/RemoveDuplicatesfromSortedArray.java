/**
 * 
 * @author jguan
 *100. Remove Duplicates from Sorted Array
Description
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Have you met this question in a real interview?  
Example
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesfromSortedArray {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int size = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[size]) {
                size++;
                nums[size] = nums[i];
            }
        }
        return size + 1;
    }


}
