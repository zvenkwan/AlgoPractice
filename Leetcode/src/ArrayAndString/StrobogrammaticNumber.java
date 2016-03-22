package ArrayAndString;
/**
 * 246. Strobogrammatic Number
 * @author zg55
 *A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        int n = num.length()-1;
        int i=0;
        while(i<=n) {
        	if(num.charAt(i)!=getStrobogrammaticValue(num.charAt(n-i)))
        		return false;
        	i++;
        }
        return true;
    }
    private char getStrobogrammaticValue(char c) {
        switch(c) {
            case '0':
                return '0';
            case '1':
            	return '1';
//            case '2':
//            	return '2';
//            case '5':
//            	return '5';
            case '6':
            	return '9';
            case '8':
            	return '8';
            case '9':
            	return '6';
            	default:
            		return 'a';
                	
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StrobogrammaticNumber().isStrobogrammatic("2"));
	}

}
