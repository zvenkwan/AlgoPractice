package ArrayAndString;

import java.util.HashMap;
/**
 * 290. Word Pattern
 * @author zg55
 *Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.


Hide Company Tags Dropbox
Hide Tags Hash Table
Hide Similar Problems (E) Isomorphic Strings (H) Word Pattern II

 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String words[] = str.split(" ");
        if(words.length!=pattern.length()) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        for(int i=0;i<pattern.length();i++) {
            if(map.get(pattern.charAt(i))==null) 
                map.put(pattern.charAt(i), words[i]);
            else if(map.get(pattern.charAt(i))!=words[i])
                return false;
        }
        return true;
    }
	public static void main(String[] args) {
	}

}
