import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if(nums1 == null || nums2 == null||nums1.length == 0 || nums2.length == 0) return new int[0]; 
        // two pointer
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<Integer>();
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            else if(nums1[i] > nums2[j]) {
                j++;
                continue;
            }
            int same = nums1[i];
            list.add(same);
            while(++i<nums1.length && nums1[i]==same){}
            while(++j<nums2.length && nums2[j]==same){}
        }
        int[] res = new int[list.size()];
        for(int a=0; a<list.size(); a++) {
            res[a] = list.get(a);
        }
        // binary search
        // Arrays.sort(nums1);
        // Set<Integer> set = new HashSet<Integer>();
        // for(int n: nums2) {
        //     if(binarySearch(nums1, n)!=-1)
        //         set.add(n);
        // }
        // int[] res = new int[set.size()];
        // int i=0;
        // for(int n:set) {
        //     res[i++] = n;
        // }
        
        // hash
        // List<Integer> list = new ArrayList<Integer>();
        // Set<Integer> set = new HashSet<Integer>();
        // for(int n: nums1) {
        //     set.add(n);
        // }
        // for(int n:nums2) {
        //     // does not have to check if it is in the set before removing, try removing it
        //     if(set.remove(n)) {
        //         list.add(n);
        //     }
        // }
        
        // int[] res = new int[list.size()];
        // for(int i=0; i<list.size(); i++) {
        //     res[i] = list.get(i);
        // }
        return res;
    }
    
    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + ( end - start ) / 2;
            if(nums[mid] == target) 
                return mid;
            else if (nums[mid] < target) 
                start = mid;
            else
                end = mid;
        }
        if(nums[start] == target) return start;
        else if(nums[end] == target) return end;
        return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
