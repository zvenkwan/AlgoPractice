package ArrayAndString;
/**
 * leecode 260. Single Number III 
 * @author zg55
 *Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Hide Tags Bit Manipulation
Hide Similar Problems (E) Single Number (M) Single Number II

 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int n:nums)
            diff ^= n; //find bits that the two numbers we are looking for are different.
        diff = diff& ~(diff-1); //then keep the right most different bit. (or other bit would do the same)
        int[] r = {0,0};
        for(int n:nums) {
            if((n & diff) == 0)
                r[0]^=n;
            else
                r[1]^= n;
        }
        return r;
    }
}
