/**
 * 
 * @author jguan
 *
 *159. Find Minimum in Rotated Sorted Array 
 Description
 Notes
 Testcase
 Judge
Discuss 
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

 Notice
You may assume no duplicate exists in the array.

Have you met this question in a real interview? 
Example
Given [4, 5, 6, 7, 0, 1, 2] return 0
 */
public class FindMinimuminRotatedSortedArray {

    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        int s = 0;
        int e = nums.length - 1;
        if(nums[s] <= nums[e]) return nums[s];
        while(s + 1 < e) {
            int m = s + (e-s)/2;
            if(nums[s] < nums[m]) {
                s = m;
            } else {
                e = m;
            }
        }
        return nums[s]<nums[e]?nums[s]:nums[e];
    }
}
