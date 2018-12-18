package interviews.wyfr;
/**
 * 
 * @author jguan
 *13. Implement strStr()
For a given source string and a target string, you should output the first index(from 0) of target string in source string.

If target does not exist in source, just return -1.

Example
If source = "source" and target = "target", return -1.

If source = "abcdabcdefg" and target = "bcd", return 1.

Challenge
O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)

Clarification
Do I need to implement KMP Algorithm in a real interview?

Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. But make sure you confirm with the interviewer first.
 */
public class ImplementstrStr {
    /**
     * @param source: 
     * @param target: 
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        
        if(source == null || target == null) return -1;
        if(target.length() > source.length()) return -1;
        if(target.length() == 0) return 0;
        int[] kmp = buildKMP(target);
        int j = 0;
        int i = 0;
        while(i < source.length() && j < target.length()) {
            if(source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                if(j != 0) {
                    j = kmp[j-1];
                } else {
                    i++;
                }
            }
        }
        System.out.println(j);
        if(j == target.length()) {
            return i - target.length();
        }
        
        return -1;
    }
    
    // kmp array is array store the index of a substring whose suffix is also a prefix
    // this array can be helpful during substring search so we know this suffix is also a prefix
    // which means when it fails at one point, we can safely skip the prefix(because suffix has matched already) and continue the search
    private int[] buildKMP(String target) {
        int[] kmp = new int[target.length()];
        
        int j = 0;
        int i = 1;
        while(i < kmp.length) {
            if(target.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = kmp[j-1];
                }
            }
        }
        return kmp;
    }
}
