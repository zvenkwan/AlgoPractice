/**
 * 190. Reverse Bits
 * @author zg55
 *Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?

Related problem: Reverse Integer
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result=0;
        for(int i=0;i<31;i++) {
            result|=n&1;
            result<<=1;
            n>>>=1;
        }
        result|=n&1;
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.toBinaryString(11));
		System.out.println(new ReverseBits().reverseBits(964176192));
	}

}
