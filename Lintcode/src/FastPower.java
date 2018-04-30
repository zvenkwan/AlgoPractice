/**
 * 
 * @author jguan
 *140. Fast Power 
 Description
 Notes
 Testcase
 Judge
Discuss 
Calculate the an % b where a, b and n are all 32bit integers.

Have you met this question in a real interview? 
Example
For 231 % 3 = 2

For 1001000 % 1000 = 0

Challenge 
O(logn)
 */
public class FastPower {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if(n == 0) return 1%b;
        if(n == 1) return a%b;
        int h = n /2;
        long h_fp = fastPower(a, b, h);
        // System.out.println("h_fp " + + h + " "+h_fp );
        long p = h_fp * h_fp % b;
        if( (n & 1) == 1) {
            // odd
            p = p * a % b;
        }
        return (int)p;
    }
    
    public int fastPower2(int a, int b, int n) {
    	long res = 1;
		long tmp = a;
		while(n != 0) {
			if(n %2 == 1) {
				res = (res * tmp) % b;
			}
			tmp = (tmp * tmp) % b;
			n /=2;
		}
		return (int)res % b;
    }
}
