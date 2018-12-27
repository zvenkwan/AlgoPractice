import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author jguan
 *147. Narcissistic Number
Narcissistic Number is a number that is the sum of its own digits each raised to the power of the number of digits. See wiki

For example the 3-digit decimal number 153 is a narcissistic number because 153 = 13 + 53 + 33.

And the 4-digit decimal number 1634 is a narcissistic number because 1634 = 14 + 64 + 34 + 44.

Given n, return all narcissistic numbers with n digits.

Example
Given 1, return [0,1,2,3,4,5,6,7,8,9].

Given 2, return [].

Notice
You may assume n is smaller than 8.
 */
public class NarcissisticNumber {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> results = new ArrayList<Integer>();
        if(n <= 0) return results;
        
        int start = 0;
        if(n > 1) {
            start = (int)Math.pow(10, n - 1);
        }
        int end = (int) Math.pow(10, n);
        while(start < end) {
            if(isNarcissistic(start)) {
                results.add(start);
            }
            start++;
        }
        return results;
    }
    
    private boolean isNarcissistic(int num) {
        String s = num + "";
        int n = s.length();
        int sum = 0;
        for(int i = 0 ; i < n; i ++) {
            sum = sum + (int) Math.pow(s.charAt(i) - '0', n);
        }
        // System.out.println(sum);
        return sum == num;
    }


}
