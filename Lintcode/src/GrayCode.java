import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jguan
 *411. Gray Code
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, find the sequence of gray code. A gray code sequence must begin with 0 and with cover all 2n integers.

Example
Given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Challenge
O(2n) time.

Notice
For a given n, a gray code sequence is not uniquely defined.

[0,2,3,1] is also a valid gray code sequence according to the above definition.
 */
public class GrayCode {
    /**
     * @param n: a number
     * @return: Gray code
     */
    public List<Integer> grayCode(int n) {
        // write your code here
        
        // find list of graycode(n-1)
        // add 1 to to the front of each element in the list
        // consider there is only 1 bit differece, reverse the above list and add it to graycode(n-1) from the last to the first
        
        List<Integer> list = new ArrayList<Integer>();
        if(n < 0) return list;
        if(n == 0) {
            list.add(0);
            return list;
        }
        int a = 1 << (n - 1);
        
        List<Integer> firstHalf = grayCode(n - 1);
        
        list.addAll(new ArrayList<Integer>(firstHalf));
        
        for(int i = firstHalf.size() - 1; i >= 0;i--) {
            list.add(firstHalf.get(i) ^ a);
        }
        
        return list;
    }

}
