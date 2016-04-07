package ArrayAndString;

import java.util.HashSet;

/**
 * 219. Contains Duplicate II
 * @author zg55
 *Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

Hide Company Tags Airbnb
Hide Tags Array Hash Table
Hide Similar Problems (E) Contains Duplicate (M) Contains Duplicate III

 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> map = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
            if(i>k) map.remove(nums[i-k-1]);
            if(!map.add(nums[i])) 
                    return true;
        }fsafsafda
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
