package Math;
/**
 * 9. Palindrome Number
 * @author zg55
 *Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
//    	this way would create a string, no extra space rule was voilated.
//        String s = Integer.toString(x);
//        int start=0, end=s.length()-1;
//        while(start<end) {
//        	if(s.charAt(start++)!=s.charAt(end--))
//        		return false;
//        }
//        return true;
        if(x<0) return false;
        else if(x<10) return true;
        else if(x%10==0) return false;
        int lowerhalf=0;
        while(lowerhalf<x) {
            lowerhalf=lowerhalf*10+x%10;
            x/=10;
        }
        return lowerhalf==x||lowerhalf/10==x;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1221;
		System.out.println(new PalindromeNumber().isPalindrome(x));
	}

}
