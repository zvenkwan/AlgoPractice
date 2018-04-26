/**
 * 
 * @author jguan
 *14. First Position of Target 
 Description
 Notes
 Testcase
 Judge
Discuss 
For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Have you met this question in a real interview? 
Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 */
public class FirstPositionofTarget {

    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length-1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target) {
                end = mid;
            } else { 
                start = mid;
            }
        }
        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }
}
