package Math;
/**
 * leetcode 342. Power of Four
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Credits:
Special thanks to @yukuairoy for adding this problem and creating all test cases.

Hide Company Tags Two Sigma
Hide Tags Bit Manipulation
Hide Similar Problems (E) Power of Two (E) Power of Three

 * @author zg55
 *
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if(num<1) return false;
        if(num==1) return true;
        //or use num&0x55555555 to see the 1 is on even digit
        return isPowerOfTwo(num) && (num%10==4 || num%10==6);
    }
    public boolean isPowerOfTwo(int num) {
        return (num & (num-1)) == 0;
    }
}
