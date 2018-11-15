import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author jguan
 *
828. Word Pattern
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example
Given pattern = "abba", str = "dog cat cat dog", return true.
Given pattern = "abba", str = "dog cat cat fish", return false.
Given pattern = "aaaa", str = "dog cat cat dog", return false.
Given pattern = "abba", str = "dog dog dog dog", return false.

Notice
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        // write your code here
        if(pattern == null && teststr == null) return true;
        if(pattern == null || teststr == null) return false;
        String[] tests = teststr.split(" ");
        if(tests.length != pattern.length()) return false;
        
        HashMap<String, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < tests.length; i++) {
            String key = tests[i];
            char value = pattern.charAt(i);
            if(map.get(key) == null) {
                map.put(key, value);
                set.add(value);
            } else {
                if(map.get(key) != value) {
                    return false;
                }
            }
        }
        return set.size() == map.size();
    }
}
