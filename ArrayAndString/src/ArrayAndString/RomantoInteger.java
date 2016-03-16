package ArrayAndString;
/**
 * 13. Roman to Integer
 * @author zg55
 *	Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
https://en.wikipedia.org/wiki/Roman_numerals
 */
public class RomantoInteger {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "DCXXI";
		System.out.println(new RomantoInteger().romanToInt(s));
	}
    public int romanToInt(String s) {
    	int result = 0;
    	int previous = 0;
        for(int i=s.length()-1; i>=0; i--) {
        	int current=getValue(s.charAt(i));
        	if(current<previous)
        		result-=current;
        	else
        		result+=current;
        	previous = current;
        }
        return result;
    }
	public int getValue(char romanSymbol) {
		switch (romanSymbol) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return 0;
		}
	}
}