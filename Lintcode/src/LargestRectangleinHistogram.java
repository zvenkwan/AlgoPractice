import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 
 * @author jguan
 *122. Largest Rectangle in Histogram
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

histogram

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

histogram

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example
Given height = [2,1,5,6,2,3],
return 10.
 */
public class LargestRectangleinHistogram {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        // use a stack to store increasing values
        if(height == null || height.length == 0) return 0;
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        
        int max = 0;
        int i = 0;
        for( ; i < height.length;) {
            if(stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int h = stack.poll();
                int area = 0;
                if(stack.isEmpty()) {
                    area = height[h] * i;
                } else {
                    area = height[h] * (i - stack.peek() - 1);
                }
                max = Math.max(area, max);
            }
            
        }
        
        while(!stack.isEmpty()) {
            int h = stack.poll();
            int area = 0;
            if(stack.isEmpty()) {
                area = height[h] * i;
            } else {
                area = height[h] * (i - stack.peek() - 1);
            }
            max = Math.max(area, max);
        }
        return max;
    }
}
