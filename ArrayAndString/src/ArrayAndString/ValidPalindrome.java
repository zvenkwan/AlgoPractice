package ArrayAndString;

/**
 * leetcode 125. Valid Palindrome
 * @author guanziwen
 *	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *For example,
 *"A man, a plan, a canal: Panama" is a palindrome.
 *"race a car" is not a palindrome.
 *Note:
 *Have you consider that the string might be empty? This is a good question to ask during an interview.
 *For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		char c[] = s.toLowerCase().toCharArray();
		if(c.length<2)
			return true;
		else{
	        int start = 0;
	        int end = c.length-1;
	        while(start<=end) {
	        	if(!Character.isLetterOrDigit(c[start])){
	        		start++;
	        		continue;
	        	}
	        	if(!Character.isLetterOrDigit(c[end])){
	        		end--;
	        		continue;
	        	}
	        	if(c[start]==c[end]) {
	        		start++;
	        		end--;
	        		continue;
	        	} else 
	        		return false;
	        }
	        return true;
		}
    }
	public static void main(String[] args) {
		System.out.println(new ValidPalindrome().isPalindrome(""));
	}

}
