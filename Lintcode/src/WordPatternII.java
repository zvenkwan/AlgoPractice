import java.util.HashMap;

/**
 * 
 * @author jguan
 *829. Word Pattern II
Description
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.(i.e if a corresponds to s, then b cannot correspond to s. For example, given pattern = "ab", str = "ss", return false.)

You may assume both pattern and str contains only lowercase letters.

Have you met this question in a real interview?  
Example
Given pattern = "abab", str = "redblueredblue", return true.
Given pattern = "aaaa", str = "asdasdasdasd", return true.
Given pattern = "aabb", str = "xyzabcxzyabc", return false.
 */
public class WordPatternII {

	/**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        HashMap<Character, String> map = new HashMap<>();
        return dfs(map, pattern, str);
    }
    
    private boolean dfs(HashMap<Character, String> map, String pattern, String str) {
        
        if(pattern.length() == 0) {
            return str.length() == 0;
        }
        
        char key = pattern.charAt(0);
        
        if(map.get(key) != null) {
            String value = map.get(key);
            if(str.startsWith(value)) {
                return dfs(map, pattern.substring(1), str.substring(map.get(key).length()));
            } else {
                return false;
            }
        }
        
        
        for(int i = 0; i < str.length(); i++) {
            
            String value = str.substring(0, i + 1);
            if(map.containsValue(value)) continue;
            map.put(key, value);
            if(dfs(map, pattern.substring(1), str.substring(i + 1))) {
                return true;
            }
            map.remove(key);
            
        }
        return false;
    }
	
}
