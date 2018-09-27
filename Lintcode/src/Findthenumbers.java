/**
 * 
 * @author jguan
 *
1610. Find the numbers
Give a Fibonacci sequence and an integer n at the beginning of 0,1, find the numbers that larger and smaller than n ,than return the numbers.

Example
n = 4
Return : [3,5]
n = -1
Return : []
Notice
n must be in the range of 32-bit integers
if n < 0, return null
 */
public class Findthenumbers {
    /**
     * @param n: the integer
     * @return: the numbers that larger and smaller than `n` 
     */
    public int[] getNumbers(int n) {
        // Write your code here
        if(n < 0) return new int[0];
        if(n == 0) return new int[]{1};
        if(n == 1) return new int[]{0, 2};
        int first = 0;
        int second = 1;
        int curr = first + second;
        int[] res = new int[2];
        while(curr <= n) {
            if(second < n) {
                res[0] = second;
            } else {
                res[0] = first;
            }
            curr = first + second;
            first = second;
            second = curr;
        }
        res[1] = curr;
        return res;
    }
}
