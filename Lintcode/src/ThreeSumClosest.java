import java.util.Arrays;
/**
 * 
 * @author jguan
 *59. 3Sum Closest
Description
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Have you met this question in a real interview?  
Example
For example, given array S = [-1 2 1 -4], and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Challenge
O(n^2) time, O(1) extra space
 */
public class ThreeSumClosest {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if(numbers == null || numbers.length < 3) {
            return -1;
        }
        int diff = Integer.MAX_VALUE;
        int s = 0;
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 2; i++) {
            if(i != 0 && numbers[i] == numbers[i-1]) continue;
            int closestSum = twoSumClosest(i + 1, numbers, target - numbers[i]);
            int sum = closestSum + numbers[i];
            if(closestSum + numbers[i] == target) {
                return target;
            } else if(sum < target) {
                if(diff > target - sum) {
                    s = sum;
                    diff = target - sum;
                }
            } else {
                if(diff > sum - target) {
                    s = sum;
                    diff = sum - target;
                }
            }
        }
        return s;
    }
    //return sum of two
    public int twoSumClosest(int start, int[] numbers, int target) {
        int left = start;
        int right = numbers.length - 1;
        int diff = Integer.MAX_VALUE;
        int s = 0;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(target == sum) {
                return sum;
            } else if(target > sum) {
                if(diff > target - sum) {
                    s = sum;
                    diff = target - sum;
                }
                left++;
                while(left < right && numbers[left] == numbers[left-1]) {
                    left++;
                }
            } else {
                if(diff > sum - target) {
                    s = sum;
                    diff = sum - target;
                }
                right--;
                while(left < right && numbers[right] == numbers[right+1]) {
                    right--;
                }
            }
            
        }
        return s;
    }
}
