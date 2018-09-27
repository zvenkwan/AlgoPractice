/**
 * 
 * @author jguan
 *
1611. Shortest subarray
Given an array of positive integers and a positive integer K , find the length of a smallest contiguous subarray such that the number of this subarray is ≥ K .
Returns -1 if there are no subarrays that match the condition

Example
Given : nums = [2,3,1,2,4,3], k = 7
reuturn 2
Notice
1.Subarray has at least one element
 */
public class ShortestSubarray {
    /**
     * @param nums: 
     * @param k: 
     * @return: return the length of shortest subarray
     */
    public int smallestLength(int[] nums, int k) {
        // Write your code here
        if(nums == null || nums.length == 0) return -1;
        
        int sum = 0;
        int len = nums.length + 1;
        int left = 0;
        int right = 0;
        while(right != nums.length + 1) {
            if(sum >= k) {
                if(len >= right - left) {
                    len = right - left;
                }
                if(left >= 0) sum -= nums[left];
                left++;
            }
            else {
                if(right == nums.length) break;
                sum += nums[right];
                right++;
            }
        }
        return len == nums.length + 1? -1:len ;
    }
}
