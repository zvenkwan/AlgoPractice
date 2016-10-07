package Math;
/**
 * leetcode 371. Sum of Two Integers
 * @author zg55
 *Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.

Credits:
Special thanks to @fujiaozhu for adding this problem and creating all test cases.

Hide Company Tags Hulu
Hide Tags Bit Manipulation
Hide Similar Problems (M) Add Two Numbers

 */
public class SumofTwIntegers {
    public int getSum(int a, int b) {
        if(b == 0) return a;
//        a^b add two numbers without carry
//        a&b find the digit of both numbers are 1
//        a&b <<1 change the number to carry and finally add those two numbers.
        return getSum(a^b, (a&b)<<1);
    }
}
