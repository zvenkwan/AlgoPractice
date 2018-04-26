
public class LastPositionofTarget {

    public int binarySearch(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length-1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target) {
                start = mid;
            } else { 
                end = mid;
            }
        }
        if(nums[end] == target) return end;
        if(nums[start] == target) return start;
        return -1;
    }
}
