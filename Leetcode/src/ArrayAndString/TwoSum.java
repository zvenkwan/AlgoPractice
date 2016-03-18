package ArrayAndString;
/**
 * leetcode 167. Two Sum II - Input array is sorted
 * @author guanziwen
 *	Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *	The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *	You may assume that each input would have exactly one solution.
 *	Input: numbers={2, 7, 11, 15}, target=9
 *	Output: index1=1, index2=2
 */
public class TwoSum {
	public static int[] twoSum(int[] numbers, int target) {
        int slow = 0;
        int fast = numbers.length - 1;
        if(numbers.length <2) 
        	return null;
        else {
        	int result[] = null;
	        while(fast>slow) {
		        if(numbers[slow] + numbers[fast] > target) {
		        		fast--;
		        } else if(numbers[slow] + numbers[fast] < target){
		        		slow++;
		        } else {
		        	result = new int[]{numbers[slow], numbers[fast]};
//		        	return indexes of two numbers
		        	result = new int[]{slow+1, fast+1};
		        	return result;
		        }
	        }
	        return result;
        }
    }
	
	public static void main(String args[]) {
		int a[] = {2,7,11,15};
		int result[] = twoSum(a, 9);
		System.out.println(result[0]+ ", "+ result[1]);
	}
}
