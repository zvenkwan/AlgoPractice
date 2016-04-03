package ArrayAndString;
/**
 * 67. Add Binary
 * @author zg55
 *Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i=0;
        char one='0';
//        consider how to handle inputs with different lengths.
        while(i<a.length()||i<b.length()) {
            int sum = (i<a.length()?a.charAt(a.length()-i-1):'0')+(i<b.length()?b.charAt(b.length()-1-i):'0')+one;
            one = sum>='1'+'1'+'0'?'1':'0';
            char rs = (sum=='0'+'0'+'1')||(sum=='1'+'1'+'1')?'1':'0';
            result.insert(0,rs);
            i++;
        }
//        do not forget the highest digit that may encourage a 1 need carrying
        if(one=='1')
        	result.insert(0,'1');
        return result.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
