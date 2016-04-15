package Math;
/**
 * 169. Majority Element
 * @author zg55
 *Given an array of size n, find the majority element. The majority element is the element that appears more than floor( n/2 ) times.

You may assume that the array is non-empty and the majority element always exist in the array.
 Zenefits
Hide Tags Divide and Conquer Array Bit Manipulation
Hide Similar Problems (M) Majority Element II
https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
 */
public class MajorityElement {
    // moore voting algorithm
	public int majorityElement(int[] num) {
        int maj = num[0];
        int count = 0;
        for(int i:num) {
            if(count==0) {
                maj=i;
                count++;
            }
            else if(i==maj)
                count++;
            else
                count--;
        }
        return maj;
    }
	public static void main(String[] args) {
		int nums[]={1,2,4,4,3,2,4,100,4,4,4,4};
		for(int i:nums){
			System.out.println(Integer.toBinaryString(i));
		}
		System.out.println(new MajorityElement().majorityElement(nums));
//		System.out.println(Integer.toBinaryString(3));
//		System.out.println(3^1);
	}
}