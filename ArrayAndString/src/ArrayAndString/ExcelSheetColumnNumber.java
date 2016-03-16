package ArrayAndString;
/**171. Excel Sheet Column Number
 * 
 * @author zg55
 *Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
    	int num = 0;
        for(int i = 0; i < s.length(); i++) {
        	num = (s.charAt(i)-'A'+1)+num*26;
        }
        return num;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("BXX"));
	}

}
