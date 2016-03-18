package ArrayAndString;
/**
 * leetcode.com Q26
 * @author guanziwen
 *	Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 *	Do not allocate extra space for another array, you must do this in place with constant memory.
 *	For example,
 *	Given input array nums = [1,1,2],
 *	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSorted {

	public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        if(nums.length <= 1)
        	return nums.length;
        else {
        	while(fast < nums.length) {
        		if(nums[slow] == nums[fast]) {
        			fast++;
        		} else {
        			slow++;
        			nums[slow] = nums[fast];
        		}
        	}
        	return slow+1;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,1,2};
		int l = removeDuplicates(a);
		System.out.println("length is " +l);

	}

}
