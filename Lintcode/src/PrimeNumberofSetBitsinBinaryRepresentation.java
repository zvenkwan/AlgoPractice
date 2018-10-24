/**
 * 
 * @author zg55
 * 1046. Prime Number of Set Bits in Binary Representation

 *Description
Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

1.L, R will be integers L <= R in the range [1, 10^6].
2.R - L will be at most 10000.

Have you met this question in a real interview?  
Example
Example 1:

Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
Example 2:

Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
Related Problems
 */
public class PrimeNumberofSetBitsinBinaryRepresentation {
//be careful with n = 1 in prime problems
//	1 is not prime
	/**
     * @param L: an integer
     * @param R: an integer
     * @return: the count of numbers in the range [L, R] having a prime number of set bits in their binary representation
     */
    // HashMap<Integer, Boolean> isPrime = new HashMap<>();
    public int countPrimeSetBits(int L, int R) {
        // Write your code here
        int res = 0;
        for(int i = L; i <= R; i++) {
            int c = countBits(i);
            if(isPrime(c)) {
                res++;
            }
        }
        return res;
    }
    
    private int countBits(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
    boolean[] isPrime = {false, false, true, true, false, true,
            false, true, false, false, false,
            true, false, true, false, false,
            false, true, false, true, false
        };
    private boolean isPrime(int n) {
        // considering the range, result can be 0 to 20
        return isPrime[n];
        // if(n == 1) return false;
        // if(isPrime.get(n) == null) {
            
        //     for(int i = 2; i * i <= n; i++) {
        //         if(n % i == 0) {
        //             isPrime.put(n, false);
        //             return false;
        //         }
        //     }
            
        //     isPrime.put(n, true);
        //     return true;
            
        // } else {
        //     return isPrime.get(n);
        // }
    }
}
