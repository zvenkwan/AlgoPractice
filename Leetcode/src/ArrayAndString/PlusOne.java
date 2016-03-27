package ArrayAndString;
/**
 * 66. Plus One
 * @author zg55
 *Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        while(i>=0&&digits[i]==9) {
            i--;
        }
        int result[] = null;
        if(i>=0) {
            i = digits.length-1;
            while(digits[i]==9) {
                digits[i]=0;
                i--;
            }
            digits[i]+=1;
            return digits;
        } else {
            result = new int[digits.length+1];
            result[0]=1;
            return result;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
