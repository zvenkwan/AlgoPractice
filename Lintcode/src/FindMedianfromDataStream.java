import java.util.Collections;
import java.util.PriorityQueue;
/**
 * 
 * @author zg55
 *81. Find Median from Data Stream
Numbers keep coming, return the median of numbers at every time a new number added.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

For numbers coming list: [2, 20, 100], return [2, 2, 20].

Challenge
Total run time in O(nlogn).

Clarification
What's the definition of Median?

Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
 */
public class FindMedianfromDataStream {

	/**
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return new int[0];
        
        int[] res = new int[nums.length];
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i = 0 ; i < nums.length; i ++) {
            
            int curr = nums[i];
            
            maxHeap.offer(curr);
            
            if(maxHeap.size() - minHeap.size() >= 2) {
                minHeap.offer(maxHeap.poll());
            } else {
                if(!minHeap.isEmpty()) {
                    int max = maxHeap.peek();
                    int min = minHeap.peek();
                    if(max > min) {
                        maxHeap.poll();
                        minHeap.poll();
                        maxHeap.offer(min);
                        minHeap.offer(max);
                    }
                }
            }
            
            res[i] = maxHeap.peek();
        }
        return res;
    }
}
