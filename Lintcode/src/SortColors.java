/**
 * 
 * @author jguan
 *148. Sort Colors 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Notice
You are not suppose to use the library's sort function for this problem. 
You should do it in-place (sort numbers in the original array).

Have you met this question in a real interview? 
Example
Given [1, 0, 1, 2], sort it in-place to [0, 1, 1, 2].

Challenge 
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;
    public void sortColors(int[] nums) {
        // write your code here
        
        if(nums == null || nums.length < 2) return;
        int white_pointer = 0;
        int red_pointer = 0;
        int blue_pointer = nums.length - 1;
     // check equals, or the last might be missed
        while(red_pointer <= blue_pointer) {
            if(nums[red_pointer] == RED) {
                swap(nums, red_pointer, white_pointer);
                red_pointer++;
                white_pointer++;
            }
            
            else if (nums[red_pointer] == WHITE) {
                red_pointer++;
            }
            else {
                swap(nums, red_pointer, blue_pointer);
                blue_pointer--;
            }
        }
        
    }
    private void swap ( int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
