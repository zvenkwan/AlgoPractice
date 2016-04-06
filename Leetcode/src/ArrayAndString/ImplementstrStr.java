package ArrayAndString;
/**
 * 28. Implement strStr()
 * @author zg55
 *Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if("".equals(needle))
            return 0;
        for(int i=0;i<haystack.length()&&haystack.length()-i>=needle.length();i++) {
            for(int j=0;true;j++) {
                if(j==needle.length())
                    return i;
                if(i+j==haystack.length())
                    return -1;
                if(needle.charAt(j)!=haystack.charAt(i+j))
                    break;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
