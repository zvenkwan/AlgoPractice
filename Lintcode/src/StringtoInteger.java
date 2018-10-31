/**
 * 
 * @author zg55
 *54. String to Integer (atoi)
Description
Implement function atoi to convert a string to an integer.

If no valid conversion could be performed, a zero value is returned.

If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

Have you met this question in a real interview?  
Example
"10" => 10
"-1" => -1
"123123123123123" => 2147483647
"1.0" => 1
 */
public class StringtoInteger {
	/**
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        // write your code here
        if(str == null || str.length() == 0) return 0;
        
        boolean isPositive = true;
        int i = 0;
        str = str.trim();
        if(str.indexOf("-") == 0) {
            isPositive = false;
            i++;
        } else if(str.indexOf("+") == 0) {
            isPositive = true;
            i++;
        } else {
            isPositive = true;
        }
        
        long sum = 0;
        
        while(i < str.length()) {
            
            char c = str.charAt(i);
            if(!Character.isDigit(c)) {
                break;
            }
            
            int n = Character.getNumericValue(c);
            sum = sum * 10 + n;
            i++;
            if (sum > Integer.MAX_VALUE ) {
                break;
            }
        }
        
        if(sum > Integer.MAX_VALUE && isPositive) {
            return Integer.MAX_VALUE;
        } else if(sum - 1 > Integer.MAX_VALUE && !isPositive) {
            return Integer.MIN_VALUE;
        } else if(isPositive) {
            return (int)sum;
        } else {
            return (int)-sum;
        }
        
    }
}
