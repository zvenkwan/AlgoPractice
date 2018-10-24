/**
 * 
 * @author zg55
 *1324. Count Primes
Count the number of prime numbers less than a non-negative number, n.


 */
public class CountPrime {

	/**
     * @param n: a integer
     * @return: return a integer
     */
    public int countPrimes(int n) {
        // write your code here
//    	less than 2 or less equals than 2
//    	less than 2, create an array of n elements
//    	less equals, create an array of n + 1 elements
        if(n <= 2) return 0;
        if(n == 3) return 1;
        boolean[] nonPrime = new boolean[n];
        nonPrime[0] = true;
        nonPrime[1] = true;
        int count = 0;
        for(int i = 2; i < nonPrime.length; i++) {
            int curr = i;
            // System.out.println(curr + "is " + !nonPrime[curr] + "prime");
            if(!nonPrime[curr]) count++;
            while(curr < n) {
                nonPrime[curr] = true;
                curr += i;
            }
        }
        return count;
    }
}
