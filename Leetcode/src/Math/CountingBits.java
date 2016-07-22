package Math;
/**
 * leetcode 338. Counting Bits 
 * @author zg55
 *Given a non negative integer number num. For every numbers i in the range 0 ¡Ü i ¡Ü num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
Hint:

You should make use of what you have produced already.
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
Or does the odd/even status of the number help you in calculating the number of 1s?
Credits:
Special thanks to @ syedee for adding this problem and creating all test cases.

Hide Tags Dynamic Programming Bit Manipulation
Hide Similar Problems (E) Number of 1 Bits

 */
public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public int[] countBits(int num) {
        int r[] =new int[num+1];
        int k=2;
        int s=1;
        while(k<=num) {
            fill(r, s, k);
            s=k;
            k=k+k;
        }
        fill(r, s, num+1);
        return r;
    }
    
    private void fill(int a[], int s, int e) {
        int i=0;
        while(s<e) {
            a[s] = a[i]+1;
            s++;
            i++;
        }
    }
//    Flip leftmost non-zero bit(Most significant bit) solution - java
//    public class Solution {
//    	public int[] countBits(int num) {
//    	int[] dp = new int[num+1];
//    	int flip = 1; //flipLeftMostNonZeroBit
//    	for (int i = 1; i <=num; i++) {
//    	while ( (flip<<1) <= i) {
//    	flip = flip<< 1;
//    	}
//    	dp[i] = dp[i ^ flip] + 1; // flip Left Most Non-Zero Bit
//    	}
//    	return dp;
//    	}
//    	}
}
