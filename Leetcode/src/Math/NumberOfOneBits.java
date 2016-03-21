package Math;
/**
 * 191. Number of 1 Bits
 * @author zg55
 *Write a function that takes an unsigned integer and returns the number of ¡¯1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ¡¯11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int count=0;
//        bit manipulation
        while(n>0) {
        	n=n&(n-1);
        	count++;
        }
//        while(n>0) {
//            if(n%2==1)
//            count++;
//            n/=2;
//        }
        
        // String b = Integer.toBinaryString(n);
        // for(char i:b.toCharArray()) {
        //     if(i=='1')
        //     count++;
        // }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NumberOfOneBits().hammingWeight(2147483647));
	}

}
