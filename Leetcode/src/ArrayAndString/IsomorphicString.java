package ArrayAndString;
import java.util.HashMap;
/**
 * 205. Isomorphic Strings
 * @author zg55
 *Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> h = new HashMap<Character, Character>();
        for(int i=0;i<s.length();i++) {
            if(h.get(s.charAt(i))==null) {
                if(h.containsValue(t.charAt(i))) 
                    return false;
                h.put(s.charAt(i), t.charAt(i));
            }
            else if(h.get(s.charAt(i))!=t.charAt(i))
                    return false;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
