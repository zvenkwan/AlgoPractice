package ArrayAndString;
/**
 * 38. Count and Say
 * @author zg55
 *The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 */
public class CountandSay {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String s = countAndSay(n-1);
        StringBuffer result=new StringBuffer();
        int count=0;
        char prev=s.charAt(0);
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==prev) {
                count++;
            } else {
                result.append(count).append(prev);
                prev=s.charAt(i);
                count=1;
            }
        }
                result.append(count).append(prev);
        return result.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
