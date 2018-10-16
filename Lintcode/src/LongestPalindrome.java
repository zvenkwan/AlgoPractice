import java.util.HashMap;

/**
 * 
 * @author jguan
 *627. Longest Palindrome
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Example
Given s = "abccccdd" return 7

One longest palindrome that can be built is "dccaccd", whose length is 7.

Notice
Assume the length of given string will not exceed 1010.
 */

//add all even count to total
//add all odd count - 1 to total
//add all 1 to total if odd exists
public class LongestPalindrome {
	/**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        if(s == null || s.length() == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(char c: s.toCharArray()) {
            
            if(map.get(c) == null) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
            
        }
        boolean oddExists = false;
        int count = 0;
        for(char c: map.keySet()) {
            int n = map.get(c);
            if(n % 2 == 0) {
                count += n;
            } else {
                count += n - 1;
                oddExists = true;
            }
        }
        if(oddExists) count++;
        return count;
    }
}
