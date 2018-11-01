/**
 * 
 * @author jguan
 *101. Remove Duplicates from Sorted Array II
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesfromSortedArrayII {

    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        int size = 0;
        boolean prevdups = false;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] != nums[size]) {
                nums[++size] = nums[i];
                prevdups = false;
            } else {
                if(i == size) continue;
                if(!prevdups) {
                        nums[++size] = nums[i];
                        prevdups = true;
                }
            }
        }
        return size + 1;
    }

}
