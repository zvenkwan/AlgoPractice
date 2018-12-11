package interviews.gg;

import java.util.ArrayList;

/**
 * 
 * @author jguan
 * 
1633. Strings That Satisfies The Condition
 *Description
Given a string target and a string array s, output all strings containing target(ie target is a subsequence of s[i]) in their original order in the array s

s.length<=1000
1<=the sum of strings’ length in s,target<=100000

Have you met this question in a real interview?  
Example
Given target="google",s=["goooogle","abc","google","higoogle","googlg","gowogwle","gogle"],Return ["goooogle","google","higoogle","gowogwle"]

Explanation:
goooogle
google
higoogle
gowogwle
 */
public class StringsThatSatisfiesTheCondition {
    /**
     * @param target: the target string
     * @param s: 
     * @return: output all strings containing target  in s
     */
    public String[] getAns(String target, String[] s) {
        // Write your code here
        ArrayList<String> list = new ArrayList<String>();
        for(String word: s) {
            if(containsTarget(word, target)) {
                list.add(word);
            }
        }
        
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }
    
    private boolean containsTarget(String word, String target) {
        if(word == null || target == null) return false;
        if(word.length() < target.length()) return false;
        
        int found = 0;
        for(int i = 0, j = 0; i < target.length(); i++) {
            while(j < word.length()) {
                if(word.charAt(j) == target.charAt(i)) {
                    found++;
                    j++;
                    break;
                } else {
                    j++;
                }
            }
            if(found == i + 1) {
                if(found == target.length()) return true;
                else continue;
            } else {
                return false;
            }
        }
        
        return false;
    }


}
