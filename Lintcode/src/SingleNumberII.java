/**
 * 
 * @author jguan
 *83. Single Number II 
 Description
 Notes
 Testcase
 Judge
Discuss 
Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

Have you met this question in a real interview? 
Example
Given [1,1,2,3,3,3,2,2,4,1] return 4

Challenge 
One-pass, constant extra space.
 */
public class SingleNumberII {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumberII(int[] A) {
        // write your code here
        int[] bits = new int[32];
        int res = 0;
        for(int i = 0 ; i < 32; i++) {
            int sum = 0;
            for(int j = 0; j < A.length; j++) {
            // System.out.println("in "+ A[j] + ", "+ ((A[j] >> i) & 1));
                if( ((A[j] >> i) & 1) == 1) {
                    sum++;
                }
            }
            // System.out.println(sum);
            sum %= 3;
            
            res |= (sum<<i);
        }
        
        return res;
    }
}
