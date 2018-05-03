import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jguan
 *84. Single Number III
Description
Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

Have you met this question in a real interview?  
Example
Given [1,2,2,3,4,4,5,3] return 1 and 5

Challenge
O(n) time, O(1) extra space.
 */
public class SingleNumberIII {
    /*
     * @param A: An integer array
     * @return: An integer array
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        int diff = 0;
        for(int a:A) {
            diff ^= a;
        }
        // pick one bit and divide the array into 2 groups: same and not same;
        int div = 1;
        while((div & diff) == 0) {
            div <<= 1;
        }
        
        int res1 = 0;
        int res2 = 0;
        for(int a:A) {
            if((a & div) == 0) 
                res1 ^= a;
            else    res2 ^=a;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(res1);
        res.add(res2);
        return res;
    }
}
