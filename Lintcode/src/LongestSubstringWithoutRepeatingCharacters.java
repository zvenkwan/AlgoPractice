import java.util.HashMap;
/**
 * 
 * @author jguan
 *384. Longest Substring Without Repeating Characters
Description
Given a string, find the length of the longest substring without repeating characters.

Have you met this question in a real interview?  
Example
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

Challenge
O(n) time
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		int res = l.lengthOfLongestSubstring("abcabcbb");
		System.out.println(res);
	}

	

    public int lengthOfLongestSubstring(String s) {
//         1. load string to hashmap
//         2. return corner case
//         3. while(right pointer < length) {
//              plus or minus 1
//              right++
        // while loop deal with left
//         
        
        
//          }
        
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        
        int begin = 0;
        int end = 0;
        // int start = 0;
        int len = 0;
        int dup = 0;
        while(end < s.length()) {
            char curr = s.charAt(end);
            int crt = dict.get(curr) == null? 0: dict.get(curr);
            dict.put(curr, crt + 1);
            if(crt == 1) {
            	dup++;
            }
            end++;
            while(dup > 0) {
            	char first = s.charAt(begin);
            	int frt = dict.get(first);
            	if(frt > 1) {
            		dup--;
            	}
                dict.put(first, frt - 1);
                begin++;
            }
            if(end - begin >= len) {
            	len = end - begin;
            	// start = begin;
            }
        }
        return len;
        
    }
}
