package ArrayAndString;
/**
 * 12. Integer to Roman
 * @author zg55
 *	Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
8ms
 */
public class IntegertoRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 3999;
		System.out.println(new IntegertoRoman().intToRoman(i));
	}
	public final int dec[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
    public String intToRoman(int num) {
		String result="";
//		while(num>0) {
		int i = dec.length-1;
		while(i>=0) {
//			int r = binarySearch(dec, 0, dec.length-1, num);
				String temp = getRoman(dec[i]);
				while(num>=dec[i]) {
					num-=dec[i];
					result=result+temp;
				}
				i--;
		}
		return result;
		
//	    String M[] = {"", "M", "MM", "MMM"};
//	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//	    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
    public int binarySearch(int nums[], int start, int end, int value) {
    	if(start==end)
    		return nums[start];
    	int mid = (start+end+1)/2;
    	if(nums[mid]<=value)
    		start=mid;
    	else 
    		end=mid-1;
    	return binarySearch(nums, start, end, value);
    }
	public String getRoman(int num) {
		switch(num) {
		case 1:
			return "I";
		case 4:
			return "IV";
		case 5:
			return "V";
		case 9:
			return "IX";
		case 10:
			return "X";
		case 40:
			return "XL";
		case 50:
			return "L";
		case 90:
			return "XC";
		case 100:
			return "C";
		case 400:
			return "CD";
		case 500:
			return "D";
		case 900:
			return "CM";
		case 1000:
			return "M";
			default:
				return "";
		}
	}
}
