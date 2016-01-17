package ArrayAndString;
import java.util.HashMap;
/**
 * leetcode 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * @author guanziwen
 *
 */
public class LongestSubstringWithoutRepeating {

	
	public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
        	return 0;
        HashMap hm = new HashMap();
        int count=0;
        int start=0;
        for(int i = 0; i < s.length(); i++) {
        	if(hm.get(s.charAt(i))==null) {
        		hm.put(s.charAt(i), i);
        		count=count>(i-start+1)?count:(i-start+1);
        	}
        	else {
        		start=start>(Integer)hm.get(s.charAt(i))+1?start:(Integer)hm.get(s.charAt(i))+1;
        		count=count>(i-start+1)?count:(i-start+1);
        		hm.put(s.charAt(i), i);
        	}
        	
        }
        return count;
    }
	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithoutRepeating().lengthOfLongestSubstring("pwwkew"));
	}

}
