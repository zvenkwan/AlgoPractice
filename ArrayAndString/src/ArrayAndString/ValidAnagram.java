package ArrayAndString;
/**
 * 242. Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * @author guanziwen
 *
 */
public class ValidAnagram {
	
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())
			return false;
		int counter[] = new int[26];
		for(int i=0; i<s.length();i++) {
			counter[s.charAt(i)-'a']++;
			counter[t.charAt(i)-'a']--;
		}
		for(int i=0;i<counter.length;i++) {
			if(counter[i]!=0)
				return false;
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";
		System.out.println(new ValidAnagram().isAnagram(s,t));
	}

}
