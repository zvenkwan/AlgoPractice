package ArrayAndString;
/**
 * leetcode 136. Single Number 
 * @author zg55
 *Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Hide Company Tags Palantir Airbnb
Hide Tags Hash Table Bit Manipulation
Hide Similar Problems (M) Single Number II (M) Single Number III (M) Missing Number (H) Find the Duplicate Number

 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int r=0;
        for(int i=0;i<nums.length;i++) {
            r^=nums[i];
        }
        return r;
    }
}
