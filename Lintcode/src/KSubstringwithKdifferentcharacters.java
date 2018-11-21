import java.util.HashMap;
import java.util.HashSet;
/**
 * 
 * @author jguan
 *
1639. K-Substring with K different characters
Given a string S and an integer K.
Calculate the number of substrings of length K and containing K different characters

Example
String: "abcabc"
K: 3

Answer: 3
substrings:  ["abc", "bca", "cab"]
String: "abacab"
K: 3

Answer: 2
substrings: ["bac", "cab"]
 */
public class KSubstringwithKdifferentcharacters {

    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        // Write your code here
        // check null and empty and non positive K
        // iterate from left to right
        // use local to remember count of unique char in current window
        // use array to remember occurrance of each letter
        // add char, if occ == 0, local++
        // remove left char, if occ = 0 local--
        // pay attention to duplicate values
        
        if(stringIn == null || stringIn.length() == 0) return 0;
        if(K <= 0) return 0;
        int local = 0;
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < stringIn.length(); i++ ) {
            char curr = stringIn.charAt(i);
            if(i < K - 1) {
                dict.put(curr, dict.getOrDefault(curr, 0) + 1);
                if(dict.get(curr) == 1) {
                    local++;
                }
            } else {
                dict.put(curr, dict.getOrDefault(curr, 0) + 1);
                if(dict.get(curr) == 1) {
                    local++;
                }
                if(local == K) {
                    set.add(stringIn.substring(i - K + 1, i + 1));
                }
                char remove = stringIn.charAt(i - K + 1);
                dict.put(remove, dict.get(remove) - 1);
                if(dict.get(remove) == 0) {
                    local --;
                }
            }
        }
        return set.size();
    }
}