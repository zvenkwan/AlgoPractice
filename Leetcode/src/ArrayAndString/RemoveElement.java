package ArrayAndString;
/**
 * 27. Remove Element
 * @author zg55
 *Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

Hint:

Try two pointers.
Did you use the property of "the order of elements can be changed"?
What happens when the elements to remove are rare?
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0) 
            return 0;
        int l=0;
        int r=nums.length-1;
        int valCount = 0;
        while(l<=r) {
            if(nums[l]==val) {
                if(nums[r]!=val) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;
                } 
                r--;
                valCount++;
            } else {
                l++;
            }
        }
        return nums.length-valCount;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
