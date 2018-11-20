/**
 * 
 * @author zg55
 *1546. Coin Problem
Ming is a salesman. After the customer bought something in his place and paid Ming a certain amount of money, Xiao Ming needs to return the extra money to the guest. The guest paid Xiao Ming n money, the price of Xiao Ming¡¯s commodity was m money, and the denomination that Xiao Ming can return to the guests can only be a combination of [100, 50, 20, 10, 5, 2, 1]. Now Xiao Ming wants to minimize the sum of the number of banknotes, please return to this minimum.

Example
Give n=100, m=29, return 3.

100-29=71
Ming retrieved one 50, one 20 and one 1.
So the answer is 3.
Give n=50, m=5, return 3.

50-5=45
Ming retrieved two 20 and one 5.
So the answer is 3.
 */
public class CoinProblem {
    /**
     * @param n: The guest paid
     * @param m: the price
     * @return: the sum of the number of banknotes
     */
     int[] face = {100, 50, 20, 10, 5, 2, 1};
    public int coinProblem(int n, int m) {
        // Write your code here
        if(n <= m || n < 0 || m < 0) return 0;
        return helper(n - m);
    }
    
    int helper(int x) {
        if(x == 0 ) return 0;
        
        for(int f: face) {
            if(x >= f) {
                int n = x/f;
                return n + helper(x - f*n);
            }
        }
        return 0;
    }


}
