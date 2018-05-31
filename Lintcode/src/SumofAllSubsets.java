/**
 * 
 * @author jguan
 *730. Sum of All Subsets
Description
Given a number n, we need to find the sum of all the elements from all possible subsets of a set formed by first n natural numbers.

Have you met this question in a real interview?  
Example
Given n = 2, return 6
Possible subsets are {{1}, {2}, {1, 2}}. Sum of elements in subsets
is 1 + 2 + 1 + 2 = 6

Given n = 3, return 24
Possible subsets are {{1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}
Sum of subsets is : 
1 + 2 + 3 + (1 + 2) + (1 + 3) + 
(2 + 3) + (1 + 2 + 3)
 */
public class SumofAllSubsets {
    /**
     * @param n: the given number
     * @return: Sum of elements in subsets
     */
    public int subSum(int n) {
        // write your code here
        if(n == 1) return 1;
        int sb = subSum(n-1);
        sb *= 2;
        sb += (int)Math.pow(2, n-1) * n;
        return sb;
        
    }
}
