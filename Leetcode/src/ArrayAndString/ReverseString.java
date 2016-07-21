package ArrayAndString;
/**
 * leetcode 344. Reverse String 
 * @author zg55
 *Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

Hide Tags Two Pointers String
Hide Similar Problems (E) Reverse Vowels of a String

 */
public class ReverseString {
    public String reverseString(String s) {
        char c[] = s.toCharArray();
        int l = 0;
        int r = c.length-1;
        while(l<r) {
            char t = c[l];
            c[l] = c[r];
            c[r] = t;
            l++;
            r--;
        }
        return String.valueOf(c);
    }
}
