package ArrayAndString;
import java.util.HashMap;
/**
 * 325. Maximum Size Subarray Sum Equals k
 * @author zg55
 *Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
 */
public class MaximumSizeSubarraySumEqualsk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxSubArrayLen(int[] nums, int k) {
        int count=0, sum=0;
        HashMap<Integer, Integer> m=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            m.putIfAbsent(sum,i+1);
            if(sum==k)
            count=i+1;
            else if(m.containsKey(sum-k))
            count=Math.max(count, i+1-m.get(sum-k));
        }
        return count;
    }
}
