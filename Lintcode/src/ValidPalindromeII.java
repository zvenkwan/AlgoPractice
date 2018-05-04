/**
 * 
 * @author jguan
 *891. Valid Palindrome II
Description
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

Have you met this question in a real interview?  
Example
Given s = "aba" return true
Given s = "abca" return true // delete c
 */
public class ValidPalindromeII {
    /**
     * @param s: a string
     * @return: nothing
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        if(isPalin(s)) return true;
        int l =0;
        int r = s.length()-1;
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) {
                break;
            }
            l++;
            r--;
        }
        
        return isPalin(s.substring(l, r)) || isPalin(s.substring(l+1, r+1));
    }
    
    public boolean isPalin(String s) {
        if(s == null || s.length() == 0) return true;
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
