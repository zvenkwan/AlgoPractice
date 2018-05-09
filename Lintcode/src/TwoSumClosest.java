/**
 * 
 * @author jguan
 *Two Sum Closest
 *Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.
 */
public class TwoSumClosest {
	/**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
    	if(nums == null || nums.length < 2) return -1;
    	
    	int left = 0;
    	int right = nums.length - 1;
    	int diff = Integer.MAX_VALUE;
    	while (left < right) {
    		int sum = nums[left] + nums[right];
    		if(target == sum) {
    			return 0;
    		} else if( target > sum) {
    			diff = Integer.min(diff, target - sum);
    			left++;
    		} else {
    			diff = Integer.min(diff, sum - target);
    			right--;
    		}
    	}
    	return diff;
    }
}
