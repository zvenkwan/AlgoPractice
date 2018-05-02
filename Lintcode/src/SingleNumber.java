/**
 * 
 * @author jguan
 *82. Single Number 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

Have you met this question in a real interview? 
Example
Given [1,2,2,1,3,4,3], return 4

Challenge 
One-pass, constant extra space.
 */
public class SingleNumber {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] nums) {
        // Write your code here
        int res = 0;
        for(int i: nums) {
            res ^= i;
        }
        return res;
    }
}
