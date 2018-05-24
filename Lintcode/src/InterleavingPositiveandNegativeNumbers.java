/**
 * 
 * @author jguan
 *144. Interleaving Positive and Negative Numbers
Description
Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.

You are not necessary to keep the original order of positive integers or negative integers.

Have you met this question in a real interview?  
Example
Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other reasonable answer.

Challenge
Do it in-place and without extra memory.
 */

public class InterleavingPositiveandNegativeNumbers {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        if(A == null || A.length < 2) return;
        
        int even = 0;
        int odd = 1;
        
        int neg_value_cnt = 0;
        int pos_value_cnt = 0;
        for(int a:A) {
            if(a > 0) pos_value_cnt++;
            else neg_value_cnt++;
        }
        
        if(pos_value_cnt > neg_value_cnt) {
            even = 1;
            odd = 0;
        }
        
        while(even < A.length && odd < A.length) {
            while(even < A.length && A[even] < 0) {
                even+=2;
            }
            
            while(odd < A.length && A[odd] >0) {
                odd+=2;
            }
            
            if(even < A.length && odd < A.length) {
                int t = A[odd];
                A[odd] = A[even];
                A[even] = t;
                odd+=2;
                even+=2;
            }
        }
    }
}
