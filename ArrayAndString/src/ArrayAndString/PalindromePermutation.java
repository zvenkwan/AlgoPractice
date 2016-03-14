package ArrayAndString;

/**
 * 266. Palindrome Permutation Easy
 * @author zg55
 *Given a string, determine if a permutation of the string could form a palindrome.
 *For example,
 *"code" -> False, "aab" -> True, "carerac" -> True.
 *Hint:
 *Consider the palindromes of odd vs even length. What difference do you notice?
 *Count the frequency of each character.
 *If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if(s==null)
			return false;
//		if(s.length()%2==0) {
//			int temp=0;
//			for(char i : s.toCharArray()) {
//				temp^=i;
//			}
//			return temp==0;
//		}
//		else {
			int set[] = new int[128];
			int sum = 0;
			for(char i : s.toCharArray()) {
//				set to 1 when set[i] is 0
				set[i]=1-set[i];
//				sum+1 when set[i] is 1
//				sum-1 when set[i] is 0
				sum=sum+set[i]+set[i]-1;
			}
			return sum<=1;
//		}
    }
	public static void main(String[] args) {
		char a = 'a';
		char b = 'b';
		char g = 'g';
		int i = 'a'^'b';
		System.out.println((int)g);
		System.out.println(i);
		System.out.println(i^'d');
//		s=abdg, bitwise not working
		System.out.println(i^'d'^'g');
		String s = "abdg";
		System.out.println(new PalindromePermutation().canPermutePalindrome(s));
		
	}

}
