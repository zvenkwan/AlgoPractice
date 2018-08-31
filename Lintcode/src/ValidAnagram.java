/**
 * 
 * @author jguan
 *
158. Valid Anagram
Write a method anagram(s,t) to decide if two strings are anagrams or not.

Example
Given s = "abcd", t = "dcab", return true.
Given s = "ab", t = "ab", return true.
Given s = "ab", t = "ac", return false.

Challenge
O(n) time, O(1) extra space

Clarification
What is Anagram?

Two strings are anagram if they can be the same after change the order of characters.
 */
public class ValidAnagram {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if(s == t) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        int[] count = new int[128];
        for(char c: s.toCharArray()) {
            count[c]++;
        }
        for(char c: t.toCharArray()) {
            count[c]--;
        }
        for(int c: count) {
            if(c != 0) return false;
        }
        return true;
    }
}
