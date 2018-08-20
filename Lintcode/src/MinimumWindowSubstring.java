import java.util.HashMap;
/**
 * 
 * @author jguan
 *32. Minimum Window Substring
Description
Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

If there is no such window in source that covers all characters in target, return the emtpy string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.
The target string may contain duplicate characters, the minimum window should cover all characters including the duplicate characters in target.

Have you met this question in a real interview?  
Clarification
Should the characters in minimum window has the same order in target?

Not necessary.
Example
For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"

Challenge
Can you do it in time complexity O(n) ?
 */

// case: target string contains duplicate, eg "aaa"
public class MinimumWindowSubstring {
	public static void main(String[] args) {
		MinimumWindowSubstring m = new  MinimumWindowSubstring();
		String res = m.minWindow("babb", "baba");
		System.out.println(res);
	}
	

	public String minWindow(String s, String t) {
        if(s == null || t == null) return "";
        if(t.length() == 0 || s.length() < t.length()) return "";
        int len = Integer.MAX_VALUE;
        int begin = -1;
        int end = -1;
        int i = 0;
        int j = 0;
        int count = 0;
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        HashMap<Character, Integer> found = new HashMap<Character, Integer>();
        for(char c: t.toCharArray()) {
        	int cnt = dict.get(c) == null? 0:dict.get(c);
            dict.put(c, cnt + 1);
            found.put(c, 0);
        }
        
        while(i <= s.length() - t.length()) {
            char curr = s.charAt(i);
            if(dict.containsKey(curr)) break;
            i++;
        }
        if(i > s.length() - t.length()) return ""; 
        j = i - 1;
        while(i < s.length()) {
            if(count < t.length()) {
                j++;
                if(j == s.length()) break;
                char curr = s.charAt(j);
	            if(dict.containsKey(curr)) {
	                int c = found.get(curr);
	                if(c < dict.get(curr)) count++;
	                found.put(curr, c + 1);
	            }
            }
            else if(count == t.length()) {
                int newLen = j - i + 1;
                if(newLen <= len) {
                    begin = i;
                    end = j;
                    len = newLen;
                }
                
                char first = s.charAt(i);
                if(dict.containsKey(first)) {
                    int c = found.get(first);
                    if(c == dict.get(first)) count--;
                    found.put(first, c - 1);
                }
                i++;
            }
            
        }
        if(end == -1) return "";
        return s.substring(begin, end+ 1);
    }
}
