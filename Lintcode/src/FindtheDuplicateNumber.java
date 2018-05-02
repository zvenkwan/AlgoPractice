/**
 * 
 * @author jguan
 *633. Find the Duplicate Number 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

 Notice
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n^2).
There is only one duplicate number in the array, but it could be repeated more than once.
Have you met this question in a real interview? 
Example
Given nums = [5,5,4,3,2,1] return 5
Given nums = [5,4,4,3,2,1] return 4
 */
public class FindtheDuplicateNumber {
    /**
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // write your code here
    	
//    	the idea is putting the value to the index of the value in this array
//    	if the target is already of the same value, return it
        for(int i = 0; i < nums.length ; ) {
            int target = nums[i];
            if(target != nums[target])
                swap(nums, i , target);
            else {
                if(target != i) return target;
                else i++;
            }
        }
        return -1;
    }
    
    public void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }
}
