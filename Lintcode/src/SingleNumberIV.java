/**
 * 
 * @author jguan
 *824. Single Number IV
Description
Give an array, all the numbers appear twice except one number which appears once and all the numbers which appear twice are next to each other. Find the number which appears once.

1 <= nums.length < 10^4
In order to limit the time complexity of the program, your program will run 10^5 times.
Have you met this question in a real interview?  
Example
Given nums = [3,3,2,2,4,5,5], return 4.

Explanation:
4 appears only once.
Given nums = [2,1,1,3,3], return 2.

Explanation:
2 appears only once.
 */
public class SingleNumberIV {
    /**
     * @param nums: The number array
     * @return: Return the single number
     */
    public int getSingleNumber(int[] nums) {
        // Write your code here
        int i = 0;
        while( i < nums.length) {
            if(i + 1 >= nums.length) break;
            else {
                if(nums[i] == nums[i+1]) i+=2;
                else return nums[i];
            }
        }
        return nums[i];
    }
}
