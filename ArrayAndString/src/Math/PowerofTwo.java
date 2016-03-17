package Math;
/**
 * 231. Power of Two
 * @author zg55
 *Given an integer, write a function to determine if it is a power of two.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
//        example. 2^8=256 binary = 100000000
//        		255 binary = 11111111
//        		256&255==0
        return n>0&&(n&(n-1))==0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 256;
		String b = Integer.toBinaryString(n);
		String c = Integer.toBinaryString(n-1);
		System.out.println(b);
		System.out.println(c);
		System.out.println(256&255);
	}

}
