package ArrayAndString;
/**
 * leetcode 186. Reverse Words in a String II
 * @author guanziwen
 *	Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 *The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 *For example,
 *Given s = "the sky is blue",
 *return "blue is sky the".
 *Could you do it in-place without allocating extra space?
 */
public class ReverseWordsinString {
	
	public static void reverseWords(char[] s) {
        int slow = 0;
        int fast = 0;
        while(fast<s.length){
        	if(s[fast]==' ') {
        		if(slow!=fast-1) {
        			swapArray(s, slow, fast-1);
        			slow=fast+1;
        		}
        	}
        	fast++;
        }
        swapArray(s, slow, fast-1);
        swapArray(s, 0, s.length-1);
    }
	
	public static void swapArray(char[] s, int begin, int end) {
		while(begin<end){
			char temp = s[begin];
			s[begin] = s[end];
			s[end] = temp;
			begin++;
			end--;
		}
	}
	public static void main(String args[]) {
		String s = "the    sky  is blue";
		char[] c = s.toCharArray();
		reverseWords(c);
		System.out.println(c);
	}
}
