import java.util.Arrays;

/**
 * 
 * @author zg55
 *1478. Closest Target Value
Given an array, find two numbers in the array and their sum is closest to the target value but does not exceed the target value, return their sum.

Example
Input:target = 15
array = [1,3,5,11,7]
Output:14
Notice
if there is no result meet the requirement, return -1.
 */
public class ClosestTargetValue {
    /**
     * @param target: the target
     * @param array: an array
     * @return: the closest value
     */
    public int closestTargetValue(int target, int[] array) {
        // Write your code here
        if(array == null || array.length <= 1) return -1;
        int sum = Integer.MIN_VALUE;
        
        Arrays.sort(array);
        
        int i = 0;
        int j = array.length - 1;
        while(i < j) {
            int curr = array[i] + array[j];
            if(curr <= target) {
                i++;
                sum = Math.max(sum, curr);
            } else {
                j--;
            }
        }
        return sum == Integer.MIN_VALUE? -1 : sum;
    }


}
