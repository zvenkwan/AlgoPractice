import java.util.LinkedList;
/**
 * 
 * @author jguan
 *1616. Shortest subarray II
Given an array of integers and a positive integer K , find the length of a smallest contiguous subarray such that the number of this subarray is ≥ K ,return the length of subarray. if there are no subarrays that match the condition,return -1.

Example
Given : nums = [2,-1,2], k = 3
Return 3
Given : nums = [2,-1,2,-1,4,2], k = 5
Return 2
Notice
1.1 <= nuns.length <= 50000
2.-10 ^ 5 <= nums[i] <= 10 ^ 5
3.1 <= K <= 10 ^ 9
 */
public class ShortestsubarrayII {
    /**
     * @param nums: 
     * @param k: 
     * @return: return the length of subarray
     */
    public int smallestLengthII(int[] nums, int k) {
        // Write your code here
        
        if(k < 0) return -1;
        if(nums == null || nums.length == 0) return -1;
        int[] sums = new int[nums.length + 1];
        for(int i = 1 ; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
        int len = nums.length + 1;
        
        // this queue only stores [INDEX]
        // put index in the front if qualified
        
        // replace the last one if the item is smaller (which gives a more possible chance to find a number is K greater than it)
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < sums.length; i++) {
            // keep removing last one if the current is smaller
            while(!queue.isEmpty() && sums[i] <= sums[queue.getLast()]) {
                queue.removeLast();
            }
            
            while(!queue.isEmpty() && sums[i] >= sums[queue.getFirst()] + k) {
                // find qualified case, update len, and remove the used index from First
                len = Math.min(len, i - queue.removeFirst());
            }
            
            // add current index to last of queue
            queue.addLast(i);
            
        }
        
        if(len == nums.length + 1) return -1;
        else return len;
    }
}
