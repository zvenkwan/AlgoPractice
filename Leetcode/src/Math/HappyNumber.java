package Math;
/**
 * 202. Happy Number
 * @author zg55
 *Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
https://en.wikipedia.org/wiki/Happy_number
 */
public class HappyNumber {
	
    public boolean isHappy(int n) {
    	if(n<=0)
    		return false;
    	int x = n;
    	int sum = 0;
//    	Numbers that are happy, follow a sequence that ends in 1. All non-happy numbers follow sequences that reach the cycle:
//
//    		4, 16, 37, 58, 89, 145, 42, 20, 4, ...
//    	otherwise we can use hashset to check if has occurred
        while(sum!=1&&sum!=4) {
        	sum=0;
        	while(x>0) { 
        		sum+=Math.pow(x%10,2);
        		x/=10;
        	}
    		System.out.println("sum is "+sum);
        	x=sum;
        }
        return sum==1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(new HappyNumber().isHappy(19));
		System.out.println(new HappyNumber().isHappy(18));
		System.out.println(new HappyNumber().isHappy(17));
		System.out.println(new HappyNumber().isHappy(16));
		System.out.println(new HappyNumber().isHappy(15));
		System.out.println(new HappyNumber().isHappy(14));
		System.out.println(new HappyNumber().isHappy(13));
	}

}
