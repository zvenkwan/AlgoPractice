package ArrayAndString;

import java.util.HashMap;
/**
 * 1. Two Sum
 * @author zg55
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.
 */
public class TwoSumII {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i< nums.length; i++) {
            if(hm.get(target-nums[i])!=null) {
                int j=hm.get(target-nums[i]);
                return new int[]{j,i};
            }
            if(hm.get(nums[i])==null)
                hm.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
