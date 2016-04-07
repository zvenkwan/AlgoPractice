package ArrayAndString;

import java.util.HashSet;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null) {
	        return false;
	    }
	    int[] hashTable = new int[nums.length];
	    for(int num: nums) {
	    	int i = num-Integer.MIN_VALUE;
	    	hashTable[i] = num;
	    }
	    for (int i = 0; i < hashTable.length; i++) {
	        hashTable[i] = Integer.MIN_VALUE;
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int h = nums[i] % nums.length;
	        h = h >= 0 ? h : h + nums.length;
	        while (hashTable[h] != Integer.MIN_VALUE) {
	            if (nums[i] == hashTable[h]) {
	                return true;
	            } else {
	                h = (h + 1) % nums.length;
	            }
	        }
	        hashTable[h] = nums[i];
	    }
	    return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(-1%10);
	}

}
