package ArrayAndString;
/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = ¡°eceba¡±,
 * T is "ece" which its length is 3.
 * @author guanziwen
 *
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		
//		int i = 0;
//        int j = -1;
//        int maxLen = 0;			
//        
//        for (int k = 1; k < s.length(); k++) {
//            if (s.charAt(k) == s.charAt(k-1))
//                continue;
//            if (j >= 0 && s.charAt(k) != s.charAt(j)) {
//                maxLen = Math.max(maxLen, k-i);
//                i = j+1;
//                System.out.println("ichar is "+i);
//            }
//            j = k-1;
//        }
//        return Math.max(s.length() - i, maxLen);
//		
        if(s==null)
        	return 0;
        if(s.length()<=2)
        	return s.length();
//        length >=3
        int start=0;
        int ichar1=0;
        int ichar2=0;
        int maxLength=2;
        for(int i=1;i<s.length();i++) {
        	if(s.charAt(i)==s.charAt(ichar1)) {
        		ichar1=i;
        	}
        	else {
        		ichar2=i;
        		break;
        	}
        }
        if(0==ichar2)
        	return s.length();
        
    	for(int i=1+ichar2;i<s.length();i++) {
    		if(s.charAt(i)==s.charAt(ichar1)) {
    			ichar1=i;
    			continue;
    		}
    		else if(s.charAt(i)==s.charAt(ichar2)) {
    			ichar2=i;
    			continue;
    		}
			maxLength=Math.max(maxLength, i-start);
			start=Math.min(ichar1, ichar2)+1;
			ichar1=i-1;
			ichar2=i;
    	}
        return Math.max(maxLength, s.length()-start);
    }
	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithAtMostTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct("abaaaccc"));
	}

}
