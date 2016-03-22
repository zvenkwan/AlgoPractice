package Math;
/**
 * 263. Ugly Number
 * @author zg55
 *Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {

    public boolean isUgly(int num) {
//        if(num<1)
//			return false;
//        String s="";
//        if(num>1) {
//            while((num&1)==0) {
//                num>>>=1;
//            }
//    // 		return isUgly(num);
//        }
//		if(num>1&&num%3==0) {
//			s=Integer.toString(num, 3).replaceAll("0+$", "");
//			num=Integer.valueOf(s, 3);
//    // 		return isUgly(num);
//		}
//		if(num>1&&num%5==0) {
//			s=Integer.toString(num, 5).replaceAll("0+$", "");
//			num=Integer.valueOf(s, 5);
//    // 		return isUgly(num);
//		}
//		return num==1;
    	
    	
//    	recursive
      if(num<1) return false;
      if(num==1) return true;
      while(num%2==0) 
    	  num/=2;
      while(num%3==0)
    	  num/=3;
      while(num%5==0)
    	  num/=5;
      return num==1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
