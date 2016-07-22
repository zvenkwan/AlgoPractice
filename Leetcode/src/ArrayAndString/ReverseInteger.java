package ArrayAndString;
/**
 * leetcode 7. Reverse Integer
 * @author zg55
 *Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.

Hide Company Tags Bloomberg Apple
Hide Tags Math
Hide Similar Problems (E) String to Integer (atoi)

 */
public class ReverseInteger {
    public int reverse(int x) {
        int r =0;
        while ( x != 0) {
            int t = r*10 + x%10;
            if((t-x%10)/10 != r) return 0;
            r = t;
            x/=10;
        }
        return r;
    }
    
    public static void main(String s[]) {
    	int i = -2147483412;
    	new ReverseInteger().reverse(i);
    }
}
