package ArrayAndString;
/**
 * 165. Compare Version Numbers
 * @author zg55
 *Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int i=0, j=0, sum1=0, sum2=0;
        while(i<version1.length()||j<version2.length()) {
            while(i<version1.length()&&version1.charAt(i)!='.') {
                sum1=sum1*10+version1.charAt(i)-'0';
                i++;
            }
            while(j<version2.length()&&version2.charAt(j)!='.') {
                sum2=sum2*10+version2.charAt(j)-'0';
                j++;
            }
            if(sum1<sum2)
                return -1;
            if(sum1>sum2)
                return 1;
            i++;
            j++;
            sum1=0;
            sum2=0;
        }
        return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
