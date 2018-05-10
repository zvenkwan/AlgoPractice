/**
 * 
 * @author jguan
 *31. Partition Array
Description
Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

If all elements in nums are smaller than k, then return nums.length

Have you met this question in a real interview?  
Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.

Challenge
Can you partition the array in-place and in O(n)?
 */
public class PartitionArray {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            if(nums[l] < k) l++;
            else if(nums[r] < k) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                l++;
                r--;
            } else {
                r--;
            }
        }
        if(nums[l]>=k) return l;
        return l+1;
    }
}
