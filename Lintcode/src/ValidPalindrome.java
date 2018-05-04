/**
 * 
 * @author jguan
 *415. Valid Palindrome
Description
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Have you met this question in a real interview?  
Example
"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Challenge
O(n) time without extra memory.
 */
public class ValidPalindrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if(s == null || s.length() == 0) return true;
        int l = 0;
        int r = s.length() - 1;
        while(l<r) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if(!Character.isLetterOrDigit(lc)) {
                l++;
            }
            else if(!Character.isLetterOrDigit(rc)) {
                r--;
            }
            else if(Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
