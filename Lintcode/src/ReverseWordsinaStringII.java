/**
 * 
 * @author jguan
 *927. Reverse Words in a String II
Given an input character array, reverse the array word by word. A word is defined as a sequence of non-space characters.

The input character array does not contain leading or trailing spaces and the words are always separated by a single space.

Example
Given s = "the sky is blue",
after reversing : "blue is sky the"

Challenge
Could you do it in-place without allocating extra space?
 */
public class ReverseWordsinaStringII {

    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        // write your code here
        if(str == null || str.length <= 1) return str;
        int startOfWord = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i] == ' ') {
                reverse(str, startOfWord, i-1);
                startOfWord = i+1;
            }
        }
        // reverse was not executed when i hit end of array
        reverse(str, startOfWord, str.length - 1);
        reverse(str, 0, str.length - 1);
        return str;
    }
    
    public void reverse(char[] str, int from, int to) {
        while(from < to) {
            char temp = str[from];
            str[from] = str[to];
            str[to] = temp;
            from++;
            to--;
        }
    }
}
