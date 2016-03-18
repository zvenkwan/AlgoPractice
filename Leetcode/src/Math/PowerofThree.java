package Math;
/**
 * 326. Power of Three
 * @author zg55
 *Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
https://leetcode.com/discuss/78532/summary-all-solutions-new-method-included-at-15-30pm-jan-8th
 */
public class PowerofThree {
	public boolean isPowerOfThree(int n) {
//	    return n > 0 && (1162261467 % n == 0);
	    /*
	     * there are also some other ways:
	     * 1.check log base 3 if it is an integer
	     * 2.save all integer power of 3 in an array
	     * 3.transfer to base 3 (san jin zhi shu) , power of three will be
	     * 		a number like this 1, 10, 100, 1000, 1000000...
	     * 	 similar to power of 2 will be number like 10, 100, 1000 in (base 2) binary
	     */
		
//		3rd way mentioned above, however a slower way than 1162261467%n method
		return Integer.toString(n, 3).matches("10*");//regex 10* means 1 and k 0s with k>=0
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxPowerOfThree = (int)Math.pow(3, (int)(Math.log(0x7fffffff) / Math.log(3)));

		System.out.println(maxPowerOfThree);
		System.out.println(0x7fffffff);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(new PowerofThree().isPowerOfThree(1));
	}

}
