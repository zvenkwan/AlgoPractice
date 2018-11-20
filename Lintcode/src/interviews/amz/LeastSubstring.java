package interviews.amz;
/**
 * 
 * @author jguan
 *
1638. Least Substring
Given a string containing n lowercase letters, the string needs to divide into several continuous substrings, the letter in the substring should be same, and the number of letters in the substring does not exceed k, and output the minimal substring number meeting the requirement.

Example
Give s = "aabbbc", k = 2, return 4

Explaination:
we can get "aa", "bb", "b", "c" four substring.
Give s = "aabbbc", k = 3, return 3

Explaination:
we can get "aa", "bbb", "c" three substring.
Notice
n \leq 1e5n≤1e5
 */
public class LeastSubstring {
    /**
     * @param s: the string s
     * @param k: the maximum length of substring
     * @return: return the least number of substring
     */
    public int getAns(String s, int k) {
        // Write your code here
        // check if null or empty
        // check if k is not positive
        // use a count to remember
        // iterate from left to right, increase count when: local count equals to k 
        // or next is different or next is the end
        if(s == null || s.length() == 0) return 0;
        
        int count = 0;
        int local = 0;
        for(int i = 0; i < s.length(); i++) {
            if(local == k) {
                count++;
                local = 1;
                
                
            } else {
                local++;
                
            }
            char curr = s.charAt(i);
            if(i == s.length() - 1) {
                count++;
            } else if(curr != s.charAt(i + 1)) {
                local = 0;
                count++;
            }
        }
        return count;
    }


}
