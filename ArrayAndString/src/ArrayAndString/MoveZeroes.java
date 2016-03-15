package ArrayAndString;
import java.util.Arrays;
/**283. Move Zeroes
 * 
 * @author zg55
 *Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
	
    public void moveZeroes(int[] nums) {
//    	count zero numbers
//    	int count = 0;
//        for(int i = 0; i < nums.length; i++) {
//        	if(nums[i]==0) {
//        		count++;
//        	}
//        	else {
//    			nums[i-count] = nums[i];
//        	}
//        }
//        for(int i = 0; i < count; i++) {
//            nums[nums.length-count+i] = 0;
//        }
    	
//    	count non zero numbers
        int nonZero = 0;
        for(int i = 0 ; i < nums.length; i ++) {
        	if(nums[i]!=0) {
        		nums[nonZero++] = nums[i];
        	}
        }
        for(int i = nonZero ; i < nums.length; i ++) {
        	nums[i] = 0;
        }
    }	
	public static void main(String[] args) {
		int nums[] = {0, 1, 0, 3, 12};
		System.out.println(Arrays.toString(nums));
		new MoveZeroes().moveZeroes(nums);
		System.out.println(Arrays.toString(nums));

	}

}
